package SpaceInvaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import JFXAnsatz.Starship;
import Projectiles.CDJProjectile;
import javafx.scene.image.Image;

public class CDJ extends SpaceInvader {

private String type;
private Boolean dead;
private int stamp;
private CDJProjectile projectile;
private int health;
	
	public CDJ(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Pioneer.png"), 96, 96, true, true));
	this.type = "SpaceInvader";
	this.setTranslateX(x);
	this.setTranslateY(y);
	stamp = 0;
	health = 100;
	dead = false;
	}
	
	@Override
	public void doMove() {
		this.setTranslateY(this.getTranslateY() + 3);
		
		if (stamp < 40) {
			this.setTranslateX(this.getTranslateX() + 3);
			stamp++;
			return;
		}
		if (stamp < 80) {
			this.setTranslateX(this.getTranslateX() - 3);
			stamp++;
			if (stamp == 80) {
				stamp = 0;
			}
			return;
		}
	}
	
	@Override
	public CDJProjectile shoot(Starship s) {
		projectile = null;
		if (stamp == 40) {
			try {
				projectile = new CDJProjectile(this.getTranslateX(), this.getTranslateY() + 40);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return projectile;
	}
	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public void setToDead() {
		this.dead = true;
	}
	
	@Override
	public boolean isDead() {
		return this.dead;
	}
	
	@Override
	public void hit() {
		health -= 25;
		if (health <= 0) {
			this.setToDead();
		}
	}
	
}
