package wizard_wars;

/**
 * Water wizards have boosted HP and can deal more AOE damage. Their special
 * attack floods the stage, making certain areas nonaccessible to anyone besides
 * water wizards.
 * 
 * @author zkauf
 *
 */
public class WaterWizard extends Wizard {
    
    public WaterWizard(String name) {
	super(120, Element.WATER, name);
    }

  
}
