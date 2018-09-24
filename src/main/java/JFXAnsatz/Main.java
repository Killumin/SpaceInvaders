package JFXAnsatz;


import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application{
	
		private Stage window;
	    private Scene menuScene;
	    private Scene gameScene;
	    private Button startGameGui;
	    private StackPane menuLayout;
	    private StackPane gameLayout;
	    private Label ueberschrift;
	    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	    private double t = 0;
	
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
		 	//Media musicFile = new Media(this.getClass().getResource("Dimitri%20Vegas%20&%20Like%20Mike%20vs.%20W&W%20-%20Arcade%20(Extended%20Mix).mp3").toExternalForm());
		 	//MediaPlayer meds = new MediaPlayer(musicFile);
		 	//meds.setAutoPlay(true);
		 	// Starship
		 	Starship player = new Starship(null,96,96,true,true);
	        // Game Layout
	        gameLayout = new StackPane();
	        gameLayout.getChildren().add(player);
	        // Background
	        gameLayout.setBackground(null);
	        BackgroundImage myBI= new BackgroundImage(new Image("./Graphics/HubbleDeepFieldPixel.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        gameLayout.setBackground(new Background(myBI));
	        // gameLayout.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
	        
	        AnimationTimer timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	                update();
	            }
	        };
	        timer.start();
	        // Game Scene 
	        gameScene = new Scene(gameLayout);
	        //
			gameScene.setOnKeyPressed(e -> {
				switch (e.getCode()) {
              case A:
                  player.moveLeft();
                  break;
              case D:
                  player.moveRight();
                  break;
              case W:
              	  player.moveUp();
              	  break;
              case S:
             	  player.moveDown();
              	  break;
              case SPACE:
					try {
						Projectile shot = player.shoot();
						gameLayout.getChildren().add(shot);
						this.projectiles.add(shot);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
            	  break;
				}});
	        window.setScene(gameScene);
	        window.setFullScreenExitHint("");
	        window.setFullScreen(true);

	        return gameScene;
	    }
	 
	 private void update() {
	        t += 0.016;

	        this.projectiles.forEach(p -> {
	            switch (p.getType()) {

	                case "projectile":
	                    p.move();

//	                    if (s.getBoundsInParent().intersects(player.getBoundsInParent())) {
//	                        player.dead = true;
//	                        s.dead = true;
//	                    }
	                    break;
	            }
	        });

//	        root.getChildren().removeIf(n -> {
//	            Sprite s = (Sprite) n;
//	            return s.dead;
//	        });

	        if (t > 2) {
	            t = 0;
	        }
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