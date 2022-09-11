package NumPuz.week01;

/* NumPuz-JAP: LAB 01, Example 6SFXCSS
File name: FXMLCSSButton.java
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * This example illustrates how to build a JavaFX Application using FXML and CSS
 * Instead of using plain Java code the GUI layout can be described using FXML
 * and the controls can be visually enhanced using CSS. JavaFX applications
 * using FXML and CSS is much easier to build with appropriate GUI builders
 * (like Scene Builder) than building them manually.
 *
 * @author Svillen Ranev
 * @version 1.19.1
 * @since JavaFX 8.0
 */

public class FXMLCSSButton extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// load the FXML description
		Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		// Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		Scene scene = new Scene(root, 380, 250, Color.TRANSPARENT);
		stage.setScene(scene);
		// use css to skin (style) the components
		stage.getScene().getStylesheets().add("button.css");
		stage.setTitle("Swing and JavaFX GUI - E6");
		stage.show();
	}

	/**
	 * The JavaFX application main method.
	 * 
	 * @param args - not used.
	 */
	public void execute(String[] args) {
		// Application.launch(args);
		launch(args);
	}

}
