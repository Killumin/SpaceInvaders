package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import Projectiles.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Starship extends ImageView {
	
	private double velX = 0;
	private double velY = 0;
	
	private int health;
	private Boolean dead;

	public Starship(InputStream arg0, double arg1, double arg2, boolean arg3, boolean arg4) throws FileNotFoundException {
		super(new Image(new FileInputStream("./StarshipTimon.png"), arg1, arg2, arg3, arg4));
		health = 100;
		this.setTranslateX(0);
        this.setTranslateY(0);
        dead = false;
	}

	public void hit() {
		health-= 25;
		if(health < 1) {
			setDead();
		}
	}
    
    public void move() {
    	this.setTranslateX(this.getTranslateX() + velX);
    	this.setTranslateY(this.getTranslateY() + velY);
    }
	
    public Projectile shoot() throws FileNotFoundException {
    	return new Projectile(this.getTranslateX(), this.getTranslateY() - 40);
    }

    public void setDead() {
		this.dead = true;
	}
	
	public Boolean isDead() {
		return this.dead;
	}
	
	public void setVelX(double d) {
		this.velX = d;
	}
	
	public void setVelY(double d) {
		this.velY = d;
	}
}
