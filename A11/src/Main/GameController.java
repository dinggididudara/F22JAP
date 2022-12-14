/**
 * File Name : GameController.java
 * Identification : Soomin113
 * Course : CST8221 - JAP, Lab Section : 302
 * Assignment : A21
 * Professor : Paulo Sousa
 * Date : 
 * Compiler : Eclipse IDE
 * Purpose : Number Puzzle - main class
 */
package Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.util.TimerTask;

/**
 * Class Name : GameController
 * Methods List :
 * Constants List : 
 * Purpose :
 * 
 *  @author Soomin
 *
 */
public class GameController {
	
	/**
	 * GameController : constructor
	 */
	GameController() {
		new Design();
	} //GameController
	/**
	 * dialogMessage
	 * Purpose : show the dialog of the game process, 0 if succeed, 1 if end, -1 if error
	 * @param status check the status of game process 
	 */
	static void dialogMessage(int status){
		JDialog dialog = new JDialog();
		switch(status) {
		case 0: //if succeed
			JLabel label1 = new JLabel(new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/gamewinner.png"));
			dialog.add(label1);
			break;
		case 1: //if end
			JLabel label2 = new JLabel(new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/gameend.png"));
			dialog.add(label2);
			break;
		case -1: //if error
			JLabel label3 = new JLabel(new ImageIcon("C:/Users/dinggididudara/OneDrive/AC/22F/CST8221 Java Application Programming/Soomin113/A11/src/gameerr.png"));
			dialog.add(label3);
			break;
		} //switch end
		dialog.pack();
		dialog.setVisible(true);
	} //dialogMessage end
	
	} //main end
	


