package wizards.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4984271202747625627L;
	public final int WIDTH = 1280, HEIGHT = WIDTH/12*9;
	
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Wizards Wonds", this);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public synchronized void start() {
		
		
		
	}
	
	public static void main(String args[]) {
		
		new Game();
		
	}

}
