package dto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

	Stage window;
	static protected SceneManager me;
	protected Map<String, Scene> scenes = new HashMap<String, Scene>();
	protected Map<String, String> ids= new HashMap<String, String>();
	
	static public SceneManager getInstance(Stage stg) {
		if(me == null) me = new SceneManager(stg);
		return me;
	}
	
	static public SceneManager getInstance() {
		return me;
	}
	
	private SceneManager(Stage stg) {
		window = stg;
	}
	
	public void launch(Scene data) {
		window.setScene(data);
		window.centerOnScreen();
		window.show();
	}
	
	public void launch(String nameID) throws IOException{
		if (scenes.containsKey(nameID))
			launch(scenes.get(nameID));
		else load(nameID);
	}
	 
	public void create(String nameID, String resource) throws IOException {
		ids.put(nameID, resource);
	}
	
	public void load (String nameID) throws IOException {
		scenes.put(nameID,new Scene(FXMLLoader.load(getClass().getResource(ids.get(nameID)))));
		launch(nameID);
	}

}