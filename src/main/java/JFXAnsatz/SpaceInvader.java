package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpaceInvader extends ImageView{

private String type;
private Boolean dead;
private int stamp;
	
	public SpaceInvader(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Starship.png"), 96, 96, true, true));
	this.type = "SpaceInvader";
	this.setTranslateX(x);
	this.setTranslateY(y);
	stamp = 0;
	dead = false;
	}
	
	void doMove() {
		if (stamp == 0) {
			this.setTranslateX(this.getTranslateX() - 35);
			stamp++;
			return;
		}
		if (stamp == 1) {
			this.setTranslateY(this.getTranslateY() - 35);
			stamp++;
			return;
		}
		if (stamp == 2) {
			this.setTranslateX(this.getTranslateX() + 35);
			stamp++;
			return;
		}
		if (stamp == 3) {
			this.setTranslateY(this.getTranslateY() + 35);
			stamp = 0;
			return;
		}
	}
	
	String getType() {
		return this.type;
	}
	
	void setDead() {
		this.dead = true;
	}
	
	Boolean isDead() {
		return this.dead;
	}
	
}
