// Assignment 10
// Name: 蕭登鴻
// Student Number: 111502552
// Course 2023_CE1002_B


package A10_111502552;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class A10_111502552 extends Application {

	public final double rad = Math.PI * 2;

	public final Color[] p_colors = { Color.RED, Color.BLUE };
	
	public Color genRandomColor() {
		return Color.color(Math.random(), Math.random(), Math.random());
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();

		Ellipse el0 = new Ellipse(200, 200, 170, 100);
		el0.setFill(Color.TRANSPARENT);
		el0.setStroke(genRandomColor());
		el0.setStrokeWidth(2);
		
		Ellipse el00 = new Ellipse(200, 200, 170, 100);
		el00.setFill(Color.TRANSPARENT);
		el00.setStroke(genRandomColor());
		el00.setRotate(35);

		Ellipse el1 = new Ellipse(200, 200, 100, 170);
		el1.setFill(Color.TRANSPARENT);
		el1.setStroke(genRandomColor());
		el1.setStrokeWidth(2);
		
		Ellipse el11 = new Ellipse(200, 200, 100, 170);
		el11.setFill(Color.TRANSPARENT);
		el11.setStroke(genRandomColor());
		el11.setRotate(35);
		
		double len = 100 * Math.sqrt(2);
		Rectangle rect = new Rectangle(200 - len / 2, 200 - len / 2, len, len);
		rect.setRotate(45);
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(genRandomColor());
		rect.setStrokeWidth(2);
		
		pane.getChildren().addAll(el0, el00, el1, el11, rect);
		
		for (int i = 1; i <= 10; i++) {
			Circle main_circ = new Circle(200, 200, 25 - i * 2);
			main_circ.setFill(Color.TRANSPARENT);
			main_circ.setStroke(genRandomColor());
			main_circ.setStrokeWidth(2 - i * 0.1);
			pane.getChildren().add(main_circ);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 20; j++) {
				Circle circ = new Circle(
					200 + (30 + i * 10) * Math.cos(rad * j / 20),
					200 + (30 + i * 10) * Math.sin(rad * j / 20),
					5 + i / 5
				);
				circ.setFill(p_colors[(i + j) % 2]);
				pane.getChildren().add(circ);
			}			
		}
		
		pane.setRotate(15);

		Scene scene = new Scene(pane, 400, 400);
		stage.setTitle("A10_111502552");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
