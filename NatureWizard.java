

/**
 * Earth wizards deal more AOE damage and have boosted health. Individual damage
 * is lackluster. AOE damaged increases as health decreases.
 * 
 * @author zkauf
 *
 */
public class NatureWizard extends Wizard {

    public NatureWizard(String name) {
	super(175, Element.NATURE, name);
    }

    @Override
    public void passiveAbility() {
	if(this.curHP <= 50) {
	    for(Spell s : boosted) {
		if(s.isHarmful) {
		    Attack e = (Attack) s;
		    e.setAOE(e.getAOE() + 15);
		}
	    }
	}
	
    }

 

}
