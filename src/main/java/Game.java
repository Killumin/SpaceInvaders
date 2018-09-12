import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;

import ControllerUndKI.ParsecKI;
import Enums.Direction;
import Enums.SpaceInvaderType;
import Events.GUIListener;
import Events.GameOverEvent;
import Events.StarshipMovedEvent;

public class Game {

	private int levelCounter;
	private Map map;
	private int points;
	private Starship star;
	private ArrayList<SpaceInvader> enemys;
	private ArrayList<Projectile> projectiles;
	private long startTime;
	private GUIListener listener;
	
	public Game(Map map, Starship star) {
		this.map = map;
		this.star = star;
		this.enemys = new ArrayList<SpaceInvader>();
		this.projectiles = new ArrayList<Projectile>();
		this.points = 0;
		this.levelCounter = 1;
	}
	
	public void start() {
		this.startTime = System.currentTimeMillis();
		this.star.setTimeStampBack();
		this.map.setActor(star.getField().getX(), star.getField().getY(), star);
		prepareLevel(this.levelCounter);
		while(!star.getGameOver()) {
		moveGame();
		}
		GameOverEvent e = new GameOverEvent();
		listener.gameOver(e);
	}
	
	public void moveGame() {
		clearProjectileListFromUnused();
		clearEnemyListFromUnused();
		// Starship moving
		if (System.currentTimeMillis() - startTime > star.getTimeStamp()) {
			star.move(Direction.DOWN);
			StarshipMovedEvent e = new StarshipMovedEvent();
			listener.starshipMoved(e);
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
		for (int i = 0; i < enemys.size(); i++) {
			if (System.currentTimeMillis() - startTime > enemys.get(i).getTimeStamp()) {
				//enemys.get(i).move();
				enemys.get(i).increaseTimeStamp();
		}
		}
	}
	
	public void prepareLevel(int i) {
		//this.projectiles.add(new Projectile(map.getField(4, 0), Direction.UP, ShotType.SINGLESHOT, map));
		this.enemys.add(new SpaceInvader(SpaceInvaderType.PARSEC, map, new ParsecKI(), map.getField(4, 10),20,20));
		this.map.setActor(4, 10, enemys.get(0));
	}
	
	public void insertProjectiles() {
		projectiles.addAll(star.getProjectiles());
	}
	
	public void clearProjectileListFromUnused() {
		for (int i = 0; i<this.projectiles.size(); i++) {
			if (projectiles.get(i).isDone()) { projectiles.remove(i); }
		}
	}
	
	public void clearEnemyListFromUnused() {
		for (int i = 0; i<this.enemys.size(); i++) {
			if (enemys.get(i).isDead()) { enemys.remove(i); }
		}
	}
	
	public synchronized void addGUIListener(GUIListener listener) {
		this.listener = listener;
	}
	
	public synchronized void removeGUIListener(GUIListener listener) {
		this.listener = null;
	}
	
}
