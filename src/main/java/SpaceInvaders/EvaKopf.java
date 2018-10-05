package SpaceInvaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import JFXAnsatz.Starship;
import Projectiles.CDJProjectile;
import javafx.scene.image.Image;

public class EvaKopf extends SpaceInvader {
	
	private int health;
	private String type;
	private Boolean dead;
	private int stamp;
	private CDJProjectile projectile;

	public EvaKopf(double x, double y) throws FileNotFoundException {
		super(new Image(new FileInputStream("./TennisBall.png"), 32, 32, true, true));
		this.type = "evakopf";
		health = 100;
		this.setTranslateX(x);
		this.setTranslateY(y);
		stamp = 0;
		dead = false;
		}
		
		@Override
		public void doMove(Starship s) {
			if(s.getTranslateX() > this.getTranslateX()) {
				this.setTranslateX(this.getTranslateX() + 2);
			}
			if(s.getTranslateX() < this.getTranslateX()) {
				this.setTranslateX(this.getTranslateX() - 2);
			}
			if(s.getTranslateY() > this.getTranslateY()) {
				this.setTranslateY(this.getTranslateY() + 2);
			}
			if(s.getTranslateY() < this.getTranslateY()) {
				this.setTranslateY(this.getTranslateY() - 2);
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
