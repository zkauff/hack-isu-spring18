package wizards.main;

import java.awt.Graphics;

/**
 * Earth wizards deal more AOE damage and have boosted health. Individual damage
 * is lackluster. AOE damaged increases as health decreases.
 * 
 * @author zkauf
 *
 */
public class NatureWizard extends Wizard {

    public NatureWizard(Game game, String name, int x, int y, ID id) {
	super(game, 175, Element.NATURE, name, x, y, id);
    }

    @Override
    public void passiveAbility() {
	if(this.curHP <= 50) {
	    for(Spell s : boosted) {
		if(s.isHarmful) {
		    Projectile e = (Projectile) s;
		    e.setAOE(e.getAOE() + 15);
		}
	    }
	}
	
    }



 

}
