package model;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *
 * @author Jan
 */
public class EnglishLesson extends Button {
	

	private final String fileName;

	public EnglishLesson(String text, String fileName, String color) {
		super(text);
		this.fileName = fileName;
		setStyle("-fx-background-color: " + color + ";");
		setPrefWidth(200);
		setPrefHeight(35);
		
		setOnAction((ActionEvent event) -> {
		
			EnglishOpener.open(getClass(), fileName);
		});
	}
	
}
