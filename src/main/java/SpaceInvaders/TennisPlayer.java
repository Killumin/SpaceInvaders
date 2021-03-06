package SpaceInvaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import JFXAnsatz.Starship;
import Projectiles.TennisBall;
import javafx.scene.image.Image;

public class TennisPlayer extends SpaceInvader {

	private int health;
	private String type;
	private String side;
	private Boolean dead;
	private int stamp;
	private TennisBall projectile;
		
		public TennisPlayer(double x, double y, String side) throws FileNotFoundException {
		super(new Image(new FileInputStream("./Pioneer.png"), 96, 96, true, true));
		this.type = "tennisplayer";
		this.side = side;
		this.setTranslateX(x);
		this.setTranslateY(y);
		health = 100;
		stamp = 0;
		dead = false;
		}
		
		@Override
		public void doMove() {
		if(side == "rechts") {
			if (stamp < 40) { 
				this.setTranslateX(this.getTranslateX() - 3);
				stamp++;
				return;
			}
			if (stamp > 40) {
				this.setTranslateX(this.getTranslateX() + 3);
				stamp++;
				return;
			}
		} else {
			if (stamp < 40) { 
				this.setTranslateX(this.getTranslateX() + 3);
				stamp++;
				return;
			}
			if (stamp > 40) {
				this.setTranslateX(this.getTranslateX() - 3);
				stamp++;
				return;
			}
		}
		}
		
		@Override
		public TennisBall shoot(Starship s) {
			projectile = null;
			if (stamp == 40) {
				try {
					projectile = new TennisBall(this.getTranslateX(), this.getTranslateY(), s);
					stamp++;
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
			System.out.println("DamageTaken");
			health -= 25;
			if (health <= 0) {
				this.setToDead();
			}
		}
}
