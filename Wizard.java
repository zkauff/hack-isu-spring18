package wizard_wars;

import java.util.ArrayList;

public abstract class Wizard {
    public String name;
    public int maxHP;
    public int curHP;
    public int superMeter;
    public Element element;
    public StatusEffect status = StatusEffect.NONE;
    
    // every attack gets boosted by a set amount of damage if the Element of the
    // spell matches the Element of the wizard casting it
    protected int damageBoost;
    // every attack has an element, and each wizard can use any spell they wish.
    // Before casting a spell, the damage said spell will do is calclated by
    // checking the boosted list.
    // references the attacklist of the element this wizard has boosted
    protected ArrayList<Spell> boosted;
    protected ArrayList<Spell> common;

    public Wizard(int hp, Element element, String name) {
	this.name = name;
	this.maxHP = hp;
	this.curHP = maxHP;
	superMeter = 0;
	this.element = element;
	initSpells();
	switch (element) {
	case FIRE:
	    damageBoost = 25;
	    break;
	case WATER:
	    damageBoost = 15;
	    break;
	case STORM:
	    damageBoost = 20;
	    break;
	case NATURE:
	    damageBoost = 10;
	    break;
	case DEATH:
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
    
    private void initSpells() {
	//tier 1 spells. fast yet weak
 	Attack ember = new Attack(10, 90, 10, Element.FIRE, "Ember");
 	Attack squirt = new Attack(10, 90, 10, Element.WATER, "Squirt");
 	Attack spark = new Attack(10, 90, 10, Element.STORM, "Spark");
 	Attack leafMissile = new Attack(10, 90, 10, Element.NATURE, "Leaf Missile");
 	Attack boneSpike = new Attack(10, 90, 10, Element.DEATH, "Bone spike");
 	common.add(ember);
 	common.add(squirt);
 	common.add(spark);
 	common.add(leafMissile);
 	common.add(boneSpike);
 	//tier 2 spells slightly slower, bit more powerful
 	switch(this.element) {
 	case FIRE:
 	   boosted.add(ember);
 	   boosted.add(new Attack(25, 80, 10, Element.FIRE, "Sear shot"));
 	   
 	   break;
 	
 	case WATER:
 	    //TODO: damage over time  for puddle?
 	    boosted.add(squirt);
 	    boosted.add(new Attack(25, 65, 30, Element.WATER, "Puddle"));
 	    
 	    break;
 	case STORM:
 	    boosted.add(spark);
 	    boosted.add(new Attack(25, 80, 5, Element.STORM, "Bolt shot"));
 	    
 	    break;
 	    
 	case NATURE:
 	    boosted.add(leafMissile);
 	    boosted.add(new Attack(25, 70, 20, Element.NATURE, "Razor Leaves"));
 	    
 	    break;
 	    
 	case DEATH:
 	    boosted.add(boneSpike);
 	    boosted.add(new Attack(25, 80, 10, Element.DEATH, "Bone Tomahawk"));
 	    
 	    break;
 	
 	
 	}
       }
    
    public abstract Spell castSuper();
 
}
