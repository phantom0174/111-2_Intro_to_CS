// Assignment 12
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B


package A12_111502552;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class A12_111502552 extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello World");
		
		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}
