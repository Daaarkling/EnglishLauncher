package main;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Activator;
import javafx.scene.image.Image;


public class Main extends Application {

    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 960.0;
    private final double MINIMUM_WINDOW_HEIGHT = 540.0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
		
        try {
            stage = primaryStage;
            stage.setTitle("Výukový program angličtiny");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
			
			InputStream stream = getClass().getResourceAsStream("/resources/icon.jpg");
			if(stream != null){
				stage.getIcons().add(new Image(stream)); 			
			}
			
			verifying();
            primaryStage.show();
			
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	
	private void verifying(){
		
		if(Activator.isActivated()){
			gotoMainMenu();
		} else {
			gotoVerify();
		}
	}


    
    public void gotoMainMenu() {
        try {
            MainMenuController mainMenuController = (MainMenuController) replaceSceneContent("MainMenu.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoVerify() {
        try {
            VerifyController verifyController = (VerifyController) replaceSceneContent("Verify.fxml");
            verifyController.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, 960, 540);
        stage.setScene(scene);
		stage.setResizable(false);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}
