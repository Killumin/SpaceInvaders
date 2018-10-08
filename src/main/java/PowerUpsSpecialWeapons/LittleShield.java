package PowerUpsSpecialWeapons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class LittleShield extends Item {

	private String type;
	private Boolean dead;
	
	public LittleShield(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./LittleShield.png"), 45, 45, true, true));
	this.type = "littleshield";
	this.setTranslateX(x);
	this.setTranslateY(y);
	dead = false;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setDead() {
		this.dead = true;
	}
	
	public boolean isDead() {
		return this.dead;
	}
}
