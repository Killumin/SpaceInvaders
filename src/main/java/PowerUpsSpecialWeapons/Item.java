package PowerUpsSpecialWeapons;

import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Item extends ImageView {
	
	private String type;
	private Boolean dead;

	public Item(Image image) throws FileNotFoundException {
		super(image);
		this.type = "item";
		dead = false;
		}
	
	public String getType() {
		return this.type;
	}
	
	public void setDead() {
		this.dead = true;
	}
	
	public boolean isDead() {
		return this.dead;
	}
}
