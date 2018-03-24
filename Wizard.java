package wizard_wars;

import java.util.ArrayList;

public abstract class Wizard {
    public String name;
    public int maxHP;
    public int curHP;
    public int maxMana;
    public int curMana;
    public Element element;
    public StatusEffect status = StatusEffect.NONE;
    public Wizard[] opponents;
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
	maxMana = 150;
	curMana = 150;
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

    public Attack castSpell(Spell spell) {
	if (boosted.contains(spell) && spell.isHarmful) {
	    Attack attack = (Attack) spell;
	    attack.setDamage(attack.getDamage() + 10);
	    return attack;
	} else {
	    UtilitySpell util = (UtilitySpell) spell;
	    util.effect(this, opponents[0]); //give player the choice, set opponents accordingly
	    return new Attack(0,0,0,this.element, "", 5);
	}
    }

    private void initSpells() {
	// tier 1 spells. fast yet weak
	Attack ember = new Attack(10, 90, 10, Element.FIRE, "Ember", 10);
	Attack squirt = new Attack(10, 90, 10, Element.WATER, "Squirt", 10);
	Attack spark = new Attack(10, 90, 10, Element.STORM, "Spark", 10);
	Attack leafMissile = new Attack(10, 90, 10, Element.NATURE, "Leaf Missile", 10);
	Attack boneSpike = new Attack(10, 90, 10, Element.DEATH, "Bone spike", 10);
	common.add(ember);
	common.add(squirt);
	common.add(spark);
	common.add(leafMissile);
	common.add(boneSpike);
	switch (this.element) {
	case FIRE:
	    boosted.add(ember);
	    boosted.add(new Attack(25, 80, 10, Element.FIRE, "Sear shot", 25));
	    boosted.add(new Attack(50, 50, 20, Element.FIRE, "Magma lob", 50));
	    boosted.add(new Attack(75, 25, 40, Element.FIRE, "ERUPTION", 150));
	    break;

	case WATER:
	    // TODO: damage over time for puddle?
	    boosted.add(squirt);
	    boosted.add(new Attack(25, 65, 30, Element.WATER, "Puddle", 25));
	    boosted.add(new Attack(50, 90, 15, Element.WATER, "Torpedo", 60));
	    boosted.add(new Attack(75, 40, 15, Element.WATER, "POSEIDON'S WRATH", 150));
	    break;
	case STORM:
	    boosted.add(spark);
	    boosted.add(new Attack(25, 80, 5, Element.STORM, "Bolt shot", 25));
	    boosted.add(new Attack(50, 50, 15, Element.STORM, "Ice gust", 55));
	    boosted.add(new Attack(80, 30, 50, Element.STORM, "STORM CLOUD", 150));
	    break;

	case NATURE:
	    boosted.add(leafMissile);
	    boosted.add(new Attack(25, 70, 20, Element.NATURE, "Razor Leaves", 25));
	    // giant root comes up in an arc
	    boosted.add(new Attack(65, 50, 25, Element.NATURE, "Unstable overgrowth", 55));
	    boosted.add(new Attack(70, 40, 30, Element.NATURE, "NATURE'S WRATH", 150));
	    break;

	case DEATH:
	    boosted.add(boneSpike);
	    boosted.add(new Attack(25, 80, 10, Element.DEATH, "Bone Tomahawk", 25));
	    boosted.add(new Attack(50, 60, 30, Element.DEATH, "Corpse Meteor", 55));
	    // zombies/skeletons rush out from the death wizard, dealing massive damage to
	    // everything in the way
	    boosted.add(new Attack(75, 75, 50, Element.DEATH, "ADVANCE OF THE UNDEAD", 150));
	    break;

	}
    }

}
