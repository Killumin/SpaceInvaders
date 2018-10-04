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
	
	public EnemyShots shoot(Starship s) {
		return null;
	}
	
	public void setToDead() {}
	
	public boolean isDead() {
		return false;
	}
}
