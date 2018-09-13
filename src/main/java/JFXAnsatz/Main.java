package JFXAnsatz;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application{
	
		private Stage window;
	    private Scene menuScene;
	    private Scene gameScene;
	    private Button startGameGui;
	    private StackPane menuLayout;
	    private StackPane gameLayout;
	    private Label ueberschrift;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		
		window = stage;
		window.setScene(menuScene());
        window.setTitle("SpaceInvader");
        window.show();
		
	}
	
	 private Scene menuScene(){

	        //Menu  Buttons
	        startGameGui = new Button("Start Game");
	        startGameGui.setOnAction(e -> {
	        try {
				window.setScene(gameScene());
			} catch (FileNotFoundException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        });
	             
	        //Menu Labels
	        ueberschrift = new Label();
	        ueberschrift.setText("Welcome to SpaceInvaders!");

	        //Menu Layout
	        menuLayout = new StackPane();
	        menuLayout.getChildren().addAll(ueberschrift, startGameGui);
	        menuLayout.setAlignment(Pos.CENTER);

	        // Menu Scene 
	        int width = 600;
	        menuScene = new Scene(menuLayout, width, width);

	        return menuScene;
	    }
	 
	 private Scene gameScene() throws FileNotFoundException, URISyntaxException{
		 	
		 	// Musik
		 	//Media musicFile = new Media("file:/C:/Users/Killumi/git/SpaceInvadersNew/Dimitri%20Vegas%20&%20Like%20Mike%20vs.%20W&W%20-%20Arcade%20(Extended%20Mix).mp3");
		 	//Media musicFile = new Media("Dimitri%20Vegas%20&%20Like%20Mike%20vs.%20W&W%20-%20Arcade%20(Extended%20Mix).mp3");
		 	//MediaPlayer meds = new MediaPlayer(musicFile);
		 	//meds.setAutoPlay(true);
		 	// Starship
		 	Starship player = new Starship(null,96,96,true,true);
		 	ImageView starship = player.init();
	        //Game Layout
	        gameLayout = new StackPane();
	        gameLayout.getChildren().add(starship);
	        gameLayout.setBackground(null);
	        gameLayout.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
	        
	        // Game Scene 
	        gameScene = new Scene(gameLayout);
	        //
			gameScene.setOnKeyPressed(e -> {
				switch (e.getCode()) {
              case A:
                  player.moveLeft(starship);
                  break;
              case D:
                  player.moveRight(starship);
                  break;
              case W:
              	  player.moveUp(starship);
              	  break;
              case S:
             	  player.moveDown(starship);
              	  break;
				}});
	        window.setScene(gameScene);
	        window.setFullScreenExitHint("");
	        window.setFullScreen(true);

	        return gameScene;
	    }
	 
	    
	    public Scene getMenuScene() {
	    	return menuScene;
	    }
	    
	    public Scene getGameScene() {
	    	return gameScene;
	    }
	    
	    public void setScene(Scene scene) {
	    	window.setScene(scene);
	    }

}