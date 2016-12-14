package raiti.Application.MemorizationOfPoemCardGame;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <br>Created by Raiti-chan on 2016/12/14.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.instance = this;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/MainGui.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource("gui/MainCSS.css").toExternalForm());
			
			primaryStage.setTitle("Memorization of Poem Card Game");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Main instance = null;
	
	public static Main getInstance() {
		return instance;
	}
}
