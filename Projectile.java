package wizards.main;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Projectile extends Spell implements Cloneable {
    private int speed;
    private int damage;
    private int areaOfEffect;
    private String name;
    private Wizard caster;

    public Projectile(Game game, Wizard caster, double x, double y, int speed, int damage, int aoe, int cost,
	    Element element, String name, double angle) {
	super(game, x, y, cost, element);
	this.caster = caster;
	this.name = name;
	this.game = game;
	this.speed = speed;
	this.damage = damage;
	this.areaOfEffect = aoe;
	values = new MotionValues(x, y, speed * Math.cos(angle), speed * Math.sin(angle));
	// TODO Auto-generated constructor stub
    }

    public void render(Graphics g) {
	// TODO Auto-generated method stub
	long time = System.currentTimeMillis();
	long timePast = 0;
	while (this.values.posX <= 1280 && this.values.posX >= 0) {
	    timePast = (System.currentTimeMillis() - time) / 50;
	    this.values.posX += this.values.vX * timePast / 1000.0;
	    this.values.vY -= 98 * (timePast / 1000.0) * (timePast / 1000.0);
	    this.values.posY -= this.values.vY * timePast / 1000.0;
	    if (element != Element.DEATH) {
		g.setColor(this.color);
		g.fillOval((int) this.values.posX, (int) this.values.posY, areaOfEffect, areaOfEffect);
		int fontSize = 20;
		g.setFont(new Font("Helvetica", Font.PLAIN, fontSize));
		g.drawString(this.name, 640, 20);
	    } else {
		g.setColor(Color.WHITE);
		g.drawOval((int) this.values.posX, (int) this.values.posY, areaOfEffect, areaOfEffect);
		int fontSize = 20;
		g.setFont(new Font("Helvetica", Font.PLAIN, fontSize));
		g.drawString(this.name, 640, 20);
	    }
	    if (caster == game.player1) {
		boolean collision = Physics.collision(this.getX(), this.getY(), this.areaOfEffect, game.player2.getX(),
			game.player2.getY(), game.player2.getX() + 50, game.player2.getY() + 50);
		if (collision) {
		    game.player2.curHP -= this.damage;
		}
	    } else {
		boolean collision = Physics.collision(this.getX(), this.getY(), this.areaOfEffect, game.player1.getX(),
			game.player1.getY(), game.player1.getX() + 50, game.player1.getY() + 50);
		if (collision) {
		    game.player1.curHP -= this.damage;
		}
	    }

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
    public Object clone() {
	try {
	    return super.clone();
	} catch (CloneNotSupportedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
	
    }

}
