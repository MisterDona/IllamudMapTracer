package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dto.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;

public class NewMapConfig  implements Initializable{

    @FXML
    private JFXButton nextbtn;

    @FXML
    private ComboBox<String> pixelcombo;
    
    @FXML
    private JFXButton openbtn;

    @FXML
    private JFXTextField filetext, pixeltext;
    
    private FileChooser chooser = new FileChooser();
    private File imgFile;
    public static String path;
    public static int hexsize;

    
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
    	if (event.getTarget()==openbtn) {
        	chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
    		imgFile = chooser.showOpenDialog(null);
    		path=""+ imgFile.toURI();
    		path= path.replaceAll("file:/", "file:///");
    		filetext.setText(path);
		    }
    	if (event.getTarget()==nextbtn)
    		pixeltext.getText();
    		SceneManager.getInstance().launch("newmap");
    	}
    	
	public void initialize(URL location, ResourceBundle resources) {
		pixelcombo= new ComboBox<String>();
		for (int i=0; i<100; i++) {
			pixelcombo.getItems().add("faso");
		}

		
	}
}
