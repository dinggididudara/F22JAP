/**
 * File Name : Design.java
 * Identification : Soomin113
 * Course : CST8221 - JAP, Lab Section : 302
 * Assignment : A21
 * Professor : Paulo Sousa
 * Date : Sep-30
 * Compiler : Eclipse IDE
 * Purpose : Number Puzzle - Design class. designing layout (initial window)
 */
package Main;

import java.util.Timer;
import java.util.TimerTask;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Design extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	int count = 0; // counting start button

	JWindow splash = new JWindow(); // splash window

	JFrame f = new JFrame(""); // create frame

	JPanel leftPanel = new JPanel(); // left panel
	JPanel numberPanel = new JPanel();
	int buttonRow = 0;
	int buttonCol = 0;

	JPanel textPanel = new JPanel();
	JButton enterButton = new JButton("Enter"); // add enter button

	JMenuItem newMenuItem = new JMenuItem("New");
	JMenuItem serverMenuItem = new JMenuItem("Server/Client");
	
	JMenuItem solutionMenuItem = new JMenuItem("Solution");
	JMenuItem exitMenuItem = new JMenuItem("Exit");

	JMenuItem colorsMenuItem = new JMenuItem("Color");
	JMenuItem aboutMenuItem = new JMenuItem("About");

	JPanel rightPanel = new JPanel(); // second panel for choice box

	JPanel modePanel = new JPanel(); // panel for mode

	JPanel dimensionPanel = new JPanel(); // panel for Design
	String[] dimArr = { "3", "4", "5" }; // array for dimension choices
	JComboBox dimensionComboBox = new JComboBox(dimArr);

	int selectedDimension;

	JButton[][] buttonArr;
	int[][] numArr;

	JPanel levelPanel = new JPanel(); // panel for levelComboBox
	String[] levelArr = { "[Select]", "1", "2", "3" }; // has three levels
	JComboBox levelComboBox = new JComboBox(levelArr);

	int selectedLevel;

	JPanel typePanel = new JPanel(); // panel for typeComboBox
	String[] typeArr = { "Number", "Text" };
	JComboBox typeComboBox = new JComboBox(typeArr);

	JPanel infoPanel = new JPanel(); // panel for image
	JTextArea infoTextArea = new JTextArea(); // text area for information
	JScrollPane scrollPane = new JScrollPane(infoTextArea);

	JPanel timePanel = new JPanel(); // panel for time

	JPanel lastPanel = new JPanel(); // panel for start and reset button
	JButton startButton = new JButton("Start Game");
	JButton resetButton = new JButton("Reset");

	JMenuBar menuBar = new JMenuBar(); // create menu bar
	JMenu gameMenu = new JMenu("Game");
	JMenu helpMenu = new JMenu("Help");

	JTextField textField = new JTextField("", 8);// text field for text pad screen, limited 8 length

	JTextArea timerTextArea = new JTextArea("0"); // text area for timer
	int time = 0; // timer count
	Timer timer;
	
	int point=0; //point for game
	JTextArea pointTextArea = new JTextArea("0"); //text area for points
	JPanel pointPanel =  new JPanel();

	ImageIcon frameImageIcon = new ImageIcon(
			"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/N.jpg");

	ImageIcon splashImage = new ImageIcon(
			"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/game.png");

	Font font = new Font("Bahnschrift", Font.BOLD, 80); // large text
	Font font2 = new Font("Bahnschrift", Font.BOLD, 23); // medium text
	Font font3 = new Font("Banschrift", Font.BOLD, 12); // small text
	Color purple = new Color(204, 204, 255); // purple color

	/**
	 * Design() : default Constructor
	 */
	Design() {
		splash.getContentPane().add(new JLabel("", splashImage, SwingConstants.CENTER));
		splash.setBounds(500, 170, 500, 500);
		splash.setVisible(true);

		try {
			Thread.sleep(1000); // sleep for a while for splash screen
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // try catch end
			// ***********************************************************************main
		f.setSize(900, 700); // size
		f.setTitle("Number Puzzle Game"); // set window title
		f.setIconImage(frameImageIcon.getImage());
		f.setResizable(false); // cannot change the window size
		f.setLayout(new BorderLayout()); // divide window in two
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); // if click close button

		f.getContentPane().setBackground(Color.white);

		splash.dispose(); // remove splash screen
		// **********************************************************************menu
		// bar
		newMenuItem.setIcon(new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/iconnew.png"));
		solutionMenuItem.setIcon(new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/iconsol.png"));
		exitMenuItem.setIcon(new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/iconext.png"));

		colorsMenuItem.setIcon(new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/iconcol.png"));
		aboutMenuItem.setIcon(new ImageIcon(
				"C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/iconabt.png"));

		gameMenu.add(newMenuItem);
		gameMenu.add(serverMenuItem);
		
		gameMenu.add(solutionMenuItem);
		gameMenu.addSeparator();
		gameMenu.add(exitMenuItem);

		helpMenu.add(colorsMenuItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutMenuItem);

		menuBar.add(gameMenu);
		menuBar.add(helpMenu);

		newMenuItem.addActionListener(this);
		serverMenuItem.addActionListener(this);
		solutionMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);

		colorsMenuItem.addActionListener(this);
		aboutMenuItem.addActionListener(this);

		f.setJMenuBar(menuBar);
		// *****************************************************************************number
		// panel
		leftPanel.setLayout(new BorderLayout()); // border layout for left panel
		leftPanel.add(numberPanel); // add empty number panel
		// **************************************************************************right
		// panel

		rightPanel.setBackground(Color.white);
		rightPanel.setLayout(new GridLayout(0, 1)); // set layout
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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

		// Design button is selected by default
		modePanel.add(designButton); // add both panel to the serverFrame
		modePanel.add(playButton);
		rightPanel.add(modePanel);

		// ******************************************************************Design
		// panel

		dimensionPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Dimension")); // set border for mode
		dimensionPanel.setBackground(Color.WHITE);
		dimensionPanel.add(dimensionComboBox);
		rightPanel.add(dimensionPanel);

		dimensionComboBox.addActionListener(this);
		// ************************************************************************play
		// panel
		levelPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Level")); // set border for mode
		levelPanel.setBackground(Color.WHITE);
		levelPanel.add(levelComboBox);
		rightPanel.add(levelPanel);

		levelComboBox.addActionListener(this);
		// ****************************************************************************typeComboBox
		// panel
		typePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Type"));

		typeComboBox.addActionListener(this);
		typePanel.setBackground(Color.WHITE);
		typePanel.add(typeComboBox);
		rightPanel.add(typePanel);
		// ****************************************************************************add
		// button listener
		if (designButton.isSelected()) { // Design button is selected
			addLog("Design Mode");
			levelComboBox.setEnabled(false); // disable levelComboBox area
			typeComboBox.setEnabled(false);
		} else if (playButton.isSelected()) { // if play button is selected
			addLog("Play Mode");
			dimensionComboBox.setEnabled(false); // disable dimension area
		} // if else end

		designButton.addItemListener(new ItemListener() { // if check dimension combo box

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) { // if combo box checked to dimension
					levelComboBox.setEnabled(false); // disable levelComboBox button
					typeComboBox.setEnabled(false); // disable typeComboBox button
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					levelComboBox.setEnabled(true);
					typeComboBox.setEnabled(true);
				} // if else end

			} // itemStateChanged

		});

		playButton.addItemListener(new ItemListener() { // if check play combo box

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					dimensionComboBox.setEnabled(false);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					dimensionComboBox.setEnabled(true);
				} // if else end
			} // itemListener

		});

		// ****************************************************************************image
		// panel
		infoPanel.setLayout(new BorderLayout());
		infoTextArea.setBackground(Color.GRAY);
		infoTextArea.setEditable(false);
		infoTextArea.setFont(font3);
		infoTextArea.setForeground(Color.WHITE);
		infoPanel.add(scrollPane, BorderLayout.CENTER);
		rightPanel.add(infoPanel);

		// **************************************************************************time
		// panel
		timePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Time")); // set border
		timePanel.setBackground(Color.WHITE);

		timerTextArea.setEditable(false); // cannot edit this text
		timerTextArea.setFont(font2);
		
		timePanel.add(timerTextArea);
		rightPanel.add(timePanel);
		//******************************************************************************point panel
		pointPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Point")); // set border for mode
		pointPanel.setBackground(Color.WHITE);
		pointTextArea.setEditable(false);
		pointTextArea.setFont(font2);
		
		pointPanel.add(pointTextArea);
		rightPanel.add(pointPanel);
		// ******************************************************************start
		// button
		startButton.setBackground(Color.WHITE);
		startButton.setFont(font2);
		startButton.setEnabled(false); // default is 'disabled'
		startButton.addActionListener(this); // add action listener

		lastPanel.setBackground(Color.WHITE);
		resetButton.setFont(font2);
		lastPanel.setLayout(new BorderLayout(0, 5));
		lastPanel.add(startButton, "Center");

		resetButton.setBackground(Color.WHITE);
		lastPanel.add(resetButton, "South"); // move reset button to south
		rightPanel.add(lastPanel);

		resetButton.addActionListener(this);

		// ******************************************************************add to
		// serverFrame
		f.add(leftPanel, BorderLayout.CENTER);
		f.add(rightPanel, BorderLayout.EAST);

		f.setVisible(true); // window appear in the screen, hidden default

	} // Design method end

	/**
	 * setDimension()
	 * Purpose : save the number of dimension that selected
	 * @param d index of dimension combo box array
	 */
	void setDimension(int d) {
		selectedDimension = d + 3;
	} // setDimension end
	/**
	 * getDimension()
	 * Purpose : return the number of level that selected
	 * @return selectedDimension
	 */
	int getDimension() {
		return selectedDimension;
	} //getDimension end
	/**
	 * setLevel()
	 * Purpose : save the number of level that selected
	 * @param l index of level combo box array
	 */
	void setLevel(int l) {
		selectedLevel = l;
	} // setDimension end

	/**
	 * getRandom()
	 * Purpose : check dimension and change number pad
	 */
	void getRandom() {
		int d = getDimension() * getDimension();
		int[] num = new int[d]; // save numbers
		int temp = 0;
		boolean check = false;

		for (int i = 0; i < d; i++) {
			check = true;
			while (check) {
				temp = (int) (Math.random() * d); // save random number in temp
				check = false;
				for (int j = 0; j < i; j++) { // search if it is already in the array
					if (temp == num[j]) { // if found
						check = true;
						break; // go back to while again
					} // if end
				} // for end
			} // while end
			num[i] = temp;// save into array
			numArr[i / getDimension()][i % getDimension()] = temp;
			if (temp == d - 1) {
				buttonRow = i / getDimension();
				buttonCol = i % getDimension();
			} // if end
		} // for end
	} // getRandom end

	/**
	 * designNumberPad()
	 * Purpose : Design number pad
	 */
	void designNumberPad() { // add number
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				if (i == buttonRow && j == buttonCol) {
					buttonArr[i][j].setText(""); // make empty button
					buttonArr[i][j].setEnabled(false);
				} else {
					buttonArr[i][j].setText(String.valueOf(numArr[i][j] + 1)); // put number in number button
					buttonArr[i][j].setEnabled(true);
				} // if-else end

			} // for end
		} // for end
	} // designNumberPad end

	/**
	 * startGame()
	 * Purpose : start game with number pad, draw the grid layout with selected dimension
	 */
	void startGame() {
		reset();
		numberPanel.setBackground(Color.WHITE);
		
		addLog("button layout");
		numberPanel.setLayout(new GridLayout(getDimension(), getDimension(), 5, 5));
		
		int temp = 1;
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				buttonArr[i][j] = new JButton(String.valueOf(temp));
				buttonArr[i][j].setFont(font);
				buttonArr[i][j].setBackground(purple);
				numberPanel.add(buttonArr[i][j]);
				buttonArr[i][j].addActionListener(this);
				temp++;
			} // for end
		} // for end
		leftPanel.add(numberPanel, BorderLayout.CENTER); // add number panel to left panel and center it
		startTimer();
	} // startGame

	/**
	 * startTimer
	 * Purpose : start Timer when the game starts
	 */
	void startTimer() {
		timer = new Timer();
		addLog("Start Timer");
		TimerTask timerT = new TimerTask() {
			@Override
			public void run() {
				timerTextArea.setFont(font2);
				timerTextArea.setText(String.valueOf(time));
				time++;
			}
		};
		timer.schedule(timerT, 0, 1000); // start timer and do task
	} //startTimer end

	/**
	 * designTextPad()
	 * Purpose : design text pad, and get user's input
	 */
	void designTextPad() {
		reset();

		textPanel.setLayout(new FlowLayout());

		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(font2);
		textField.setText("");// reset text field
		textPanel.add(textField);
		textPanel.add(enterButton);

		leftPanel.add(textPanel, BorderLayout.SOUTH);// show text field that can typeComboBox text
		leftPanel.add(numberPanel, BorderLayout.CENTER);

		enterButton.addActionListener(this);
	} // designTextPad end

	/**
	 * gameOver()
	 * Purpose : check if the number in order = game is over
	 */
	boolean gameOver() {
		int temp = 0;
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				if (numArr[i][j] != temp) {
					return false;
				} // if end
				temp++;
			} // for end
		} // for end
		return true;
	} // gameOver end

	/**
	 * reset()
	 * Purpose : reset the dimension numbers and number panel on the left
	 */
	void reset() {
		startButton.setEnabled(false); // disable start game button

		leftPanel.removeAll();
		leftPanel.revalidate();
		leftPanel.repaint();

		numberPanel.removeAll();
		numberPanel.revalidate();
		numberPanel.repaint();
	} // reset end

	/**
	 * addLog
	 * Purpose : add log to information text area
	 * @param log message that wants to show in the text area
	 */
	void addLog(String log) {
		infoTextArea.append(log + "\n");
		infoTextArea.setCaretPosition(infoTextArea.getDocument().getLength()); // position is at last line
	} // addLog

	/**
	 * actionPerformed()
	 * Purpose : all actions related to action listener (buttons, menus, combo box)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == newMenuItem) {
			f.dispose(); // dispose main window
			new GameController();
		}
		
		if (e.getSource() == serverMenuItem) {
			f.dispose(); //close the main window
			new ServerMain();
			new ClientMain();
		}
		

		if (e.getSource() == solutionMenuItem) {
			JOptionPane.showMessageDialog(f, "solution?");
		}

		if (e.getSource() == exitMenuItem) {
			System.exit(0); // exit the program
		}

		if (e.getSource() == colorsMenuItem) { // change color in grid panel

			String str = e.getActionCommand();
			if (str.equals("Color")) {
				Color selectedColor = JColorChooser.showDialog(null, "Color", Color.BLACK);
				if (selectedColor != null) {
					resetButton.setBackground(selectedColor);// change the button color
					startButton.setBackground(selectedColor);
				} //if end
			} //if end
		} //if end

		if (e.getSource() == aboutMenuItem) {
			JOptionPane.showMessageDialog(f, "About?");
		}

		if (e.getSource() == dimensionComboBox) {
			setDimension(dimensionComboBox.getSelectedIndex());
			addLog("You selected dimension -> " + getDimension());
			buttonArr = new JButton[getDimension()][getDimension()];
			numArr = new int[getDimension()][getDimension()];
		}

		if (e.getSource() == levelComboBox) {
			setLevel(levelComboBox.getSelectedIndex());
			addLog("You selected level -> " + selectedLevel);
		}
		//------------------------if click type combo box-------------------------
		if (e.getSource() == typeComboBox) { // if click type
			JComboBox cb = (JComboBox) e.getSource(); // get combo box
			int index = cb.getSelectedIndex(); // get index number that user clicked

			if (index == 0) { // if choose "Number"
				levelComboBox.setEnabled(true);
				addLog("Number Mode");
				if (getDimension() >= 2 && selectedLevel >= 1) {
					startButton.setEnabled(true);
				} //if end
			} else if (index == 1) { // if choose "Text"
				addLog("Text Mode");
				levelComboBox.setEnabled(false); // disable levelComboBox combo box
				startButton.setEnabled(true);
			} // if-else end
		} // if end
		//----------------------------game start in number mode------------------------------
		if(getDimension() >= 2 && selectedLevel >= 1 && typeComboBox.getSelectedIndex()==0) {
			if(e.getSource()==startButton) {
				addLog("Starting game with random numbers");
				startGame();
				getRandom();
				designNumberPad();
			} //if end
		} //if end
		//-------------------game start in text mode--------------------------------------------
		if(getDimension()>=2 && typeComboBox.getSelectedIndex()==1) {
			if(e.getSource()==startButton) {
				addLog("Starting game with your texts");
				designTextPad();
			} //if end
		} //if end
		// ------------------- if click buttons-------------------------------------------------
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				if (e.getSource() == buttonArr[i][j]) {
					point++;
					pointTextArea.setText(String.valueOf(point));
					addLog("You clicked "+ (numArr[i][j]+1));
					numArr[buttonRow][buttonCol] = numArr[i][j];
					numArr[i][j] = getDimension() * getDimension() - 1;
					buttonRow = i;
					buttonCol = j;
					designNumberPad();
					if (gameOver()) { // if game over is true
						addLog("Game Over");
						GameController.dialogMessage(0);
						timer.cancel(); // stop the timer
						time = 0;
						point = 0;
						timerTextArea.setText("0");
						timerTextArea.setFont(font2);
						
						reset();
						setDimension(0);
						setLevel(0);
					} // if end
				} // if end
			} // for end
		} // for end
		//---------------------------in text mode, if click enter button------------------------------
		if (e.getSource() == enterButton) { // in text design, if enter the button
			String input = textField.getText();
			if (input.isEmpty()) {
				JOptionPane.showMessageDialog(numberPanel, "Please enter any string");
			} else { // if has string input
				addLog("You typed -> " + input);
				String[] c = input.split("");

				reset();
				
				startTimer();
				
				numberPanel.setBackground(Color.WHITE);
				numberPanel.setLayout(new GridLayout(3, 3, 5, 5));

				JPanel textPanel = new JPanel();
				textPanel.setLayout(new FlowLayout());

				JButton[] textButtonArr = new JButton[9]; // button array
				JButton enterButton = new JButton("Enter"); // add enter button
				enterButton.setBackground(Color.WHITE);
				enterButton.setFont(font2);

				for (int j = 0; j < c.length; j++) {
					textButtonArr[j] = new JButton("" + c[j]);
					textButtonArr[j].setBackground(Color.WHITE);
					numberPanel.add(textButtonArr[j]).setFont(font);
				} // for end
				if (c.length < 9) {
					for (int x = c.length + 1; x < 9; x++) {
						textButtonArr[x] = new JButton("");
						textButtonArr[x].setBackground(Color.WHITE);
						numberPanel.add(textButtonArr[x]).setEnabled(false);
					} // for end
				} // if end
				textPanel.add(textField);
				textPanel.add(enterButton);
				leftPanel.add(numberPanel, BorderLayout.CENTER);
			} // if-else end
		} // if end
		//-----------------------if click reset button-----------------
		if (e.getSource() == resetButton) { // if click reset button
			addLog("Reset the Game Now");
			if(time != 0) { //if time starts
				timer.cancel();
				timerTextArea.setText("0");
			} //if end
			
			pointTextArea.setText("0");
			point = 0;
			
			setDimension(0);
			setLevel(0);
			
			if (typeComboBox.getSelectedIndex() == 1) { // if it is text mode
				textPanel.removeAll();
				reset();
			} else {
				reset();
			} //if-else end
		} // if end

	} // actionPerformed end

} // Design class end
