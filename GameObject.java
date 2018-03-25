package wizards.main;

import java.awt.Graphics;
import java.awt.Color;
public abstract class GameObject {
	
	protected MotionValues values;
	public Color color;
	public ID id;
	public Game game;
	
	public GameObject(Game game, double x, double y, Element element, ID id) {
		values = new MotionValues(x, y, 0, 0);
		this.game = game;
		this.id = id;
		switch(element) {
		case FIRE:
		    this.color = Color.RED;
		    break;
		case WATER:
		    this.color = Color.BLUE;
		    break;
		case STORM:
		    this.color = Color.CYAN;
		    break;
		case NATURE:
		    this.color = Color.GREEN;
		    break;
		case DEATH:
		    this.color = Color.BLACK;
		}
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public double getX() {
		return values.posX;
	}

	public void setX(int x) {
		values.posX = x;
	}

	public double getY() {
		return values.posY;
	}

	public void setY(int y) {
		values.posY = y;
	}

	public double getVelX() {
		return values.vX;
	}

	public void setVelX(int velX) {
		values.vX = velX;
	}

	public double getVelY() {
		return values.vY;
	}

	public void setVelY(int velY) {
		values.vY = velY;
	}
	
	
	
}