package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpaceInvader extends ImageView{

private String type;
	
	public SpaceInvader(double x, double y) throws FileNotFoundException {
	super(new Image(new FileInputStream("./Starship.png"), 96, 96, true, true));
	this.type = "SpaceInvader";
	this.setTranslateX(x);
	this.setTranslateY(y);
	}
	
	String getType() {
		return this.type;
	}
}
