import ControllerUndKI.KI;
import Enums.ActorType;
import Enums.Direction;
import Enums.ShotType;
import Enums.SpaceInvaderType;

public class SpaceInvader extends Actor {

	private KI controls;
	private int health;
	private SpaceInvaderType type;
	private Field myField;
	private Map map;
	private boolean dead;
	private int timeStamp;
	private int SPACE_INVADER_SPEED;
	private ActorType actType;
	
	public SpaceInvader(SpaceInvaderType type, Map map, KI controls, Field f) {
		SPACE_INVADER_SPEED = 1000;
		if (type == SpaceInvaderType.PARSEC) {
		this.type = type;
		this.controls = controls;
		this.map = map;
		this.myField = f;
		this.health = 50;
		this.dead = false;
		this.SPACE_INVADER_SPEED = 1000;
		this.actType = ActorType.SPACE_INVADER;
	}
		if (type == SpaceInvaderType.MEGAPARSEC) {
		this.type = type;
		this.controls = controls;
		this.map = map;
		this.myField = f;
		this.health = 100;
		this.dead = false;
		this.SPACE_INVADER_SPEED = 1500;
		this.actType = ActorType.SPACE_INVADER;
	}
	}
	
	public void move() {
		Direction dir = controls.getMove();
		try {
		switch (dir) {
		case UP:	{Field temp = this.map.getField(myField.getX(),myField.getY()+1);
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{
							this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							this.myField = temp;
							this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
					break;
		case DOWN:  {Field temp = this.map.getField(myField.getX(),myField.getY()-1);
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{
							this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							this.myField = temp;
							this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
					break;
		case RIGHT: {Field temp = this.map.getField(myField.getX()+1,myField.getY());
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{
							this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							this.myField = temp;
							this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
					break;
		case LEFT: 	{Field temp = this.map.getField(myField.getX()-1,myField.getY());
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{
							this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							this.myField = temp;
							this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
		default:
			break;
		}
		} catch (ArrayIndexOutOfBoundsException e) { }
	}
	
	public void collision(Actor act) {
		if (act.getActorType() == ActorType.STARSHIP) {
			this.map.setActor(this.myField.getX(), this.myField.getY(), null);
			this.dead = true;
			act.GameOver();
		}
		if (act.getActorType() == ActorType.SPACE_INVADER) {}
		if (act.getActorType() == ActorType.PROJECTILE) {
			hit(act.getShotType());
			this.map.setActor(act.getField().getX(), act.getField().getY(), null);
		}
	}
	
	@Override
	public void hit(ShotType s) {
		switch (s) {
		case SINGLESHOT: this.health -= 25;
						 break;
		case BIGSHOT:	 this.health -= 50;
		}
		if (this.health <= 0) {
			this.dead = true;
		}
	}
		
	public boolean isDead() {
		return dead;
	}
	
	public int getTimeStamp() {
		return this.timeStamp;
	}
	
	public void setTimeStampBack() {
		this.timeStamp = SPACE_INVADER_SPEED;
	}
	
	public void increaseTimeStamp() {
		this.timeStamp += SPACE_INVADER_SPEED;
	}
	
	@Override
	public ActorType getActorType() {
		return this.actType;
	}
	
	@Override
	public Field getField() {
		return this.myField;
	}
}
