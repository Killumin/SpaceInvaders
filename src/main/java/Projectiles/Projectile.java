package Projectiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Projectile extends ImageView {
	
	private String type;
	private Boolean dead;
	
	public Projectile(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Bullet.png"), 16, 16, true, true));
	this.type = "projectile";
	this.setTranslateX(x);
	this.setTranslateY(y);
	dead = false;
	}
	
	public void move() {
		this.setTranslateY(this.getTranslateY()-10);
		}
	
	public String getType() {
		return this.type;
	}
	
	public void setDead() {
		this.dead = true;
	}
	
	public Boolean isDead() {
		return this.dead;
	}
}

