package PowerUpsSpecialWeapons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class Coin extends Item {

	private String type;
	private Boolean dead;
	
	public Coin(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Rupee.jpg"), 28, 28, true, true));
	this.type = "coin";
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
