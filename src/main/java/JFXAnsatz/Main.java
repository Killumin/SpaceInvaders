package JFXAnsatz;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	
		private Stage window;
	    private Scene menuScene;
	    private Button startGameGui;
	    private Button optionsButton;
	    private StackPane menuLayout;
	    private Label ueberschrift;
	
	public static void main(String[] args) {
		launch(args);	
	}

	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setScene(menuScene());
        window.setTitle("SpaceInvader");
        window.setFullScreenExitHint("");
        window.setFullScreen(true);
        window.show();

	
	}
	
	 private Scene menuScene() throws FileNotFoundException{

	        //Menu  Buttons
	        startGameGui = new Button("Start Game");
	        startGameGui.setOnAction(e -> {
	        try {
				window.setScene((new Level1(window)).getMyScene());
			} catch (FileNotFoundException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        });
	        
	        startGameGui.setTranslateX(0);
	        startGameGui.setTranslateY(100);
	        
	        optionsButton = new Button("Options");
	        optionsButton.setOnAction(e -> {
		       
		        });
	        optionsButton.setTranslateX(0);
	        optionsButton.setTranslateY(150);
	             
	        //Menu Labels
	        ueberschrift = new Label();
	        ueberschrift.setText("Welcome to SpaceInvaders!");

	        //Menu Layout
	        menuLayout = new StackPane();
	        menuLayout.setAlignment(Pos.TOP_CENTER);
	        menuLayout.getChildren().addAll(ueberschrift,optionsButton,startGameGui);
	        BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream("./SpaceInvadersMenu.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	        menuLayout.setBackground(new Background(myBI));

	        // Menu Scene 
	        int width = 600;
	        menuScene = new Scene(menuLayout, width, width);

	        return menuScene;
	    }
	 
}