import Enums.FieldType;

public class Field {

	private int x;
	private int y;
	private FieldType type;
	private Actor actor;
	
	public Field(int x, int y, FieldType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public FieldType getType() {
		return this.type;
	}
	
	public Actor getActor() {
		return this.actor;
	}
	
	public void setActor(Actor act) {
		if (act == null) { System.out.println("Removed Actor from Field " + x + " " + y);
		} else {
			System.out.println("Placed Actor " + act.getActorType().toString() + " to Field " + x + " " + y);
		}
		this.actor = act;
	}
	
	public String makeString() {
		return " moved to " + this.getX() + " " + this.getY(); 
	}
}
