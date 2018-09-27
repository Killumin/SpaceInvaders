package JFXAnsatz;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	
		private Stage window;
	    private Scene menuScene;
	    private Scene gameScene;
	    private Button startGameGui;
	    private Button optionsButton;
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
	
	 private Scene menuScene() throws FileNotFoundException{

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
	        
	        startGameGui.setTranslateX(0);
	        startGameGui.setTranslateY(100);
	        
	        optionsButton = new Button("Options");
	        optionsButton.setOnAction(e -> {
		        try {
					window.setScene(gameScene());
				} catch (FileNotFoundException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	        BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream("./HubbleDeepFieldPixel.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	        menuLayout.setBackground(new Background(myBI));

	        // Menu Scene 
	        int width = 600;
	        menuScene = new Scene(menuLayout, width, width);

	        return menuScene;
	    }
	 
	 private Scene gameScene() throws FileNotFoundException, URISyntaxException{
		 	
		 	// Music
		 	//Media musicFile = new Media(new FileInputStream("./Dimitri%20Vegas%20&%20Like%20Mike%20vs.%20W&W%20-%20Arcade%20(Extended%20Mix).mp3"));
//		 	Media musicFile = new Media(this.getClass().getResource("Dimitri%20Vegas%20&%20Like%20Mike%20vs.%20W&W%20-%20Arcade%20(Extended%20Mix).mp3").toExternalForm());
		 	//MediaPlayer meds = new MediaPlayer(musicFile);
		 	//meds.setAutoPlay(true);
		 	// Starship
		 	Starship player = new Starship(null,96,96,true,true);
	        // Game Layout
	        gameLayout = new StackPane();
	        gameLayout.getChildren().add(player);
	        // Background

	        //gameLayout.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
	        gameLayout.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("./Space.png")),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
	        
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