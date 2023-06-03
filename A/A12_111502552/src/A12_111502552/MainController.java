package A12_111502552;

import java.io.File;
import java.net.MalformedURLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainController {
	@FXML
	public ImageView image;
	@FXML
	public Button button;
	
	public void btnPressed(ActionEvent e) throws MalformedURLException {
		Image img = new Image(getClass().getResourceAsStream("/assets/human/human.jpg"));
		image.setImage(img);
				
		File soundFile = new File("src/assets/human/human.mp3");
		
		Media sound = new Media(soundFile.toURI().toString());
		MediaPlayer player = new MediaPlayer(sound);
		player.play();
	}
}
