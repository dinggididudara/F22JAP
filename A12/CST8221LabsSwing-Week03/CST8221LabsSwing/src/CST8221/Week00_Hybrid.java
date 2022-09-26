package CST8221;

import javax.swing.JOptionPane;

import CST8221.hybrid.Week02.GlassPaneDemo;
import CST8221.hybrid.Week02.OpacityDemo;
import CST8221.hybrid.Week03.LayoutDemo;

/**
 * Default Week 0 (Hybrid activities)
 * @author sousap
 *
 */
public class Week00_Hybrid {

	/**
	 * Error Message
	 */
	String errorMessage = "";

	/**
	 * Default constructor
	 */
	public Week00_Hybrid() {
		; // Default constructor
	}
	
	
	/**
	 * Week 0 Labs - Hybrid activities
	 * 
	 * @param lab Current lab
	 * @param usesJFX Boolean use of JavaFX
	 * @param args Command line parameters
	 */
	public void invokeHybrid(int lab, boolean usesJFX, String[] args) {
		switch (lab) {

		// Week 2 Hybrid examples ................................................
		case 21:
			hybrid21();
			break;
		case 22:
			hybrid22();
			break;

		// Week 3 Hybrid examples ................................................
		case 31:
			hybrid31(); // Layout Test (Prof. Daniel)
			break;
			
		// Default ................................................
		default: // invalid lab
			errorMessage = "No valid Hybrid";
			JOptionPane.showMessageDialog(null, errorMessage);
		}

	}
	
	// HYBRID (WEEK 2) ..................................................
	
	/**
	 * Hybrid 1 - Week 2 - Code 1 - GlassPaneDemo
	 */
	public void hybrid21() {
		System.out.println("Hybrid Week 2 / Ex 1: GlassPane...");
		GlassPaneDemo Hybrid21 = new GlassPaneDemo();
		Hybrid21.execute();
	}

	/**
	 * Hybrid 1 - Week 2 - Code 2 - OpacityDemo
	 */
	public void hybrid22() {
		System.out.println("Hybrid Week 2 / Ex 2: Opacity...");
		OpacityDemo Hybrid22 = new OpacityDemo();
		Hybrid22.execute();
	}
	
	// HYBRID (WEEK 3) ..................................................

	/**
	 * Method for week 3 - Hybrid for Layouts - Prof. Daniel
	 */
	public void hybrid31() {
		System.out.println("Hybrid Week 3 / Ex 1: Layout demo...");
		LayoutDemo.execute();
	}

	// NEW WEEKS TO COME ...............................................

}
