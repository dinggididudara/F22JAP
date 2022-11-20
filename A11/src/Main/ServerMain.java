package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	JTextArea resultTextArea = new JTextArea(""); //text field for result
	
	
	ServerMain(){
		serverFrame.setSize(900,300);
		serverFrame.setTitle("Game Server");
		
		serverFrame.setResizable(false); //cannot change the window size
		serverFrame.setLayout(new GridLayout(3,1,5,5));
		serverFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		serverFrame.getContentPane().setBackground(Color.WHITE);
		
		//******top panel*******
		topPanel.setLayout(new BorderLayout());
		
		Image ima = topImage.getImage();
		Image changedImage = ima.getScaledInstance(50, 50, Image.SCALE_SMOOTH); //change the image size
		ImageIcon changedIcon = new ImageIcon(changedImage);
		JLabel imageLabel = new JLabel(changedIcon);
		
		topPanel.add(imageLabel, BorderLayout.CENTER); //put image on top
		serverFrame.add(topPanel);
		
		
		//********middle panel*****
	
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		middlePanel.add(portLabel);
		middlePanel.add(portTextField);
		
		startBtn.setFont(font3);
		endBtn.setFont(font3);
		resultBtn.setFont(font3);
		
		startBtn.setBackground(Color.WHITE);
		resultBtn.setBackground(Color.GRAY);
		endBtn.setBackground(Color.WHITE);
		
		startBtn.addActionListener(this);
		resultBtn.addActionListener(this);
		endBtn.addActionListener(this);
		
		middlePanel.add(startBtn);
		middlePanel.add(resultBtn);
		middlePanel.add(endBtn);
		
		serverFrame.add(middlePanel);
		
		
		//*******bottomPanel********
		
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Result")); // set border for mode
		resultTextArea.setEditable(false); //cannot edit this text field
		resultTextArea.setFont(font3); //set font
		bottomPanel.add(resultTextArea, BorderLayout.CENTER); //add to bottom panel
		serverFrame.add(bottomPanel);
		
		//********set frame visible
		serverFrame.setVisible(true);
	} //server end
	
	boolean isNumber(String s) {
		try {
			Integer.parseInt(s); //casting
			return true;
		} catch (NumberFormatException e) {
			addResult("Please Enter Number");
			return false;
		}
	} //is Number end
	
	void addResult(String str) {
		resultTextArea.append(str + "\n");
		resultTextArea.setCaretPosition(resultTextArea.getDocument().getLength()); //position to last result line
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startBtn) {
			addResult("You clicked Start button");
			String portStr = portTextField.getText(); //save port number
			if(isNumber(portStr)) {
				int port = Integer.parseInt(portStr);//casting
				addResult("Your Port Number is :" + portStr);
				
				Server server = new Server(); //start new server
				server.start(port); //start server with port number
				addResult("New Server!"); 
				
				Client client = new Client(); //new client
				client.start(port);
				addResult("New Client!");
				
				
			} else if (portTextField.getText() == null){ //if text field is null
				addResult("Please enter port number");
			} //if else end
			
		} //if end
		
		if(e.getSource() == endBtn) {
			serverFrame.dispose(); //close the window
		} //if end
	} //actionPerformed end
}
