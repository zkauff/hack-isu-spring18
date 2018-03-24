package wizards.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	
	public Player(int x, int y) {
		super(x,y);
	}

	public void tick() {
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
		
	}

}
