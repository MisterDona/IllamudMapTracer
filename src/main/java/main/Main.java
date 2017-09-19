package main;

import java.io.IOException;

import dto.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{
    	/*
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setResizable(false);
        */
    	SceneManager.getInstance(primaryStage);
    	loaddefaultscenes();
    	SceneManager.getInstance().launch("main");
    }
	public void loaddefaultscenes() throws IOException{
		SceneManager.getInstance().create("main", "/resources/scenes/MainMenu.fxml");
		SceneManager.getInstance().create("newmap", "/resources/scenes/View2.fxml");
		SceneManager.getInstance().create("newmapconfig", "/resources/scenes/NewMapConfig.fxml");
	}
    
   
    public static void main(String[] args) {
        launch(args);
    }

}