package SpaceInvaders;

import JFXAnsatz.Starship;
import Projectiles.EnemyShots;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class SpaceInvader extends ImageView {

	public SpaceInvader(Image image) {
		super(image);
	}
	
	public void doMove() {}
	
	public void doMove(Starship s) {}
	
	public EnemyShots shoot(Starship s) {
		return null;
	}
	
	public String getType() {
		return null;
	}
	
	public void hit() {}
	
	public void setToDead() {}
	
	public boolean isDead() {
		return false;
	}
}
