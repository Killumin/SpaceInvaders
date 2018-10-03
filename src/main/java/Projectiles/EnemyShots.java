package Projectiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class EnemyShots extends ImageView {
	
	public EnemyShots(Image image) {
		super(image);
	}
	
	public void move() {}

	public String getType() {
		return null;
	}
}
