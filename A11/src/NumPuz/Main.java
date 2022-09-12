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
import javax.swing.JButton;

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
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Main mainFrame = new Main();
		//frame
		JFrame f = new JFrame(""); //create frame
		f.setSize(600,400); //size
		f.setTitle("Number Puzzle"); //set window title
		f.setResizable(false); //cannot change the window size
		
		
		JButton b = new JButton("button");
		f.add(b);
		
		
		f.setVisible(true); //appear in the screen, hidden default
	} //main end
	/*
	 * Method name :
	 * Purpose : 
	 * Algorithm :
	 * @param
	 * @return
	 */
	
	
	
} //Main class end
