package SpaceInvaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Projectiles.CDJProjectile;
import javafx.scene.image.Image;

public class FastCDJ extends SpaceInvader {

private String type;
private Boolean dead;
private int stamp;
private CDJProjectile projectile;
	
	public FastCDJ(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Pioneer.png"), 96, 96, true, true));
	this.type = "SpaceInvader";
	this.setTranslateX(x);
	this.setTranslateY(y);
	stamp = 0;
	dead = false;
	}
	
	@Override
	public void doMove() {
		this.setTranslateY(this.getTranslateY() + 5);
		
		if (stamp < 40) {
			this.setTranslateX(this.getTranslateX() + 5);
			stamp++;
			return;
		}
		if (stamp < 80) {
			this.setTranslateX(this.getTranslateX() - 5);
			stamp++;
			if (stamp == 80) {
				stamp = 0;
			}
			return;
		}
	}
	
	@Override
	public CDJProjectile shoot() {
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
	
	String getType() {
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
	
}
