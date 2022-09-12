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
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

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
		
//		Main mainFrame = new Main();
		//frame
		JFrame f = new JFrame(""); //create frame
		f.setSize(600,800); //size
		f.setTitle("Number Puzzle"); //set window title
		f.setResizable(false); //cannot change the window size
		f.setLayout(new GridLayout(1,2)); //divide window in two
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); //if click close button
		
		JPanel panel1 = new JPanel(); //set panel for numbers
		
		panel1.setLayout(new GridLayout(3,3)); //add grid layout to panel 1
		
		JButton b1 = new JButton("button1");
		JButton b2 = new JButton("button2");
		JButton b3 = new JButton("button3");
		JButton b4 = new JButton("button4");
		
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		panel1.add(b4);
		
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
		panel2.add(new JTextField("0")); //add text field, 0 by default
		
		panel2.add(new TextArea("",10,30)); //space for image
		
		panel2.add(new JLabel("Time : "));
		panel2.add(new JTextField("0")); //add text field for time, 0 by default
		
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
