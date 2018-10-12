package Projectiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class JaegermeisterFlasche extends EnemyShots {

	private String type;
	private Boolean dead;
	private Media musicFile;
	private MediaPlayer meds;
	
	public JaegermeisterFlasche(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./CDJProjectile.png"), 24, 24, true, true));
	this.type = "cdjprojectile";
	File File = new File("./LaserGun.mp3");
 	musicFile = new Media(File.toURI().toString());
 	meds = new MediaPlayer(musicFile);
	this.setTranslateX(x);
	this.setTranslateY(y);
	dead = false;
	}
}
