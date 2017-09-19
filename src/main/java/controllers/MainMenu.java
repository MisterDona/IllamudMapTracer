package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dto.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainMenu implements Initializable {
	@FXML
	private ImageView btnsalir;
	@FXML
	private ImageView btnnewmap;
	
	@FXML
	private void handleButtonAction(MouseEvent event) throws IOException {
		if(event.getTarget() == btnsalir)
			System.exit(0);
		if(event.getTarget() == btnnewmap) {
			SceneManager.getInstance().launch("newmapconfig");
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
