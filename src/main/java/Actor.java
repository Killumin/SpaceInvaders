import com.sun.javafx.geom.Rectangle;
import Enums.ActorType;
import Enums.ShotType;

public abstract class Actor extends Rectangle {
	
	public Actor(int w, int h) {
		super(w,h);
	}

	public ActorType getActorType() {
		return null;}
	
	public ShotType getShotType() {
		return null;
	}
	
	public Field getField() {
		return null;
	}
	
	public void setDone() {
	}
	
	public void hit(ShotType s) {
	}
	
	public void GameOver() {
	}
}
