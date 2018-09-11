import java.util.ArrayList;

import Enums.Direction;
import Enums.ShotType;

public class Game {

	private int levelCounter;
	private Map map;
	private int points;
	private Starship star;
	private ArrayList<Actor> enemys;
	private ArrayList<Projectile> projectiles;
	private long startTime;
	private int x;
	
	public Game(Map map, Starship star) {
		this.map = map;
		this.star = star;
		this.enemys = new ArrayList<Actor>();
		this.projectiles = new ArrayList<Projectile>();
		this.points = 0;
		this.levelCounter = 1;
	}
	
	public void start() {
		this.startTime = System.currentTimeMillis();
		this.star.setTimeStampBack();
		this.map.setActor(star.getField().getX(), star.getField().getY(), star);
		this.projectiles.add(new Projectile(map.getField(4, 0), Direction.UP, ShotType.SINGLESHOT, map));
		while(!star.getGameOver()) {
		moveGame();
		}
	}
	
	public void moveGame() {
		
		clearProjectileListFromUnused();
		// Starship moving
		if (System.currentTimeMillis() - startTime > star.getTimeStamp()) {
			//star.move(Direction.LEFT);
			star.increaseTimeStamp();
			insertProjectiles();
		}
		// Projectiles moving
		for (int i = 0; i < projectiles.size(); i++) {
		if (System.currentTimeMillis() - startTime > projectiles.get(i).getTimeStamp()) {
			projectiles.get(i).move();
			projectiles.get(i).increaseTimeStamp();
		}
		}
		// Space Invaders moving
	}
	
	public void insertProjectiles() {
		projectiles.addAll(star.getProjectiles());
	}
	
	public void clearProjectileListFromUnused() {
		for (int i = 0; i<this.projectiles.size(); i++) {
			if (projectiles.get(i).isDone()) { projectiles.remove(i); }
		}
	}
	
	
}
