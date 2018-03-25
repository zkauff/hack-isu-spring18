package wizards.main;

import java.awt.Graphics;

public class HealSpell extends UtilitySpell {
    
    private int healValue;
    public HealSpell(Game game, int heal, Element element, String name, int cost) {
	super(game, element, false, name, cost);
	this.healValue = heal;
    }

    @Override
    public void cast(Wizard player) {
	if(player.element == Element.NATURE) {
	    player.curHP += healValue * 2;
	} else if(player.element == Element.DEATH){
	    player.curHP += healValue / 2;
	} else {
	    player.curHP += healValue;
	}
	
    }

    @Override
    public void render(Graphics g) {
	// TODO Auto-generated method stub
	
    }
}
