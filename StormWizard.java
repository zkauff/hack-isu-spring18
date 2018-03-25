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

    public StormWizard(Game game, String name,  int x, int y, ID id) {
	super(game, 100, Element.STORM, name, x, y, id);
    }

    @Override
    public void passiveAbility() {

	
    }

    

 
}
