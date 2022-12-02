package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ClientMain extends Design implements ActionListener{
	/**
	 * default serial number
	 */
	private static final long serialVersionUID = 1L;
	
	static final String PROTOCOL_SEPARATOR = "#";
	static final String FIELD_SEPARATOR = ",";
	static final String PROTOCOL_END = "P0";
	static final String PROTOCOL_SENDGAME = "P1";
	static final String PROTOCOL_RECVGAME = "P2";
	static final String PROTOCOL_DATA = "P3";
	
	static String DEFAULT_USER = "Soomin";
	static String DEFAULT_ADD = "localhost";
	static int DEFAULT_PORT = 1234;
	
	JFrame clientFrame = new JFrame("");
	JPanel clientPanel = new JPanel();
	
	JPanel ctopPanel = new JPanel(); // panel for top
	JPanel cmiddlePanel = new JPanel();
	JPanel cbottomPanel = new JPanel();
	
	JLabel userLabel = new JLabel("User: ");
	JTextField userTextField = new JTextField(5);
	JLabel serverLabel = new JLabel("Server: ");
	JTextField serverTextField = new JTextField(10);
	JLabel cportLabel = new JLabel("Port: ");
	JTextField cportTextField = new JTextField(4);
	JButton connectBtn = new JButton("Connect");
	JButton cendBtn = new JButton("End");
	
	JButton newGameBtn = new JButton("New Game");
	JButton sendGameBtn = new JButton("Send Game");
	JButton receiveGameBtn = new JButton("Receive Game");
	JButton sendDataBtn = new JButton("Send Data");
	JButton playBtn = new JButton("Play");
	
	
	ImageIcon ctopImage = new ImageIcon(
			"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/N.jpg");
	
	static JTextArea cresultTextArea = new JTextArea(""); //text field for result
	
	String username;
	String serverName;
	String portNumberString;
	int portNumberInt;
	
	
	ClientMain(){
		clientFrame.setSize(900,500);
		clientFrame.setTitle("Game Client");
		clientFrame.setResizable(false); //cannot change the window size
		clientFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		clientFrame.getContentPane().setBackground(Color.WHITE);
		
		clientPanel.setLayout(new GridLayout(3,1,5,5));
		clientPanel.setBorder(BorderFactory.createEmptyBorder(50,100,20,100)); //border for padding
		//******top panel*******************************
		ctopPanel.setLayout(new BorderLayout());
		
		Image ima = ctopImage.getImage();
		Image changedImage = ima.getScaledInstance(50, 50, Image.SCALE_SMOOTH); //change the image size
		ImageIcon changedIcon = new ImageIcon(changedImage);
		JLabel imageLabel = new JLabel(changedIcon);
		
		ctopPanel.add(imageLabel, BorderLayout.CENTER); //put image on top
		clientPanel.add(ctopPanel);
		
		//********middle panel*****************************
		cmiddlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		cmiddlePanel.add(userLabel);
		cmiddlePanel.add(userTextField);
		cmiddlePanel.add(serverLabel);
		cmiddlePanel.add(serverTextField);
		cmiddlePanel.add(cportLabel);
		cmiddlePanel.add(cportTextField);
		
		connectBtn.setFont(font3);
		cendBtn.setFont(font3);
		
		connectBtn.setBackground(Color.WHITE);
		cendBtn.setBackground(Color.LIGHT_GRAY);
		
		connectBtn.addActionListener(this);
		cendBtn.addActionListener(this);
		
		cmiddlePanel.add(connectBtn);
		cmiddlePanel.add(cendBtn);
		
		cmiddlePanel.add(newGameBtn);
		cmiddlePanel.add(sendGameBtn);
		cmiddlePanel.add(receiveGameBtn);
		cmiddlePanel.add(sendDataBtn);
		cmiddlePanel.add(playBtn);
		
		newGameBtn.setBackground(Color.WHITE);
		sendGameBtn.setBackground(Color.WHITE);
		receiveGameBtn.setBackground(Color.WHITE);
		sendDataBtn.setBackground(Color.WHITE);
		playBtn.setBackground(Color.WHITE);		
		
		newGameBtn.setFont(font3);
		sendGameBtn.setFont(font3);
		receiveGameBtn.setFont(font3);
		sendDataBtn.setFont(font3);
		playBtn.setFont(font3);
		
		newGameBtn.addActionListener(this);
		sendGameBtn.addActionListener(this);
		receiveGameBtn.addActionListener(this);
		sendDataBtn.addActionListener(this);
		playBtn.addActionListener(this);
		
		newGameBtn.setEnabled(false);
		sendGameBtn.setEnabled(false);
		receiveGameBtn.setEnabled(false);
		sendDataBtn.setEnabled(false);
		playBtn.setEnabled(false);
		
		clientPanel.add(cmiddlePanel);
		//*******bottom panel*******************
		cbottomPanel.setLayout(new BorderLayout());
		cbottomPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Message")); // set border for mode
		cresultTextArea.setEditable(false); //cannot edit this text field
		cresultTextArea.setFont(font3); //set font
		cbottomPanel.add(cresultTextArea, BorderLayout.CENTER); //add to bottom panel
		clientPanel.add(cbottomPanel);
		
		//********set frame visible
		clientFrame.add(clientPanel);
		clientFrame.setVisible(true);
	} //ClientMain end
	static void addResult(String str) {
		cresultTextArea.append(str + "\n");
		cresultTextArea.setCaretPosition(cresultTextArea.getDocument().getLength()); //position to last result line
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == connectBtn) {
			username = userTextField.getText();
			serverName = serverTextField.getText();
			portNumberString = cportTextField.getText();
			
			addResult("You clicked connect button");
			
			if(!(userTextField.getText().equals("")) && !(serverTextField.getText().equals("")) && !(cportTextField.getText().equals(""))) {
				addResult("Hi, " + username + ". Connecting to server " + serverName + " at port number " + portNumberString);
				
				portNumberInt = Integer.parseInt(portNumberString); //change to int
				
				Client client = new Client();
				client.start(portNumberInt, serverName);
				
				newGameBtn.setEnabled(true);
				sendGameBtn.setEnabled(true);
				receiveGameBtn.setEnabled(true);
				sendDataBtn.setEnabled(true);
				playBtn.setEnabled(true);
			} else {
				addResult("Please type all information");
			} //if else end
			if(e.getSource() == cendBtn) {
				addResult(username+PROTOCOL_SEPARATOR+PROTOCOL_END);
				clientFrame.dispose();
			}
		} //if end
		
		if(e.getSource() == newGameBtn) {
			
		} //if end

		if (e.getSource() == sendGameBtn) {
			addResult(username+PROTOCOL_SEPARATOR+PROTOCOL_SENDGAME+PROTOCOL_SEPARATOR+";Number;1,2,3,4,5,6,7,8,9,0");
		} // if end

		if (e.getSource() == receiveGameBtn) {
			addResult(username+PROTOCOL_SEPARATOR+PROTOCOL_RECVGAME);
		} // if end

		if (e.getSource() == sendDataBtn) {
			addResult(username+PROTOCOL_SEPARATOR+PROTOCOL_DATA+PROTOCOL_SEPARATOR);
		} // if end

		if (e.getSource() == playBtn) {
			clientFrame.dispose();
			GameController gc = new GameController();
		} // if end
	} // actionPerformed end
	
} //CleintMain class end
