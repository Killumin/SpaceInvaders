package Projectiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class WellenStrahlen extends EnemyShots {

	private String type;
	private Boolean dead;
	private AudioClip sound;
	
	public WellenStrahlen(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./WellenStrahlen.png"), 32, 32, true, true));
	this.type = "wellenstrahlen";
	File File = new File("./LaserGun.mp3");
 	sound = new AudioClip(File.toURI().toString());
	this.setTranslateX(x);
	this.setTranslateY(y);
	dead = false;
	}
	
	public void doSound() {
		sound.setVolume(0.09);
		sound.setCycleCount(1);
		sound.play();
	}
	
	@Override
	public void move() {
		this.setTranslateY(this.getTranslateY()+10);
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
