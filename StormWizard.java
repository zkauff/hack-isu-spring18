package wizards.main;

import java.awt.Graphics;

/**
 * Storm wizards have normal HP and deal basic damage. They can use ice,
 * lighting, and gust attacks.
 * 
 * @author zkauf
 *
 */
public class StormWizard extends Wizard {

    public StormWizard(String name,  int x, int y) {
	super(100, Element.STORM, name, x, y);
    }

    @Override
    public void passiveAbility() {

	
    }

    @Override
    public void tick() {
	// TODO Auto-generated method stub
	
    }

 
}
