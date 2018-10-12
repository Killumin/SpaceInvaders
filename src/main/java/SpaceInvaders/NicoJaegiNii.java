package SpaceInvaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Projectiles.WellenStrahlen;
import javafx.scene.image.Image;

public class NicoJaegiNii extends SpaceInvader {

	private String type;
	private Boolean dead;
	private int health;
	private int stamp;
	private WellenStrahlen projectile;
		
		public NicoJaegiNii(double x, double y) throws FileNotFoundException {
		super(new Image(new FileInputStream("./Pioneer.png"), 96, 96, true, true));
		this.type = "telewelle";
		this.setTranslateX(x);
		this.setTranslateY(y);
		health = 100;
		stamp = 0;
		dead = false;
		}

}
