package Projectiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import JFXAnsatz.Starship;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class TennisBall extends EnemyShots {

	private String type;
	private Boolean dead;
	private Media musicFile;
	private AudioClip sound;
	private Starship s;
	private boolean moving;
	private double xDistance;
	private double yDistance;
	
	public TennisBall(double x, double y, Starship s) throws FileNotFoundException {
	super(new Image(new FileInputStream("./TennisBall.png"), 24, 24, true, true));
	this.type = "tennisball";
	File File = new File("./LaserGun.mp3");
 	sound = new AudioClip(File.toURI().toString());
	this.setTranslateX(x);
	this.setTranslateY(y);
	this.s = s;
	dead = false;
	moving = false;
	
	}
	
	public void doSound() {
		sound.setVolume(0.09);
		sound.setCycleCount(1);
		sound.play();
	}
	
	@Override
	public void move() {
		this.setRotate(this.getRotate() + 2); 
		if (moving) {
			this.setTranslateX(this.getTranslateX() + xDistance);
			this.setTranslateY(this.getTranslateY() + yDistance);
		} else { initMovement(); }
	}
		
	public void initMovement() {
		xDistance = s.getTranslateX() - this.getTranslateX();
		yDistance = s.getTranslateY() - this.getTranslateY();
		double  xTemp = Math.abs(xDistance);
		double  yTemp = Math.abs(yDistance);
		int counter = 0;
		boolean far = false;
		if(xTemp > 900) { far = true; }
		if(xTemp > yTemp) {
			while(xDistance > 10) {
				xDistance = xDistance/10;
				counter++;
			}	
			while(xDistance < -10) {
				xDistance = xDistance/10;
				counter++;
			}
			for(int i = 0; i < counter; i++) {
				yDistance = yDistance/10;
			}
		} else {
			while(yDistance > 10) {
				yDistance = yDistance/10;
				counter++;
			}
			while(yDistance < -10) {
				yDistance = yDistance/10;
				counter++;
			}
			for(int i = 0; i < counter; i++) {
				xDistance = xDistance/10;
			}
		}
		if (far) {
		if(xDistance < 5 && xDistance > 0) {
			xDistance*= 10;
			yDistance*= 10;
		}
		if (xDistance < 0 && xDistance > -5) {
			xDistance*= 10;
			yDistance*= 10;
		}
		}
		moving = true;
	}
	
	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public void setDead() {
		this.dead = true;
	}
	
	@Override
	public boolean isDead() {
		return this.dead;
	}
}
