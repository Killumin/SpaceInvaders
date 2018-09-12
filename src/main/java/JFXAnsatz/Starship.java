package JFXAnsatz;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Starship extends Rectangle {

//	public Starship(InputStream arg0, double arg1, double arg2, boolean arg3, boolean arg4) {
//		super(arg0, arg1, arg2, arg3, arg4);
//		// TODO Auto-generated constructor stub
//	}

	public Starship(int x, int y, int w, int h, String type, Color color) {
        super(w, h, color);

        setTranslateX(x);
        setTranslateY(y);
    }

    void moveLeft() {
        setTranslateX(getTranslateX() - 5);
    }

    void moveRight() {
        setTranslateX(getTranslateX() + 5);
    }

    void moveUp() {
        setTranslateY(getTranslateY() - 5);
    }

    void moveDown() {
        setTranslateY(getTranslateY() + 5);
    }
	

}
