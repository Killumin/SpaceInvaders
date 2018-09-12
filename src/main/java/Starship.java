import java.util.ArrayList;
import ControllerUndKI.StarshipController;
import Enums.ActorType;
import Enums.Direction;
import Enums.FieldType;
import Enums.ShotType;

public class Starship extends Actor {

	private Map map;
	private Field myField;
	private int health;
	private ArrayList<Projectile> projectiles;
	private int timeStamp;
	private boolean gameOver;
	private static final int SHIP_SPEED = 1000;
	private StarshipController controls;
	private ActorType actType;

	public Starship(Map map,Field f,int w,int h) {
		super(w,h);
		this.projectiles = new ArrayList<Projectile>();
		this.map = map;
		this.myField = f;
		this.health = 100;
		this.gameOver = false;
		this.controls = controls;
		this.actType = ActorType.STARSHIP;
	}
	
	public void move(Direction dir) {
		try {
		switch (dir) {
		case UP:	if(this.map.getField(myField.getX(),myField.getY()+1).getType() != FieldType.WALL) {
					Field temp = this.map.getField(myField.getX(),myField.getY()+1);
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{ this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							  this.myField = temp;
							  this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
					break;
		case DOWN: 	if(this.map.getField(myField.getX(),myField.getY()-1).getType() != FieldType.WALL) {
					Field temp = this.map.getField(myField.getX(),myField.getY()-1);
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{ this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							  this.myField = temp;
							  this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
					break;
		case RIGHT: if(this.map.getField(myField.getX()+1,myField.getY()).getType() != FieldType.WALL) {
					Field temp = this.map.getField(myField.getX()+1,myField.getY());
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{ this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							  this.myField = temp;
							  this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
					break;
		case LEFT: 	if(this.map.getField(myField.getX()-1,myField.getY()).getType() != FieldType.WALL) {
					Field temp = this.map.getField(myField.getX()-1,myField.getY());
					if (temp.getActor() != null) { collision(temp.getActor()); }
					else 	{ this.map.setActor(this.myField.getX(), this.myField.getY(), null);
							  this.myField = temp;
							  this.map.setActor(temp.getX(), temp.getY(), this);
							}
					}
		default:
			break;
		}
		} catch (ArrayIndexOutOfBoundsException e) { }
		System.out.println("Starship" + myField.makeString());
	}
	
	public void shoot(Direction dir) {
		switch (dir) {
		case RIGHTCLICK:projectiles.add(new Projectile(this.map.getField(myField.getX(), myField.getY()+1), Direction.UP, ShotType.SINGLESHOT, map,5,5));
						break;
		case LEFTCLICK: projectiles.add(new Projectile(this.map.getField(myField.getX(), myField.getY()+1), Direction.UP, ShotType.BIGSHOT, map,5,5));
		default:
			break;
		}
	}
	
	@Override
	public void hit(ShotType s) {
		switch (s) {
		case SINGLESHOT: this.health -= 25;
						 break;
		case BIGSHOT:	 this.health -= 50;
		}
		System.out.println("Current Health: " + this.getHealth());
		if (this.health <= 0) {
			GameOver();
		}
	}
	
	public void collision(Actor act) {
		if (act.getActorType() == ActorType.PROJECTILE) {
			hit(act.getShotType());
			this.map.setActor(act.getField().getX(), act.getField().getY(), null);
		}
		if (act.getActorType() == ActorType.SPACE_INVADER) {
			this.map.setActor(act.getField().getX(), act.getField().getY(), null);
			GameOver();
		}
	}
	
	@Override
	public void GameOver() {
		this.gameOver = true;
		this.map.setActor(myField.getX(), myField.getY(), null);
		System.out.println("Game Over");
	}
	
	public boolean getGameOver() {
		return this.gameOver;
	}
	
	public ArrayList<Projectile> getProjectiles() {
		ArrayList<Projectile> temp = new ArrayList<Projectile>();
		temp.addAll(this.projectiles);
		this.projectiles.clear();
		return temp;
	}
	
	@Override
	public Field getField() {
		return this.myField;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getTimeStamp() {
		return this.timeStamp;
	}
	
	public void setTimeStampBack() {
		this.timeStamp = SHIP_SPEED;
	}
	
	public void increaseTimeStamp() {
		this.timeStamp += SHIP_SPEED;
	}
	
	public StarshipController getController() {
		return this.controls;
	}
	
	@Override
	public ActorType getActorType() {
		return this.actType;
	}
}
