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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
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
		
		ImageIcon frameImageIcon = new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/N.jpg");
		
		Font font = new Font("Bahnschrift", Font.PLAIN, 15);
		
		f.setSize(750,450); //size
		f.setTitle("Number Puzzle Game"); //set window title
		f.setIconImage(frameImageIcon.getImage());
		f.setResizable(false); //cannot change the window size
		f.setLayout(new GridLayout(1,0)); //divide window in two
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); //if click close button
		
		f.getContentPane().setBackground(Color.white);
		
//*****************************************************************************number panel		
		JPanel numberPanel = new JPanel();
		Color c = new Color(204,204,255);
//		numberPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //set border for number panel
		numberPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,3), "N")); //set border
		numberPanel.setBackground(Color.WHITE);
		numberPanel.setLayout(new GridLayout(3,3,5,5)); //add grid layout to panel 1
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
		} //if end
		for(int z=0;z<8;z++) { //add button except the last button for moving
			buttonArr[z].setBackground(c);
			numberPanel.add(buttonArr[z]).setFont(font);
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
		modePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,3), "Mode")); //set border for mode
		modePanel.setBackground(Color.WHITE); //set back ground to white color
		JRadioButton designButton = new JRadioButton("Design", true); //radio button already checked by default
		JRadioButton playButton = new JRadioButton("Play");
		ButtonGroup radioButtonGroup = new ButtonGroup(); //only can choose one of button
		designButton.setBackground(Color.WHITE);
		playButton.setBackground(Color.WHITE);
		radioButtonGroup.add(designButton);radioButtonGroup.add(playButton); //make group for mode
		
		 //design button is selected by default
		modePanel.add(designButton); //add both panel to the frame
		modePanel.add(playButton);
		rightPanel.add(modePanel);
		
//******************************************************************design panel		
		String[] dimArr = {"3","4","5"}; //array for dimension choices
		JComboBox dimension = new JComboBox(dimArr);
		designPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,3), "Dimension")); //set border for mode
		designPanel.setBackground(Color.WHITE);
		designPanel.add(dimension);
		rightPanel.add(designPanel);

//************************************************************************play panel		
		playPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,3), "Level")); //set border for mode
		String[] levelArr = {"[Select]","1","2","3"}; //has three levels
		JComboBox level = new JComboBox(levelArr);
		playPanel.setBackground(Color.WHITE);
		playPanel.add(level);
		rightPanel.add(playPanel);
		
//****************************************************************************add button listener
		if(designButton.isSelected()) { //design button is selected
			level.setEnabled(false); //disable level area
		} else if (playButton.isSelected()) { //if play button is selected
			dimension.setEnabled(false); //disable dimension area
		} //if else end
		
		designButton.addItemListener(new ItemListener() { //if check dimension combo box

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==ItemEvent.SELECTED) { //if combo box checked to dimension
					level.setEnabled(false); //disable level button
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					level.setEnabled(true);
				} //if else end
				
			}

		});
		
		playButton.addItemListener(new ItemListener() { //if check play combo box

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					dimension.setEnabled(false);
				} else if(e.getStateChange()==ItemEvent.DESELECTED){
					dimension.setEnabled(true);
				} //if else end
			}
			
		});
		
//****************************************************************************image panel 		
		
		ImageIcon originalImage = new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/image.png"); //get image from folder
		Image ima = originalImage.getImage(); //get image to change the size
		Image changedImage = ima.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon blankImage = new ImageIcon(changedImage);
		JLabel imageLabel = new JLabel(blankImage); //put image into label
		imageLabel.setIcon(blankImage); //set label to icon
		imagePanel.setBackground(Color.LIGHT_GRAY);
		imagePanel.add(imageLabel);
		rightPanel.add(imagePanel);
		
//**************************************************************************time panel		
		timePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,3), "Time")); //set border for mode
		timePanel.setBackground(Color.WHITE);
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
		
		resetButton.setBackground(Color.WHITE);
		
		resetPanel.setBackground(Color.WHITE);
		resetPanel.setLayout(new BorderLayout());
		resetPanel.add(resetButton, "South"); //move reset button to south
		rightPanel.add(resetPanel);		
		
//******************************************************************add to frame		
		f.add(numberPanel);
		f.add(rightPanel);
		
		f.setVisible(true); //window appear in the screen, hidden default
	} //main end
	/*
	 * Method name : Configuration
	 * Purpose : 
	 * Algorithm :
	 * @param
	 * @return
	 */
	public void configure() {
		
	}
	
	
} //Main class end
