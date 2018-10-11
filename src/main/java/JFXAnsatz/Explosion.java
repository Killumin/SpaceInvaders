package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Explosion extends ImageView {
	
	private long timeStamp;

	public Explosion(double x, double y) throws FileNotFoundException {
		super (new Image(new FileInputStream("./explosion.gif"), 50, 50, true, true));
		this.setTranslateX(x);
		this.setTranslateY(y);
		timeStamp = System.currentTimeMillis();
	}
	
	public boolean check() {
		if(System.currentTimeMillis() - timeStamp > 1000) {
			return true;
		} else {
			return false;
		}
	}
	

}
