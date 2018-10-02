package JFXAnsatz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javafx.stage.Stage;

public class Level1 implements KeyListener,ActionListener {
	
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
			 	//Media musicFile = new Media(new FileInputStream("./Dimitri%20Vegas%20&%20Like%20Mike%20vs.%20W&W%20-%20Arcade%20(Extended%20Mix).mp3"));
//			 	Media musicFile = new Media(this.getClass().getResource("Dimitri%20Vegas%20&%20Like%20Mike%20vs.%20W&W%20-%20Arcade%20(Extended%20Mix).mp3").toExternalForm());
			 	//MediaPlayer meds = new MediaPlayer(musicFile);
			 	//meds.setAutoPlay(true);
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
		        
		        moveLeft = false;
		        moveRight = false;
		        moveUp  = false;
		        moveDown = false;
		        shoot = false;

		        
//				gameScene.setOnKeyPressed(e -> {
//					switch (e.getCode()) {
//	           case A:
//	         	  moveLeft = true;
//	               //player.moveLeft();
//	               break;
//	           case D:
//	         	  moveRight = true;
//	               //player.moveRight();
//	               break;
//	           case W:
//	         	  moveUp = true;
//	           	  //player.moveUp();
//	           	  break;
//	           case S:
//	         	  moveDown = true;
//	          	  //player.moveDown();
//	           	  break;
//	           case SPACE:
//	         	  shoot = true;
//					}});
		        window.setScene(gameScene);
		        window.setFullScreenExitHint("");
		        window.setFullScreen(true);
		        
		        return gameScene;
		    }
	 
	 private void update() {
	        t += 0.016;
	        
	        if(moveLeft) {
	        	player.moveLeft();
	        	moveLeft = false;
	        }
	        
	        if(moveRight) {
	        	player.moveRight();
	        	moveRight = false;
	        }
	        
	        if(moveUp) {
	        	player.moveUp();
	        	moveUp = false;
	        }
	        
	        if(moveDown) {
	        	player.moveDown();
	        	moveDown = false;
	        }
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
	 
	 // TESTABSCHNITT DO NOT ENETER WITHOUT PERMISSION 
	 
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
           case KeyEvent.VK_A:
         	  moveLeft = true;
               //player.moveLeft();
               break;
           case KeyEvent.VK_D:
         	  moveRight = true;
               //player.moveRight();
               break;
           case KeyEvent.VK_W:
         	  moveUp = true;
           	  //player.moveUp();
           	  break;
           case KeyEvent.VK_S:
         	  moveDown = true;
          	  //player.moveDown();
           	  break;
           case KeyEvent.VK_SPACE:
         	  shoot = true;
				};	
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	 //ABSCHNITTCLOSED
	    
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
