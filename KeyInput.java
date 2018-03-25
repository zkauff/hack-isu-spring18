package wizards.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
	this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	GameObject temp = null;
	for (int i = 0; i < handler.objects.size(); i++) {
	    temp = handler.objects.get(i);
	    if (temp.id == ID.PLAYER_TWO) {
		if (key == KeyEvent.VK_D) {
		    handler.objects.get(i).values.posX += 15;
		} else if (key == KeyEvent.VK_A) {
		    handler.objects.get(i).values.posX -= 15;
		} else if (key == KeyEvent.VK_W) {
		    handler.objects.get(i).values.posY -= 15;
		} else if (key == KeyEvent.VK_S) {
		    handler.objects.get(i).values.posY += 15;
		} else if (key == KeyEvent.VK_X) {
		    Projectile attack = new Projectile(temp.game, temp.getX(), temp.getY(), -15, 60.0);
		    attack.render(temp.game.getGraphics());
		}
		// TODO: check if they can move
	    } else if (temp.id == ID.PLAYER_ONE) {
		if (key == KeyEvent.VK_LEFT) {
		    handler.objects.get(i).values.posX -= 15;
		} else if (key == KeyEvent.VK_RIGHT) {
		    handler.objects.get(i).values.posX += 15;
		}else if (key == KeyEvent.VK_UP) {
		    handler.objects.get(i).values.posY -= 15;
		}else if (key == KeyEvent.VK_DOWN) {
		    handler.objects.get(i).values.posY += 15;
		}else if (key == KeyEvent.VK_ENTER) {
		    Projectile attack = new Projectile(temp.game, temp.getX(), temp.getY(), 15, 120.0);
		    attack.render(temp.game.getGraphics());
		}
	    }
	}

    }

    public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();
    }
}
