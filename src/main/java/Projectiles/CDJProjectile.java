package Projectiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class CDJProjectile extends EnemyShots {

	
	private String type;
	private Boolean dead;
	
	public CDJProjectile(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Bullet.png"), 16, 16, true, true));
	this.type = "cdjprojectile";
	this.setTranslateX(x);
	this.setTranslateY(y);
	dead = false;
	}
	
	@Override
	public void move() {
		this.setTranslateY(this.getTranslateY()+10);
		}
	
	@Override
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
