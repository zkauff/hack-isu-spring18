package wizards.main;

public abstract class UtilitySpell extends Spell{

    public UtilitySpell(Game game, Element element, boolean isHarmful, String name, int cost) {
	super(game, 0, 0, cost, element);
	
    }
    
    public void effect(Wizard player, Wizard opponent) {
	switch(super.element) {
	case FIRE:
	    //make a fire wall
	    break;
	case WATER:
	    //TODO: make it last for 2 turns
	    opponent.status = StatusEffect.ATTACK_DOWN;
	    break;
	case STORM:
	    //TODO: make last for 2 turns and deal backlash damage
	    player.status = StatusEffect.DEFENSE_UP;
	    break;
	case NATURE:
	    player.curHP = player.curHP + 75;
	    break;
	case DEATH:
	    player.curHP += (int) opponent.curHP * .2;
	    opponent.curHP -= (int) opponent.curHP * .2;
	}
    }
    
    public abstract void cast(Wizard player);
}
