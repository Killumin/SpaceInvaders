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
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

	public EvaKopf(double x, double y) throws FileNotFoundException {
		super(new Image(new FileInputStream("./EvaKopf.png"), 60, 60, true, true));
		this.type = "evakopf";
		health = 100;
		this.setTranslateX(x);
		this.setTranslateY(y);
		stamp = 0;
		dead = false;
		}
		
		@Override
		public void doMove(Starship s) {
			up = false;
			down = false;
			left = false;
			right = false;
			if(s.getTranslateX() > this.getTranslateX()) {
				right = true;
				this.setTranslateX(this.getTranslateX() + 2);
			}
			if(s.getTranslateX() < this.getTranslateX()) {
				left = true;
				this.setTranslateX(this.getTranslateX() - 2);
			}
			if(s.getTranslateY() > this.getTranslateY()) {
				down = true;
				this.setTranslateY(this.getTranslateY() + 2);
			}
			if(s.getTranslateY() < this.getTranslateY()) {
				up = true;
				this.setTranslateY(this.getTranslateY() - 2);
			}
			if (right && up) {
				this.setRotate(315);
			}
			if (right && down) {
				this.setRotate(405);
			}
			if (left && up) {
				this.setRotate(545);
			}
			if (left && down) {
				this.setRotate(445);
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
