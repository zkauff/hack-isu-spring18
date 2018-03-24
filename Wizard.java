package wizard_wars;

import java.util.ArrayList;

public abstract class Wizard {
    
    public int maxHP;
    public int curHP;
    public int superMeter;
    public Element element;
    // every attack gets boosted by a set amount of damage if the Element of the
    // spell matches the Element of the wizard casting it
    protected int damageBoost;
    // every attack has an element, and each wizard can use any spell they wish.
    // Before casting a spell, the damage said spell will do is calclated by
    // checking the boosted list.
    protected ArrayList<Attack> fireAttacks;
    protected ArrayList<Attack> waterAttacks;
    protected ArrayList<Attack> stormAttacks;
    protected ArrayList<Attack> natureAttacks;
    protected ArrayList<Attack> deathAttacks;
    // references the attacklist of the element this wizard has boosted
    protected ArrayList<Attack> boosted;

    public Wizard(int hp, Element element) {
	this.maxHP = hp;
	this.curHP = maxHP;
	superMeter = 0;
	this.element = element;
	switch (element) {
	case FIRE:
	    this.boosted = fireAttacks;
	    damageBoost = 25;
	    break;
	case WATER:
	    this.boosted = waterAttacks;
	    damageBoost = 15;
	    break;
	case STORM:
	    this.boosted = stormAttacks;
	    damageBoost = 20;
	    break;
	case NATURE:
	    this.boosted = natureAttacks;
	    damageBoost = 10;
	    break;
	case DEATH:
	    this.boosted = deathAttacks;
	    damageBoost = 10;
	    break;
	}

    }

    public Attack castSpell(Attack projectile) {
	if (boosted.contains(projectile)) {
	    projectile.setDamage(projectile.getDamage() + 10);
	}
	return null;
    }
    
    public abstract Attack castSuper();

}
