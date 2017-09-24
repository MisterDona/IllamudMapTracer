package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dto.Grilla;
import dto.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerSecond implements Initializable {
	@FXML
	private ImageView btnback;
    @FXML
    private Button btnclear;
	@FXML
	private ImageView btnquit;
	@FXML
	private ImageView btnback1;
    @FXML
    private Pane canvas;
    @FXML
    private Pane subcanvas;
    
    private Grilla grilla;
	
	@FXML
	private void handleButtonAction(MouseEvent event) throws IOException {
		if(event.getTarget() == btnquit)
			System.exit(0);
		if(event.getTarget() == btnback) {		
			SceneManager.getInstance().launch("main");
		}
		if(event.getTarget() == canvas) {
			System.out.println("tuvieja");
	        int x =(int) event.getX();
			int y =(int) event.getY();
			grilla.getHexagono(y, x, canvas);
			System.out.println(x+ "," + y);
		}
	}
	@FXML
    void handleButton(ActionEvent event) {
		if(event.getTarget() == btnclear) {
			System.out.println("as");
			canvas.getChildren().clear();
		}
    }
	public void initialize(URL location, ResourceBundle resources) {
		subcanvas.getChildren().add(new ImageView(NewMapConfig.path));
		canvas.setOpacity(0.5);
		grilla= new Grilla(20);
	}

}
