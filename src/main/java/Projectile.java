//import Enums.ActorType;
//import Enums.Direction;
//import Enums.FieldType;
//import Enums.ShotType;
//
//public class Projectile extends Actor {
//	
//	private Map map;
//	private Direction dir;
//	private ShotType s;
//	private Field myField;
//	private int timeStamp;
//	private final int PROJECTILE_SPEED;
//	private boolean done;
//	private ActorType actType;
//
//	public Projectile(Field f, Direction dir, ShotType s, Map map,int w, int h) {
//		super(w,h);
//		this.map = map;
//		this.myField = f;
//		this.dir = dir;
//		this.s = s;
//		this.done = false;
//		if (s == ShotType.SINGLESHOT) { this.PROJECTILE_SPEED = 2000;}
//		else { this.PROJECTILE_SPEED = 3000;}
//		this.actType = ActorType.PROJECTILE;
//	}
//	
//	public void move() {
//		if(!done) {
//			try {
//		if (dir == Direction.UP) {  	if(this.map.getField(myField.getX(),myField.getY()+1).getType() == FieldType.WALL) 	
//										{ this.done = true;
//										  this.map.setActor(myField.getX(), myField.getY(), null);
//										}
//										else
//										{
//											Field temp = map.getField(this.myField.getX(), this.myField.getY()+1);
//											if (temp.getActor() != null) { collision(temp.getActor()); }
//											else 	
//											{
//											this.map.setActor(this.myField.getX(), this.myField.getY(), null);
//											this.myField = temp;
//											this.map.setActor(temp.getX(), temp.getY(), this);
//											}
//										}
//										}
//		if (dir == Direction.DOWN) {	if(this.map.getField(myField.getX(),myField.getY()-1).getType() == FieldType.WALL) 	
//										{ this.done = true; 
//										  this.map.setActor(myField.getX(), myField.getY(), null);
//										}
//										else
//										{
//											Field temp = map.getField(this.myField.getX(), this.myField.getY()-1);
//											if (temp.getActor() != null) { collision(temp.getActor()); }
//											else 	
//											{
//											this.map.setActor(this.myField.getX(), this.myField.getY(), null);
//											this.myField = temp;
//											this.map.setActor(temp.getX(), temp.getY(), this);
//											}
//										}
//										}
//			} catch (ArrayIndexOutOfBoundsException e) { this.done = true;
//														 this.map.setActor(myField.getX(), myField.getY(), null);
//													   }
//		System.out.println(this.s.toString() + myField.makeString());
//		}
//	}
//	
//	public int getTimeStamp() {
//		return this.timeStamp;
//	}
//	
//	public void setTimeStampBack() {
//		this.timeStamp = this.PROJECTILE_SPEED;
//	}
//	
//	public void increaseTimeStamp() {
//		this.timeStamp += this.PROJECTILE_SPEED;
//	}
//	
//	@Override
//	public void setDone() {
//		this.done = true;
//	}
//	
//	public boolean isDone() {
//		return this.done;
//	}
//	
//	public void collision(Actor act) {
//		if (act.getActorType() == ActorType.STARSHIP) {
//			act.hit(this.s);
//			this.map.setActor(myField.getX(), myField.getY(), null);
//			this.setDone();
//		}
//		if (act.getActorType() == ActorType.PROJECTILE) {
//			this.map.setActor(act.getField().getX(), act.getField().getY(), null);
//			act.setDone();
//			this.map.setActor(myField.getX(), myField.getY(), null);
//			this.setDone();
//		}
//		if (act.getActorType() == ActorType.SPACE_INVADER) {
//			act.hit(this.s);
//			this.map.setActor(myField.getX(), myField.getY(), null);
//			this.setDone();
//		}
//	}
//	
//	public Field getField() {
//		return this.myField;
//	}
//		
//	@Override
//	public ActorType getActorType() {
//		return this.actType;
//	}
//	
//	@Override
//	public ShotType getShotType() {
//		return this.s;
//	}
//	
//}
