

/**
 * Necromancers with very little health but the ability to deal insane damage
 * and resurrect.
 * 
 * @author zkauf
 *
 */
public class DeathWizard extends Wizard {
    boolean resurrected = false;

    public DeathWizard(String name) {
	super(55, Element.DEATH, name);
	defUp = 5;
	atkUp = 15;
    }

    @Override
    public void passiveAbility() {
	if (this.curHP <= 0 && resurrected == false) {
	    this.curHP = 50;
	    resurrected = true;
	}

    }

}
