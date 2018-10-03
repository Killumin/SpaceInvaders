package JFXAnsatz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
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

public class Level1 implements ActionListener {
	
	private Stage window;
    private Scene myScene;
    private StackPane gameLayout;
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private double t = 0;
    private Starship player;
    private ArrayList<SpaceInvader> spaceInvaders = new ArrayList<SpaceInvader>();
    
    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private boolean moveDown;
    private boolean shoot;

	 		public Level1(Stage window) throws FileNotFoundException, URISyntaxException{
		 	this.window = window;
	 		myScene = gameScene();
	 		
	    }
	 		
	 private Scene gameScene() throws FileNotFoundException, URISyntaxException{
	 			
		 		Scene gameScene;
			 	// Music
			 	File File = new File("./Radioactive.mp3");
			 	Media musicFile = new Media(File.toURI().toString());
			 	MediaPlayer meds = new MediaPlayer(musicFile);
			 	meds.setAutoPlay(true);
			 	// Starship
			 	player = new Starship(null,96,96,true,true);
			 	spaceInvaders.add(new SpaceInvader(0,-200));
		        // Game Layout
		        gameLayout = new StackPane();
		        gameLayout.getChildren().add(player);
		        gameLayout.getChildren().add(spaceInvaders.get(0));
		        // Background

		        //gameLayout.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
		        gameLayout.setBackground(new Background( new BackgroundImage(new Image(new FileInputStream("./Space.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		  
		        
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
					switch(e.getCode()) {
	           case A:
	        	   player.setVelX(-5);
	               break;
	           case D:
	        	   player.setVelX(5);
	               break;
	           case W:
	        	   player.setVelY(-5);
	           	  break;
	           case S:
	        	   player.setVelY(5);
	           	  break;
	           case SPACE:
	         	  shoot = true;
					}
			   });
				
				gameScene.setOnKeyReleased(e -> {
					switch(e.getCode()) {
				case A:
			        player.setVelX(0);
			        break;
			    case D:
			        player.setVelX(0);
			        break;
			    case W:
			        player.setVelY(0);
			        break;
			    case S:
			        player.setVelY(0);
			        break;
					}
				});
				
		        window.setScene(gameScene);
		        window.setFullScreenExitHint("");
		        window.setFullScreen(true);
		        
		        return gameScene;
		    }
	 
	 private void update() {
	        t += 0.016;
	        
	       player.move();
	       
	        if (shoot) {
	        	try {
					Projectile shot = player.shoot();
					gameLayout.getChildren().add(shot);
					this.projectiles.add(shot);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
	        	shoot = false;
	        }
	        
	        this.projectiles.forEach(p -> {
	            switch (p.getType()) {

	                case "projectile":
	                    p.move();
	                    if (!spaceInvaders.isEmpty()) {
	                    if (p.getBoundsInParent().intersects(spaceInvaders.get(0).getBoundsInParent())) {
	                        p.setDead();
	                        spaceInvaders.get(0).setDead();
	                    }
	                    }
	                    break;
	            }
	        });
	        
	        // Remove Collided Projectiles

	        this.projectiles.forEach(p -> {
	        	if (p.isDead()) {
	        		gameLayout.getChildren().remove(p);
	        	}
	        });
	        
	        for(int i = 0; i < projectiles.size(); i++) {
	        	if (projectiles.get(i).isDead()) {
	        		projectiles.remove(i);
	        	}
	        }
	        
	        // Remove Dead Enemys
	        
	        this.spaceInvaders.forEach(s -> {
	        	if (s.isDead()) {
	        		gameLayout.getChildren().remove(s);
	        	}
	        });
	        
	        for(int i = 0; i < spaceInvaders.size(); i++) {
	        	if (spaceInvaders.get(i).isDead()) {
	        		spaceInvaders.remove(i);
	        	}
	        }

	        if (t > 2) {
	            t = 0;
	        }
	    }
	    
	    public void setScene(Scene scene) {
	    	window.setScene(scene);
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		Scene getMyScene() {
			return myScene;

}
}
