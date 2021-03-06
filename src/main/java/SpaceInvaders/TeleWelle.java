package SpaceInvaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import JFXAnsatz.Starship;
import Projectiles.CDJProjectile;
import Projectiles.WellenStrahlen;
import javafx.scene.image.Image;

public class TeleWelle extends SpaceInvader {

	private String type;
	private Boolean dead;
	private int health;
	private int stamp;
	private WellenStrahlen projectile;
		
		public TeleWelle(double x, double y) throws FileNotFoundException {
		super(new Image(new FileInputStream("./Pioneer.png"), 96, 96, true, true));
		this.type = "telewelle";
		this.setTranslateX(x);
		this.setTranslateY(y);
		health = 100;
		stamp = 0;
		dead = false;
		}
		
		@Override
		public void doMove(Starship s) {
		if(s.getTranslateX() > this.getTranslateX()) {
			this.setTranslateX(this.getTranslateX() + 3);
		}
		if(s.getTranslateX() < this.getTranslateX()) {
			this.setTranslateX(this.getTranslateX() - 3);
		}
		}
		
		@Override
		public WellenStrahlen shoot(Starship s) {
			projectile = null;
			stamp++;
			if (stamp == 100) {
				try {
					projectile = new WellenStrahlen(this.getTranslateX(), this.getTranslateY() + 40);
					stamp = 0;
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
