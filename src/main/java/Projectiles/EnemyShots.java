package Projectiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class EnemyShots extends ImageView {
	
	public EnemyShots(Image image) {
		super(image);
	}
	
	public void move() {}
	
	public void setDead() {}
	
	public void doSound() {}
	
	public boolean isDead() {
		return false;
	}

	public String getType() {
		return null;
	}
}
