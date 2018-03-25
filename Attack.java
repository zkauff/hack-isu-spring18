package wizards.main;

import java.awt.Graphics;
import java.awt.Color;

public class Attack extends Spell {
    private int damage;
    private int speed;
    private int areaOfEffect;
    private Color color;

    public Attack(Game game, int damage, int speed, int aoe, Element element, String name, int cost) {
	super(game, element, true, name, cost);
	this.damage = damage;
	this.speed = speed;
	this.areaOfEffect = aoe;
	switch (element) {
	case FIRE:
	    color = Color.RED;
	    break;
	case WATER:
	    color = Color.BLUE;
	    break;
	case STORM:
	    color = Color.CYAN;
	    break;
	case NATURE:
	    color = Color.GREEN;
	    break;
	case DEATH:
	    color = Color.BLACK;
	    break;
	}
    }

    public void setDamage(int damage) {
	this.damage = damage;
    }

    public int getDamage() {
	return damage;
    }

    public void setSpeed(int speed) {
	this.speed = speed;
    }

    public int getSpeed() {
	return speed;
    }

    public int getAOE() {
	return areaOfEffect;
    }

    public void setAOE(int aoe) {
	areaOfEffect = aoe;
    }

    @Override
    public void tick() {
	// TODO Auto-generated method stub
	values.posX += values.vX;
	values.posY -= 10;

    }

    @Override
    public void render(Graphics g) {
	for(int i = 0; i < 500; i++) {
	    g.drawOval((int)values.posX, (int)values.posY, 20, 20);
	}

    }

}
