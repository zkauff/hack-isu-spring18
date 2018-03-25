package wizards.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Game game;
    public KeyInput(Game game) {
	this.game = game;
    }

    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	handleKey(key);
    }

    public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();
    }
    
    public void handleKey(int key) {
	GameObject temp = null;
	for (int i = 0; i < game.handler.objects.size(); i++) {
	    temp = game.handler.objects.get(i);
	    if (temp.id == ID.PLAYER_ONE) {
		if (key == KeyEvent.VK_D) {
		    game.handler.objects.get(i).values.posX += 15;
		} else if (key == KeyEvent.VK_A) {
		    game.handler.objects.get(i).values.posX -= 15;
		} else if (key == KeyEvent.VK_W) {
		    game.handler.objects.get(i).values.posY -= 15;
		} else if (key == KeyEvent.VK_S) {
		    game.handler.objects.get(i).values.posY += 15;
		} else if (key == KeyEvent.VK_X) {
		    Projectile attack = (Projectile) ((Wizard)temp).boosted.get(i); //TODO: return a clone
		    attack.render(temp.game.getGraphics());
		}
		// TODO: check if they can move
	    } else if (temp.id == ID.PLAYER_TWO) {
		if (key == KeyEvent.VK_LEFT) {
		    game.handler.objects.get(i).values.posX -= 15;
		} else if (key == KeyEvent.VK_RIGHT) {
		    game.handler.objects.get(i).values.posX += 15;
		}else if (key == KeyEvent.VK_UP) {
		    game.handler.objects.get(i).values.posY -= 15;
		}else if (key == KeyEvent.VK_DOWN) {
		    game.handler.objects.get(i).values.posY += 15;
		}else if (key == KeyEvent.VK_ENTER) {
		    Projectile attack = (Projectile) ((Wizard)temp).boosted.get(i);//TODO: return a clone
		    attack.render(temp.game.getGraphics());
		}
	    }
	}
    }
}
