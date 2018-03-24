package wizard_wars;

/**
 * Storm wizards have normal HP and deal basic damage. They can use ice,
 * lighting, and gust attacks.
 * 
 * @author zkauf
 *
 */
public class StormWizard extends Wizard {
    
    public StormWizard() {
	super(100, Element.STORM);
    }

    @Override
    public Attack castSuper() {
	// TODO Auto-generated method stub
	return null;
    }
}