package Events;

public interface GUIListener {
	
	public void gameOver(GameOverEvent event);
	public void starshipMoved(StarshipMovedEvent event);
}
