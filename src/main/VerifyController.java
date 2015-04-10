package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Activator;


/**
 * Verify Controller.
 */
public class VerifyController extends AnchorPane implements Initializable {

    @FXML
    TextField key;
    @FXML
    Button btnActive;
    @FXML
    Label errorMessage;
	@FXML
	ProgressIndicator progress;
	

    Main application;
    
    
    public void setApp(Main application){
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setText("");
    }
    
    @FXML
    public void handleBtnVerify(ActionEvent event) {
        
		btnActive.setDisable(true);
		progress.setVisible(true);
		key.setDisable(true);
		
		Task<Boolean> task = new Task<Boolean>() {

			@Override
			protected Boolean call() {							
				if(key.getText().length() == 10){
					try {
						return Activator.activate(key.getText());
					} catch (Exception e){
						errorMessage.setText("Nepodařilo se ověřit licenci, zkontrolujte připojení k internetu.");
						return false;
					}
				}				
				return false;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				
				btnActive.setDisable(false);
				key.setDisable(false);
				progress.setVisible(false);
				
				if(getValue()){					
					application.gotoMainMenu();
				} else {
					errorMessage.setText("Zadaný klíč není správný.");
				}
			}
		};

		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();     
    }
}
