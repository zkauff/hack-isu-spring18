package wizard_wars;
/**
 * Fire wizards have boosted fire attacks and a special firebomb attack. They have reduced health as a result of their high damage
 * @author zkauf
 *
 */
public class FireWizard extends Wizard{
    
    public FireWizard(String name) {
	super(75, Element.FIRE, name);
    }

    @Override
    public Spell castSuper() {
	// TODO Auto-generated method stub
	return new Super(50,50,50, Element.FIRE);
    }
    
  
  
}
