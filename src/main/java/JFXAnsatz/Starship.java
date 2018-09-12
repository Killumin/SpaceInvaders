package JFXAnsatz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Starship extends Image {

	public Starship(InputStream arg0, double arg1, double arg2, boolean arg3, boolean arg4) throws FileNotFoundException {
		super(new FileInputStream("C:\\Users\\Timon\\Pictures\\Starship.png"), arg1, arg2, arg3, arg4);
	}

//	public Starship(int x, int y, int w, int h, String type, Color color) {
//        super(w, h, color);
//
//        setTranslateX(x);
//        setTranslateY(y);
//    }

    public ImageView init() {
    	
    	ImageView RealShip = new ImageView(this);
    	return RealShip;
    }
    
    void moveLeft(ImageView iv) {
        iv.setX(iv.getX() - 5);
    }

    void moveRight(ImageView iv) {
    	iv.setX(iv.getX() - 5);
    }

    void moveUp(ImageView iv) {
    	iv.setY(iv.getY() + 5);
    }

    void moveDown(ImageView iv) {
    	iv.setY(iv.getY() + 5);
    }
	

}
