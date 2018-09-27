package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Starship extends ImageView {
	
	private Boolean dead;

	public Starship(InputStream arg0, double arg1, double arg2, boolean arg3, boolean arg4) throws FileNotFoundException {
		super(new Image(new FileInputStream("./StarshipTimon.png"), arg1, arg2, arg3, arg4));
		this.setTranslateX(0);
        this.setTranslateY(0);
        dead = false;
	}

//	public Starship(int x, int y, int w, int h, String type, Color color) {
//        super(w, h, color);
//
//        setTranslateX(x);
//        setTranslateY(y);
//    }
    
    void moveLeft() {
        this.setTranslateX(this.getTranslateX() - 15);
    }

    void moveRight() {
    	this.setTranslateX(this.getTranslateX() + 15);
    }

    void moveUp() {
    	this.setTranslateY(this.getTranslateY() - 15);
    }

    void moveDown() {
    	this.setTranslateY(this.getTranslateY() + 15);
    }
	
    Projectile shoot() throws FileNotFoundException {
    	return new Projectile(this.getTranslateX(), this.getTranslateY() - 40);
    }

    void setDead() {
		this.dead = true;
	}
	
	Boolean isDead() {
		return this.dead;
	}
}
