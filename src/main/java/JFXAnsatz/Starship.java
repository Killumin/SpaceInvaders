package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Starship extends Image {

	public Starship(InputStream arg0, double arg1, double arg2, boolean arg3, boolean arg4) throws FileNotFoundException {
		super(new FileInputStream("./Starship.png"), arg1, arg2, arg3, arg4);
	}

//	public Starship(int x, int y, int w, int h, String type, Color color) {
//        super(w, h, color);
//
//        setTranslateX(x);
//        setTranslateY(y);
//    }

    public ImageView init() {
    	
    	ImageView RealShip = new ImageView(this);
    	RealShip.setTranslateX(0);
        RealShip.setTranslateY(0);
    	return RealShip;
    }
    
    void moveLeft(ImageView iv) {
        iv.setTranslateX(iv.getTranslateX() - 15);
    }

    void moveRight(ImageView iv) {
    	iv.setTranslateX(iv.getTranslateX() + 15);
    }

    void moveUp(ImageView iv) {
    	iv.setTranslateY(iv.getTranslateY() - 15);
    }

    void moveDown(ImageView iv) {
    	iv.setTranslateY(iv.getTranslateY() + 15);
    }
	

}
