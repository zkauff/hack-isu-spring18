package wizards.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PlayerOneMenu {
	
	public Rectangle enterName = new Rectangle((1280/2) - 125, 125, 250, 50);
	public Rectangle deathWiz = new Rectangle(10, 360, 200, 75);
	public Rectangle waterWiz = new Rectangle(266, 360, 200, 75);
	public Rectangle fireWiz = new Rectangle(266*2, 360, 200, 75);
	public Rectangle earthWiz = new Rectangle(266*3, 360, 200, 75);
	public Rectangle natureWiz = new Rectangle(266*4, 360, 200, 75);
	public Rectangle startGameButton = new Rectangle(865, 750, 215, 100);
    public Rectangle quitGameButton = new Rectangle(200, 750, 215, 100);
	
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font fnt1 = new Font("sans", Font.BOLD, 50);
		Font fnt2 = new Font("sans", Font.BOLD, 25);
		g.setFont(fnt1);
		g.setColor(Color.BLACK);
		g.drawString("Player One",515, 50);
		g.setFont(fnt2);
		g.drawString("Enter Name", 578, 107);
		g.drawString("Choose your Wizard!", 515, 330);
		
		g2d.draw(enterName);
		g2d.setColor(Color.BLACK);
		g2d.draw(deathWiz);
		g2d.fill(deathWiz);
		g2d.setColor(Color.CYAN);
		g2d.draw(waterWiz);
		g2d.fill(waterWiz);
		g2d.setColor(Color.RED);
		g2d.draw(fireWiz);
		g2d.fill(fireWiz);
		g2d.setColor(Color.GRAY);
		g2d.draw(earthWiz);
		g2d.fill(earthWiz);
		g2d.setColor(Color.GREEN);
		g2d.draw(natureWiz);
		g2d.fill(natureWiz);
		g2d.draw(startGameButton);
        g2d.fill(startGameButton);
        g2d.draw(quitGameButton);
        g2d.fill(quitGameButton);

        //fnt2 = new Font("sans", Font.BOLD, 65);
        g.setFont(fnt2);
        g.setColor(Color.BLACK);
        g.drawString("Quit", 230, 825);
        g.drawString("Start", 895, 825);
		
		g.setColor(Color.WHITE);
		g.drawString("DEATH",65, 407);
		g.setColor(Color.BLACK);
		g.drawString("WATER", 321, 407);
		g.drawString("FIRE", 605, 407);
		g.drawString("STORM", 853, 407);
		g.drawString("NATURE", 1116, 407);
		
		
	}
	
	
	
}
