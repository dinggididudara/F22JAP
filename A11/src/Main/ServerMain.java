package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ServerMain extends Design implements ActionListener{
	/**
	 * default serial number
	 */
	private static final long serialVersionUID = 1L;
	JFrame serverFrame = new JFrame("");
	JPanel serverPanel = new JPanel();
	
	
	JPanel topPanel = new JPanel(); // panel for top
	JPanel middlePanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	JLabel portLabel = new JLabel("Port: ");
	JTextField portTextField = new JTextField(20);
	JButton startBtn = new JButton("Start");
	JButton resultBtn = new JButton("Result");
	JButton endBtn = new JButton("End");
	
	
	ImageIcon topImage = new ImageIcon(
			"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/N.jpg");
	
	static JTextArea resultTextArea = new JTextArea(); //text field for result
	JScrollPane sscrollPane = new JScrollPane(resultTextArea);
	/**
	 * ServerMain() : set up the frame for server side and start new server with user input port
	 */
	ServerMain(){
		f.dispose();
		serverFrame.setSize(900,400);
		serverFrame.setTitle("Game Server");
		serverFrame.setResizable(false); //cannot change the window size
		serverFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		serverFrame.getContentPane().setBackground(Color.WHITE);
		
		serverPanel.setLayout(new GridLayout(3,1,5,5));
		serverPanel.setBorder(BorderFactory.createEmptyBorder(50,100,10,100)); //border for padding
		//******top panel*******
		topPanel.setLayout(new BorderLayout());
		
		Image ima = topImage.getImage();
		Image changedImage = ima.getScaledInstance(50, 50, Image.SCALE_SMOOTH); //change the image size
		ImageIcon changedIcon = new ImageIcon(changedImage);
		JLabel imageLabel = new JLabel(changedIcon);
		
		topPanel.add(imageLabel, BorderLayout.CENTER); //put image on top
		serverPanel.add(topPanel);
		
		
		//********middle panel*****
	
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		middlePanel.add(portLabel);
		middlePanel.add(portTextField);
		
		startBtn.setFont(font3);
		resultBtn.setFont(font3);
		endBtn.setFont(font3);
		
		startBtn.setBackground(Color.WHITE);
		resultBtn.setBackground(Color.LIGHT_GRAY);
		endBtn.setBackground(Color.WHITE);
		
		startBtn.addActionListener(this);
		resultBtn.addActionListener(this);
		endBtn.addActionListener(this);
		
		middlePanel.add(startBtn);
		middlePanel.add(resultBtn);
		middlePanel.add(endBtn);
		
		serverPanel.add(middlePanel);
		
		
		//*******bottomPanel********
		
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Result")); // set border for mode
		resultTextArea.setEditable(false); //cannot edit this text field
		resultTextArea.setFont(font3); //set font
		bottomPanel.add(sscrollPane, BorderLayout.CENTER); //add to bottom panel
		serverPanel.add(bottomPanel);
		
		//********set frame visible
		serverFrame.add(serverPanel);
		serverFrame.setVisible(true);
	} //server end
/**
 * addResult : add the result log in the result text field	
 * @param str message want to show in the frame
 */
	static void addResult(String str) {
		resultTextArea.append(str + "\n");
		resultTextArea.setCaretPosition(resultTextArea.getDocument().getLength()); //position to last result line
	}
	/**
	 * actionPerformed : handle all actions including button click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String portStr = portTextField.getText(); // save port number
		int port = Integer.parseInt(portStr);// casting
		if(e.getSource()==startBtn) {
			addResult("You clicked Start button");
			if(!(portTextField.getText().equals(""))) { //if it is not empty
				addResult("Your Port Number is :" + portStr);
				Server server = new Server(); // start new server
				server.start(port); // start server with port number
				addResult("New Server Activate Now!");
				if (e.getSource() == resultBtn) {
					server.getMessage();
				}
			} else { //if text field is empty
				addResult("Please enter port number");
			} //if else end
		} //if end
		//if click end button, close the window
		if (e.getSource() == endBtn) {
			addResult("Disconnecting from port "+portStr);
			serverFrame.dispose();
		} // if end
		
		
	} //actionPerformed end
} //serverMain class end


