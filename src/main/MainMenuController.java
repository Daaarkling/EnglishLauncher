package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import model.EnglishLesson;
import model.EnglishLessonCollection;

/**
 * Profile Controller.
 */
public class MainMenuController extends AnchorPane implements Initializable {

	@FXML
	GridPane grid;		



	@Override
	public void initialize(URL location, ResourceBundle resources) {

		EnglishLessonCollection collection = new EnglishLessonCollection();
		EnglishLesson[] lessons = collection.getLessons();
		
		int x=0;
		int y=0;
		for (EnglishLesson lesson : lessons) {
			FlowPane pane = new FlowPane();
			pane.getChildren().add(lesson);
			pane.setStyle("-fx-alignment: center;");
			grid.add(pane, x, y);
			y++;
			if(y % 8 == 0){
				y = 0;
				x++;
			}
		}
	}

	@FXML
	public void handleBtnClose(ActionEvent event) {

		System.exit(0);
	}
}
