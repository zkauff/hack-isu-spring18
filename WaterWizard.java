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
    
    public WaterWizard() {
	super(120, Element.WATER);
    }

    @Override
    public Attack castSuper() {
	return new Super(5,5,100,Element.WATER);
    }
}
