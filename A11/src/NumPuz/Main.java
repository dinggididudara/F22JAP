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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Class Name : 
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
		f.setSize(600,800); //size
		f.setTitle("Number Puzzle"); //set window title
		f.setResizable(false); //cannot change the window size
		f.setLayout(new GridLayout(1,2)); //divide window in two
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); //if click close button
		
		JPanel panel1 = new JPanel(); //set panel for numbers
		
		panel1.setLayout(new GridLayout(3,3)); //add grid layout to panel 1
//		panel1.setBackground(Color.black); //set grid color
		JButton[] buttonArr = new JButton[8]; //button array
		int[] randomArr = new int[8]; //random number array is zero
		Random random = new Random(); //random method
		for(int i=0; i<8; i++) {
			randomArr[i] = random.nextInt(7)+1; //add random number maximum 9 but no zero
			for(int j=0;j<i;j++) { //check if has same number
					if(randomArr[i] == randomArr[j]) {
						i--;
					} //if end
			} //for end
			buttonArr[i]= new JButton(""+randomArr[i]);
//			buttonArr[i]= new JButton(""+(i+1));
		} //if end
		for(int z=0;z<7;z++) { //add button except the last button for moving
			panel1.add(buttonArr[z]);
		}
		
		JPanel panel2 = new JPanel(); //second panel for choice box
//		panel2.setLayout(new GridLayout(8,0));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER)); //set flow layout and center
		
		
		JRadioButton designButton = new JRadioButton("Design", true); //radio button already checked by default
		JRadioButton playButton = new JRadioButton("Play");
		ButtonGroup radioButtonGroup = new ButtonGroup(); //only can choose one of button
		radioButtonGroup.add(designButton);radioButtonGroup.add(playButton); //make group for mode
		panel2.add(new JLabel("Mode : ")); //1st label is mode
		panel2.add(designButton); //add both panel to the frame
		panel2.add(playButton);	
		
		
		String[] dimArr = {"3","4","5"}; //array for dimension choices
		JComboBox dimension = new JComboBox(dimArr);
		panel2.add(new JLabel("Dimension : "));
		panel2.add(dimension);
		JButton showButton = new JButton("Show");
		JButton hideButton = new JButton("Hide");
		
		JButton saveButton = new JButton("Save");
		JButton loadButton = new JButton("Load");
		JButton randomButton = new JButton("Random");
		
		panel2.add(showButton);
		panel2.add(hideButton);
		panel2.add(saveButton);
		panel2.add(loadButton);
		panel2.add(randomButton);
		
		panel2.add(new JLabel("Level : "));
		String[] levelArr = {"[Select]","1","2","3"};
		JComboBox level = new JComboBox(levelArr);
		panel2.add(level);
		JButton finishButton = new JButton("Finish");
		panel2.add(finishButton);
		
		panel2.add(new JLabel("Points: "));
		JTextField points = new JTextField("0"); //text field for points, zero by default
		points.setEditable(false); //user cannot edit this point
		panel2.add(points); //add text field, 0 by default
		
		
		ImageIcon blankImage = new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/image.png"); //get image from folder
		
		JLabel imageLabel = new JLabel(blankImage); //put image into label
		imageLabel.setIcon(blankImage); //set label to icon
		panel2.add(imageLabel);
		
//		panel2.add(new TextArea("",10,30)); //space for image
		
		panel2.add(new JLabel("Time : "));
		JTextArea timerTextArea = new JTextArea(); //text area for timer
		timerTextArea.setEditable(false);
//		panel2.add(new JTextField("0")); //add text field for time, 0 by default
		ActionListener playButtonListener = new ActionListener() { //action listener for play button
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("it is running now");
//				int time = 0;
//				Timer timer = new Timer();
////				timer.setRepeats(false);
//				timer.start();
//				time += 1;
//				timerTextArea.append(String.valueOf(time)); // start the timer and add text area in panel
			}}; //playButtonListener end
			
		
		JButton resetButton = new JButton("Reset");
		panel2.add(resetButton);
		
		f.add(panel1);
		f.add(panel2);
		
		
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
