package Projectiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class WellenStrahlen extends EnemyShots {

	private String type;
	private Boolean dead;
	private Media musicFile;
	private MediaPlayer meds;
	
	public WellenStrahlen(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./WellenStrahlen.png"), 32, 32, true, true));
	this.type = "wellenstrahlen";
	File File = new File("./LaserGun.mp3");
 	musicFile = new Media(File.toURI().toString());
 	meds = new MediaPlayer(musicFile);
	this.setTranslateX(x);
	this.setTranslateY(y);
	dead = false;
	}
	
	public void doSound() {
		meds.setVolume(0.09);
		meds.setStopTime(new Duration(2000));
		meds.play();
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
