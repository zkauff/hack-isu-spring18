package wizards.main;

import java.awt.Graphics;

/**
 * Water wizards have boosted HP and can deal more AOE damage. Their special
 * attack floods the stage, making certain areas nonaccessible to anyone besides
 * water wizards.
 * 
 * @author zkauf
 *
 */
public class WaterWizard extends Wizard {
    
    public WaterWizard(String name, int x, int y) {
	super(120, Element.WATER, name, x, y);
    }

    @Override
    public void passiveAbility() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void tick() {
	// TODO Auto-generated method stub
	
    }

  
}
