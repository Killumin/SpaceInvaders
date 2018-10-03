package Projectiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class CDJProjectile extends EnemyShots {

	
	private String type;
	private Boolean dead;
	private Media musicFile;
	private MediaPlayer meds;
	
	public CDJProjectile(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./CDJProjectile.png"), 24, 24, true, true));
	this.type = "cdjprojectile";
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
