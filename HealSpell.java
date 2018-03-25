package wizards.main;

public class HealSpell extends UtilitySpell {
    
    private int healValue;
    public HealSpell(int heal, Element element, String name, int cost) {
	super(element, false, name, cost);
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
}
