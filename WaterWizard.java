package wizards.main;

/**
 * Water wizards have boosted HP and can deal more AOE damage. Their special
 * attack floods the stage, making certain areas nonaccessible to anyone besides
 * water wizards.
 * 
 * @author zkauf
 *
 */
public class WaterWizard extends Wizard {
    
    public WaterWizard(Game game, String name, int x, int y, ID id) {
	super(game, 120, Element.WATER, name, x, y, id);
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
