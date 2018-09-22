package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Projectile extends ImageView {
	
	public Projectile(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Bullet.png"), 16, 16, true, true));
	this.setTranslateX(x);
	this.setTranslateY(y);
	}
}
