package wizard_wars;

public class UtilitySpells extends Spell{

    public UtilitySpells(Element element, boolean isHarmful, String name) {
	super(element, isHarmful, name);
	
    }
    
    public void effect(Wizard player, Wizard opponent) {
	switch(this.element) {
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
}
