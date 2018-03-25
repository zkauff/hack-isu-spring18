package wizards.main;

import java.awt.Graphics;
import java.awt.Color;

public class Projectile{
    int speed;
    MotionValues values;
    Game game;
    public Projectile(Game game, double x, double y, int speed, double angle) {
	this.game = game;
	this.speed = speed;
	values = new MotionValues(x, y, speed * Math.cos(angle), speed * Math.sin(angle));
	// TODO Auto-generated constructor stub
    }


    public void render(Graphics g) {
	// TODO Auto-generated method stub
	long time = System.currentTimeMillis();
	long timePast = 0;
	while(this.values.posX <= 1280 && this.values.posX >= 0) {
	    timePast = System.currentTimeMillis() - time;
	    this.values.posX += this.values.vX * timePast / 1000.0;
	    this.values.vY -= 9.8 * (timePast / 1000.0)* (timePast / 1000.0);
	    this.values.posY -= this.values.vY * timePast / 1000.0;
	    g.setColor(Color.white);
	    g.fillOval((int)this.values.posX, (int)this.values.posY, 20, 20);
	}
	
    }

}
                                       