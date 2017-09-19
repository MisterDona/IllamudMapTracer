package controllers;

import java.io.File;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dto.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class NewMapConfig {

    @FXML
    private JFXButton openbtn,nextbtn,printbtn;

    @FXML
    private JFXTextField Filetext;
    private FileChooser chooser = new FileChooser();
    private File imgFile;
    public static String path;
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
		    }
    	if (event.getTarget()==printbtn)
    		System.out.println(path);
    	if (event.getTarget()==nextbtn)
    		SceneManager.getInstance().launch("newmap");
    	}
}
