/**
 * File Name : Main.java
 * Identification : Soomin113
 * Course : CST8221 - JAP, Lab Section : 302
 * Assignment : A11
 * Professor : Paulo Sousa
 * Date : 
 * Compiler : Eclipse IDE
 * Purpose : Number Puzzle - main class
 */
package NumPuz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Class Name : Main
 * Methods List :
 * Constants List : 
 * Purpose :
 * 
 *  @author Soomin
 *
 */
public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//frame
		JFrame f = new JFrame(""); //create frame
		f.setSize(800,600); //size
		f.setTitle("Number Puzzle Game"); //set window title
		f.setResizable(false); //cannot change the window size
		f.setLayout(new GridLayout(1,0,80,80)); //divide window in two
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); //if click close button
		
		f.getContentPane().setBackground(Color.white);
		
//*****************************************************************************number panel		
		ImageIcon pinkbtn = new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/pinkbtn.png");
		JPanel numberPanel = new JPanel(); //set panel for numbers
		numberPanel.setBackground(Color.white);
		numberPanel.setLayout(new GridLayout(3,3,10,10)); //add grid layout to panel 1
		numberPanel.setBorder(BorderFactory.createEmptyBorder(10,30,30,30));
		JButton[] buttonArr = new JButton[8]; //button array
		int[] randomArr = new int[8]; //random number array is zero
		Random random = new Random(); //random method
		for(int i=0; i<8; i++) {
			for(int j=0;j<i;j++) { //check if has same number
				randomArr[i] = random.nextInt(7)+1; //add random number maximum 9 but no zero
					if(randomArr[i] == randomArr[j]) {
						i--;
					} //if end
			} //for end
			buttonArr[i]= new JButton(""+randomArr[i]);
//			buttonArr[i]= new JButton(""+(i+1));
		} //if end
		for(int z=0;z<8;z++) { //add button except the last button for moving
			buttonArr[z].setIcon(pinkbtn);
			numberPanel.add(buttonArr[z]);
		}
//**************************************************************************right panel		
		JPanel rightPanel = new JPanel(); //second panel for choice box
		
		rightPanel.setBackground(Color.white);
		rightPanel.setLayout(new GridLayout(0,1)); //set layout
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JPanel modePanel = new JPanel(); //panel for mode
		JPanel designPanel = new JPanel(); //panel for design
		JPanel playPanel = new JPanel(); //panel for level
		JPanel imagePanel = new JPanel(); //panel for image
		JPanel timePanel = new JPanel(); //panel for time
		JPanel resetPanel = new JPanel();//panel for reset button
		
//		modePanel.setBackground(Color.white);
		
//*******************************************************************mode panel		
		rightPanel.add(new JLabel("Mode")); //1st label is mode
		JRadioButton designButton = new JRadioButton("Design", true); //radio button already checked by default
		JRadioButton playButton = new JRadioButton("Play");
		ButtonGroup radioButtonGroup = new ButtonGroup(); //only can choose one of button
		radioButtonGroup.add(designButton);radioButtonGroup.add(playButton); //make group for mode
		modePanel.add(designButton); //add both panel to the frame
		modePanel.add(playButton);
		rightPanel.add(modePanel);
		
//******************************************************************design panel		
		String[] dimArr = {"3","4","5"}; //array for dimension choices
		JComboBox dimension = new JComboBox(dimArr);
		rightPanel.add(new JLabel("Dimension"));
		designPanel.add(dimension);
		rightPanel.add(designPanel);

//************************************************************************play panel		
		rightPanel.add(new JLabel("Level"));
		String[] levelArr = {"[Select]","1","2","3"}; //has three levels
		JComboBox level = new JComboBox(levelArr);
		playPanel.add(level);
		rightPanel.add(playPanel);
		
//		rightPanel.add(new JLabel("Points: "));
//		JTextField points = new JTextField("0"); //text field for points, zero by default
//		points.setEditable(false); //user cannot edit this point
//		rightPanel.add(points); //add text field, 0 by default
		
//****************************************************************************image panel 		
		
		ImageIcon blankImage = new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/image.png"); //get image from folder
		
		JLabel imageLabel = new JLabel(blankImage); //put image into label
		imageLabel.setIcon(blankImage); //set label to icon
		imagePanel.add(imageLabel);
		rightPanel.add(imagePanel);
		
//**************************************************************************time panel		
		rightPanel.add(new JLabel("Time"));
		JTextArea timerTextArea = new JTextArea("0"); //text area for timer
		timerTextArea.setEditable(false);
//		ActionListener playButtonListener = new ActionListener() { //action listener for play button
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int time = 0;
//				Timer timer = new Timer();
//				timer.setRepeats(false);
//				timer.start();
//				time += 1;
//				timerTextArea.append(String.valueOf(time)); // start the timer and add text area in panel
//			}}; //playButtonListener end
			timePanel.add(timerTextArea);
			rightPanel.add(timePanel);
//*******************************************************************reset panel		
		JButton resetButton = new JButton("Reset");
		resetPanel.add(resetButton);
		rightPanel.add(resetPanel);		
		
//******************************************************************add to frame		
		f.add(numberPanel);
		f.add(rightPanel);
		
		f.setVisible(true); //window appear in the screen, hidden default
	} //main end
	/*
	 * Method name :
	 * Purpose : 
	 * Algorithm :
	 * @param
	 * @return
	 */
	
	
	
} //Main class end
