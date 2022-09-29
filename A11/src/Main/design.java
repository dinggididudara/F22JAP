package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class design extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JFrame f = new JFrame(""); // create frame
	/**
	 * default Constructor
	 */
	design() {
		/**
		 * @param args
		 */
		// frame
		ImageIcon frameImageIcon = new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/N.jpg");

		Font font = new Font("Bahnschrift", Font.PLAIN, 15);
		
		f.setSize(900, 700); // size
		f.setTitle("Number Puzzle Game"); // set window title
		f.setIconImage(frameImageIcon.getImage());
		f.setResizable(false); // cannot change the window size
		f.setLayout(new BorderLayout()); // divide window in two
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); // if click close button

		f.getContentPane().setBackground(Color.white);

		// *****************************************************************************number panel
		JPanel numberPanel = new JPanel();
		Color c = new Color(204, 204, 255);
//			numberPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //set border for number panel
		numberPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "N")); // set border
		numberPanel.setBackground(Color.WHITE);
		numberPanel.setLayout(new GridLayout(3, 3, 5, 5)); // add grid layout to panel 1
		numberPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
		JButton[] buttonArr = new JButton[8]; // button array
		int[] numArr = new int[8]; // random number array is zero
		for (int i = 0; i < 8; i++) {
			numArr[i] = i + 1; // add random number maximum 9 but no zero
			buttonArr[i] = new JButton("" + numArr[i]);
		} // if end
		for (int z = 0; z < 8; z++) { // add button except the last button for moving
			buttonArr[z].setBackground(c);
			numberPanel.add(buttonArr[z]).setFont(font);
		}
		// **************************************************************************right panel
		JPanel rightPanel = new JPanel(); // second panel for choice box

		rightPanel.setBackground(Color.white);
		rightPanel.setLayout(new GridLayout(0, 1)); // set layout
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel modePanel = new JPanel(); // panel for mode
		JPanel dimensionPanel = new JPanel(); // panel for design
		JPanel levelPanel = new JPanel(); // panel for level
		JPanel typePanel = new JPanel(); // panel for type
		JPanel imagePanel = new JPanel(); // panel for image
		JPanel timePanel = new JPanel(); // panel for time
		JPanel lastPanel = new JPanel(); // panel for start and reset button

		// *******************************************************************mode panel
		modePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Mode")); // set border for mode
		modePanel.setBackground(Color.WHITE); // set back ground to white color
		JRadioButton designButton = new JRadioButton("Design", true); // radio button already checked by default
		JRadioButton playButton = new JRadioButton("Play");
		ButtonGroup radioButtonGroup = new ButtonGroup(); // only can choose one of button
		designButton.setBackground(Color.WHITE);
		playButton.setBackground(Color.WHITE);
		radioButtonGroup.add(designButton);
		radioButtonGroup.add(playButton); // make group for mode

		// design button is selected by default
		modePanel.add(designButton); // add both panel to the frame
		modePanel.add(playButton);
		rightPanel.add(modePanel);

		// ******************************************************************design panel
		String[] dimArr = { "3", "4", "5" }; // array for dimension choices
		JComboBox dimension = new JComboBox(dimArr);
		dimensionPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Dimension")); // set border for mode
		dimensionPanel.setBackground(Color.WHITE);
		dimensionPanel.add(dimension);
		rightPanel.add(dimensionPanel);

		// ************************************************************************play panel
		levelPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Level")); // set border for mode
		String[] levelArr = { "[Select]", "1", "2", "3" }; // has three levels
		JComboBox level = new JComboBox(levelArr);
		levelPanel.setBackground(Color.WHITE);
		levelPanel.add(level);
		rightPanel.add(levelPanel);
		//****************************************************************************type panel
		typePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Type"));
		String[] typeArr = {"Text","Number"};
		JComboBox type = new JComboBox(typeArr);
		typePanel.setBackground(Color.WHITE);
		typePanel.add(type);
		rightPanel.add(typePanel);
		// ****************************************************************************add button listener
		if (designButton.isSelected()) { // design button is selected
			level.setEnabled(false); // disable level area
			type.setEnabled(false);
		} else if (playButton.isSelected()) { // if play button is selected
			dimension.setEnabled(false); // disable dimension area
		} // if else end

		designButton.addItemListener(new ItemListener() { // if check dimension combo box

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) { // if combo box checked to dimension
					level.setEnabled(false); // disable level button
					type.setEnabled(false); //disable type button
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					level.setEnabled(true);
					type.setEnabled(true);
				} // if else end

			} //itemStateChanged

		});

		playButton.addItemListener(new ItemListener() { // if check play combo box

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					dimension.setEnabled(false);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					dimension.setEnabled(true);
				} // if else end
			}

		});

		// ****************************************************************************image panel

		ImageIcon originalImage = new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/game.png"); // get
		ImageIcon dialogImage = new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/game.png"); 
																																		// from
		Image ima = originalImage.getImage(); // get image to change the size
		Image changedImage = ima.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(changedImage);
		JButton imageButton = new JButton(); // put image into label
		imageButton.setIcon(imageIcon); // set label to icon
		imageButton.addActionListener(new ActionListener() { //show message dialog
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "dialog"); //show dialog message box
			}
		});
		
		imagePanel.setBackground(Color.LIGHT_GRAY);
		imagePanel.add(imageButton);
		rightPanel.add(imagePanel);

		// **************************************************************************time panel
		timePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Time")); // set border for mode
		timePanel.setBackground(Color.WHITE);
		JTextArea timerTextArea = new JTextArea("0"); // text area for timer
		timerTextArea.setEditable(false); //cannot edit this text
//			ActionListener playButtonListener = new ActionListener() { //action listener for play button
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					int time = 0;
//					Timer timer = new Timer();
//					timer.setRepeats(false);
//					timer.start();
//					time += 1;
//					timerTextArea.append(String.valueOf(time)); // start the timer and add text area in panel
//				}}; //playButtonListener end
		timePanel.add(timerTextArea);
		rightPanel.add(timePanel);
		// ******************************************************************start button
		JButton startButton = new JButton("Start Game");

		startButton.setBackground(Color.WHITE);
		startButton.setEnabled(false); //default is 'disabled'
		
		lastPanel.setBackground(Color.WHITE);
		lastPanel.setLayout(new BorderLayout(0,5));
		lastPanel.add(startButton, "Center");
		
		JButton resetButton = new JButton("Reset");

		resetButton.setBackground(Color.WHITE);
		lastPanel.add(resetButton, "South"); // move reset button to south
		rightPanel.add(lastPanel);
		
		// ******************************************************************add to frame
		f.add(numberPanel, BorderLayout.CENTER);
		f.add(rightPanel, BorderLayout.EAST);
		
		f.setVisible(true); // window appear in the screen, hidden default

	} // design method end
} //design class end
