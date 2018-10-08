package JFXAnsatz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import Projectiles.EnemyShots;
import Projectiles.Projectile;
import SpaceInvaders.CDJ;
import SpaceInvaders.EvaKopf;
import SpaceInvaders.FastCDJ;
import SpaceInvaders.SpaceInvader;
import SpaceInvaders.TeleWelle;
import SpaceInvaders.TennisPlayer;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Level1  {
	
	private Stage window;
	private Text hud;
    private Scene myScene;
    private StackPane gameLayout;
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private ArrayList<EnemyShots> enemyShots = new ArrayList<EnemyShots>();
    private double t = 0;
    private double s = 0;
    private Starship player;
    private ArrayList<SpaceInvader> spaceInvaders = new ArrayList<SpaceInvader>();
    private long timeStamp;
    
    private boolean horiA;
    private boolean horiD;
    private boolean vertW;
    private boolean vertS;
    private boolean shoot;

	 		public Level1(Stage window) throws FileNotFoundException, URISyntaxException{
		 	this.window = window;
	 		myScene = gameScene();
	 		timeStamp = System.currentTimeMillis();
	 		
	    }
	 		
	 private Scene gameScene() throws FileNotFoundException, URISyntaxException{
	 			
		 		Scene gameScene;
			 	// Music
			 	File File = new File("./TrainerRedTheme.mp3");
			 	Media musicFile = new Media(File.toURI().toString());
			 	MediaPlayer meds = new MediaPlayer(musicFile);
			 	meds.play();
			 	meds.setVolume(0.2);
			 	// Starship
			 	player = new Starship(null,96,96,true,true);
			 	// Gegner
			 	spaceInvaders.add(new TennisPlayer(-1000,-300, "links"));
			 	spaceInvaders.add(new TennisPlayer(1000,-300, "rechts"));
			 	spaceInvaders.add(new TeleWelle (400,-300));
			 	spaceInvaders.add(new EvaKopf(400, -400));
			 	spaceInvaders.add(new CDJ(0,-600));
			 	spaceInvaders.add(new FastCDJ(200,-600));
			 	spaceInvaders.add(new CDJ(-200,-600));
			 	spaceInvaders.add(new FastCDJ(-400,-600));
			 	// HUD
		        hud = new Text("" +player.getHealth());
		        hud.setFont(new Font(45));
		        hud.setFill(Color.RED);
		        hud.setTranslateX(800);
		        hud.setTranslateY(-500);
		        // Game Layout
		        gameLayout = new StackPane();
		        gameLayout.getChildren().add(new ImageView(new Image(new FileInputStream("./dialogbox"), 200, 600, true, true)));
		        gameLayout.getChildren().add(hud);
		        gameLayout.getChildren().add(player);
		        for (int i = 0; i < spaceInvaders.size(); i++) {
		        	gameLayout.getChildren().add(spaceInvaders.get(i));
		        }
		        // Background
		        gameLayout.setBackground(new Background( new BackgroundImage(new Image(new FileInputStream("./Space.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		        
		        AnimationTimer timer = new AnimationTimer() {
		            @Override
		            public void handle(long now) {
		                try {
							update();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
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
	        	   horiA = true;
	               break;
	           case D:
	        	   player.setVelX(5);
	        	   horiD = true;
	               break;
	           case W:
	        	   player.setVelY(-5);
	        	   vertW = true;
	           	  break;
	           case S:
	        	   player.setVelY(5);
	        	   vertS = true;
	           	  break;
					}
			   });
							
				gameScene.setOnMousePressed(m -> {
					if (m.getButton().name().equals("PRIMARY"))
						shoot = true;
				});
				
				gameScene.setOnMouseReleased(m -> {
					if (m.getButton().name().equals("PRIMARY"))
						shoot = false;
				});

				
				gameScene.setOnKeyReleased(e -> {
					switch(e.getCode()) {
				case A:
					if(!horiD) {
			        player.setVelX(0);
					}
					horiA = false;
			        break;
			    case D:
			    	if(!horiA) {
			        player.setVelX(0);
			    	}
			    	horiD = false;
			        break;
			    case W:
			    	if(!vertS) {
			        player.setVelY(0);
			    	}
			    	vertW = false;
			        break;
			    case S:
			    	if(!vertW) {
			        player.setVelY(0);
			    	}
			    	vertS = false;
			        break;
					}
				});
				
		        window.setScene(gameScene);
		        window.setFullScreenExitHint("");
		        window.setFullScreen(true);
		        
		        return gameScene;
		    }
	 
	 private void update() throws FileNotFoundException {
		 
		 if((System.currentTimeMillis() - timeStamp) > 3000) {
			 TennisPlayer c = new TennisPlayer(-1000,-300, "links");
//			 TennisPlayer d = new TennisPlayer(-1000,0, "links");
//			 TennisPlayer e = new TennisPlayer(-1000,300, "links");
			 TennisPlayer f = new TennisPlayer(1000,-300, "rechts");
//			 TennisPlayer g = new TennisPlayer(1000,0, "rechts");
//			 TennisPlayer h = new TennisPlayer(1000,300, "rechts");
			 gameLayout.getChildren().add(c);
//			 gameLayout.getChildren().add(d);
//			 gameLayout.getChildren().add(e);
			 gameLayout.getChildren().add(f);
//			 gameLayout.getChildren().add(g);
//			 gameLayout.getChildren().add(h);
			 spaceInvaders.add(c);
//			 spaceInvaders.add(d);
//			 spaceInvaders.add(e);
			 spaceInvaders.add(f);
//			 spaceInvaders.add(g);
//			 spaceInvaders.add(h);
			 this.timeStamp = System.currentTimeMillis();
		 }
		 
		 // HUD updaten
		 
		 hud.setText(""+ player.getHealth());
		 
		 // Zeitparameter
	        t += 0.016;
	        s += 0.01;
	        
	     // SpaceInvader bewegen sich und geben evtl. Schüsse ab
	        this.spaceInvaders.forEach(s -> {
	        	EnemyShots e = s.shoot(player);
	        	if(e != null) {
	        	gameLayout.getChildren().add(e);
	        	this.enemyShots.add(e);
	        	e.doSound();
	        	}
	        	if (s.getType() == "telewelle" || s.getType() == "evakopf") {
	        		s.doMove(player);
	        	}
	        	s.doMove();
	        });
	        
	     // Das Player-Movement wird verarbeitet
	       player.move();
	       
	     // Die Player-Schüsse werden verarbeitet
	       if(s > 0.1)
	        if (shoot) {
	        	try {
					Projectile shot = player.shoot();
					gameLayout.getChildren().add(shot);
					this.projectiles.add(shot);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
	        }
	       
	      // Die Gegnerischen Schüsse bewegen sich und schaden evtl. dem Player
	        this.enemyShots.forEach(e -> {
	        	switch (e.getType()) {

                case "cdjprojectile":
                	e.move();
                	if(e.getBoundsInParent().intersects(player.getBoundsInParent())) {
                		e.setDead();
                		player.hit();
                	}
                	break;
                case "tennisball":
                	e.move();
                	if(e.getBoundsInParent().intersects(player.getBoundsInParent())) {
                		e.setDead();
                		player.hit();
                	}
                	break;
                case "wellenstrahlen":
                	e.move();
                	if(e.getBoundsInParent().intersects(player.getBoundsInParent())) {
                		e.setDead();
                		player.hit();
                	}
                	break;
	        }
	        });
	        
	      // Die Schüsse des Spielers bewegen sich und zerstören evtl. Gegner
	        this.projectiles.forEach(p -> {
	            switch (p.getType()) {

	                case "projectile":
	                    p.move();
	                    if (!spaceInvaders.isEmpty()) {
	                    for(int i = 0; i < spaceInvaders.size(); i++) {
	                    	SpaceInvader space = spaceInvaders.get(i);
	                    	if (p.getBoundsInParent().intersects(space.getBoundsInParent())) {
	                    		p.setDead();
	                    		space.hit();
	                    	}
	                    }
	                    }
	                    break;
	            }
	        });
	        
	        // Remove Collided EnemyShots
	        
	        this.enemyShots.forEach(e -> {
	        	if (e.isDead()) {
	        		gameLayout.getChildren().remove(e);
	        	}
	        });
	        
	        for(int i = 0; i < enemyShots.size(); i++) {
	        	if (enemyShots.get(i).isDead()) {
	        		enemyShots.remove(i);
	        	}
	        }
	        
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
	        
	        // Remove Dead Player
	        
	        if (player.isDead()) {
	        	gameLayout.getChildren().remove(player);
	        }

	        if (s > 0.1) {
	        	s = 0;
	        }
	        if (t > 2) {
	            t = 0;
	        }
	    }
	    
	    public void setScene(Scene scene) {
	    	window.setScene(scene);
	    }
		
		Scene getMyScene() {
			return myScene;

}
}
