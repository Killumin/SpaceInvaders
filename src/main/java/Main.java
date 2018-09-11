import ControllerUndKI.StarshipController;

public class Main {

	public static void main(String[] args) {
		Map map = new Map();
		map.generate(0);
		Starship s = new Starship(map, map.getField(4, 10), null);
		Game g = new Game(map, s);
		g.start();
	}

}
