package JFXAnsatz;

import java.util.concurrent.ThreadLocalRandom;
import java.io.FileNotFoundException;

import SpaceInvaders.SpaceInvader;
import SpaceInvaders.TennisPlayer;

public class WaveConstructionHelper {
	
	private static int stamp;
	private static boolean side;

	public static SpaceInvader NapstablookWave() throws FileNotFoundException {
		stamp++;
		if (stamp == 20 && side) {
			TennisPlayer a = new TennisPlayer(1000, ThreadLocalRandom.current().nextInt(-500, 500) ,"rechts");
			System.out.println(a.getTranslateY());
			stamp = 0;
			side = !side;
			return a;
		}
		if (stamp == 20 && !side) {
			TennisPlayer a = new TennisPlayer(-1000, ThreadLocalRandom.current().nextInt(-500, 500) ,"links");
			stamp = 0;
			side = !side;
			return a;
		}
		return null;
	}
}
