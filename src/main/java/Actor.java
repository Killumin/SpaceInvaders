import Enums.ActorType;
import Enums.ShotType;

public abstract class Actor {

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
}
