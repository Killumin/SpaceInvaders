package ControllerUndKI;

import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class StarshipController implements KeyListener{
	
	private int key;
	private TextField tf;
	
	public StarshipController() {
		  tf = new TextField("Label");
		  tf.addKeyListener(this);
	      tf.requestFocus();
	      while(true) {}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		int key = arg0.getKeyCode();
		this.key = key;
		System.out.println(key+1);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int keyOut() {
		return key;
	}
}
