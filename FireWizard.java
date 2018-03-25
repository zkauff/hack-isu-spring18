package wizards.main;

import java.awt.Graphics;

/**
 * Fire wizards have boosted fire attacks and a special firebomb attack. They
 * have reduced health as a result of their high damage. They deal more damage
 * as they lose health, building up a rage meter, fueling their fire attacks
 * further.
 * 
 * @author zkauf
 *
 */
public class FireWizard extends Wizard {

    public FireWizard(String name, int x, int y) {
	super(75, Element.FIRE, name, x, y);
    }

    @Override
    public void passiveAbility() {
	int rage = maxHP - curHP;
	damageBoost += rage;

    }

    @Override
    public void tick() {
	// TODO Auto-generated method stub
	
    }


}
