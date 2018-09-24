package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Projectile extends ImageView {
	
	private String type;
	
	public Projectile(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Graphics/Bullet.png"), 16, 16, true, true));
	this.type = "projectile";
	this.setTranslateX(x);
	this.setTranslateY(y);
	}
	
	void move() {
		this.setTranslateY(this.getTranslateY()-10);
		}
	
	String getType() {
		return this.type;
	}
}

