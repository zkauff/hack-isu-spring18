package wizards.main;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public abstract class Wizard extends GameObject {
    public String name;
    public int maxHP;
    public int curHP;
    public int maxMana;
    public int curMana;
    public Element element;
    public StatusEffect status = StatusEffect.NONE;
    // the amount of extra HP the wizard gains from a shield/defense boost
    protected int defUp;
    // the amount of extra attack damage the wizard gains from an attack boost (on
    // top of damageBoost)
    protected int atkUp;

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

    public Wizard(Game game, int hp, Element element, String name, int x, int y, ID id) {
	super(game, x, y, element, id);
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

    public abstract void passiveAbility();

    public void castSpell(Spell spell, double angle) {

	if (boosted.contains(spell) && spell.isHarmful) {
	    Attack attack = (Attack) spell;
	    attack.setDamage(attack.getDamage() + 10);
	    attack.render(game.getGraphics());
	} else {
	    UtilitySpell util = (UtilitySpell) spell;
	    util.cast(this); // give player the choice, set opponents accordingly
	}
    }

    private void initSpells() {
	common = new ArrayList<Spell>();
	boosted = new ArrayList<Spell>();
	// tier 1 spells. fast yet weak
	Attack ember = new Attack(this.game, 10, 90, 10, Element.FIRE, "Ember", 10);
	Attack squirt = new Attack(this.game, 10, 90, 10, Element.WATER, "Squirt", 10);
	Attack spark = new Attack(this.game, 10, 90, 10, Element.STORM, "Spark", 10);
	Attack leafMissile = new Attack(this.game, 10, 90, 10, Element.NATURE, "Leaf Missile", 10);
	Attack boneSpike = new Attack(this.game, 10, 90, 10, Element.DEATH, "Bone spike", 10);
	HealSpell mendWounds = new HealSpell(this.game, 20, Element.NATURE, "Mend Wounds", 5);
	ShieldSpell deflect = new ShieldSpell(this.game, Element.WATER, "Deflect", 5);
	common.add(ember);
	common.add(squirt);
	common.add(spark);
	common.add(leafMissile);
	common.add(boneSpike);
	common.add(mendWounds);
	common.add(deflect);
	switch (this.element) {
	case FIRE:
	    boosted.add(ember);
	    boosted.add(new Attack(this.game, 25, 80, 10, Element.FIRE, "Sear shot", 25));
	    boosted.add(new Attack(this.game, 50, 50, 20, Element.FIRE, "Magma lob", 50));
	    boosted.add(new Attack(this.game, 75, 25, 40, Element.FIRE, "ERUPTION", 150));
	    boosted.add(new StatBooster(this.game, true, Element.FIRE, "Stoke the flames", 50));
	    break;

	case WATER:
	    // TODO: damage over time for puddle?
	    boosted.add(squirt);
	    boosted.add(new Attack(this.game, 25, 65, 30, Element.WATER, "Puddle", 25));
	    boosted.add(new Attack(this.game, 50, 90, 15, Element.WATER, "Torpedo", 60));
	    boosted.add(new Attack(this.game, 75, 40, 15, Element.WATER, "POSEIDON'S WRATH", 150));
	    boosted.add(new StatBooster(this.game, false, Element.WATER, "Water shield", 0));
	    break;
	case STORM:
	    boosted.add(spark);
	    boosted.add(new Attack(this.game, 25, 80, 5, Element.STORM, "Bolt shot", 25));
	    boosted.add(new Attack(this.game, 50, 50, 15, Element.STORM, "Ice gust", 55));
	    boosted.add(new Attack(this.game, 80, 30, 50, Element.STORM, "STORM CLOUD", 150));
	    boosted.add(new StatBooster(this.game, false, Element.STORM, "Storm Shield", 50));
	    break;

	case NATURE:
	    boosted.add(leafMissile);
	    boosted.add(new Attack(this.game, 25, 70, 20, Element.NATURE, "Razor Leaves", 25));
	    // giant root comes up in an arc
	    boosted.add(new Attack(this.game, 65, 50, 25, Element.NATURE, "Unstable overgrowth", 55));
	    boosted.add(new Attack(this.game, 70, 40, 30, Element.NATURE, "NATURE'S WRATH", 150));
	    boosted.add(new HealSpell(this.game, 25, Element.NATURE, "Nature's Blessing", 50));
	    boosted.add(new StatBooster(this.game, false, Element.NATURE, "Strong as an oak", 50));
	    break;

	case DEATH:
	    boosted.add(boneSpike);
	    boosted.add(new Attack(this.game, 25, 80, 10, Element.DEATH, "Bone Tomahawk", 25));
	    boosted.add(new Attack(this.game, 50, 60, 30, Element.DEATH, "Corpse Meteor", 55));
	    // zombies/skeletons rush out from the death wizard, dealing massive damage to
	    // everything in the way
	    boosted.add(new Attack(this.game, 75, 75, 50, Element.DEATH, "ADVANCE OF THE UNDEAD", 150));
	    boosted.add(new StatBooster(this.game, true, Element.DEATH, "Unholy Pact", 0));
	    break;

	}
    }

    @Override
    public void render(Graphics g) {
	if (this.id == ID.PLAYER_ONE) {
	    g.setColor(Color.WHITE);
	    int fontSize = 20;
	    g.setFont(new Font("Helvetica", Font.PLAIN, fontSize));
	    g.drawString(this.name, 05, 20);
	    g.setColor(Color.RED);
	    g.fillRect(0, 25, 200, 20);
	    g.setColor(Color.GREEN);
	    g.fillRect(0, 25, (curHP / maxHP) * 200, 20);
	    g.setColor(Color.BLUE);
	    g.fillRect(0, 45, 200 * (curMana / maxMana), 20);

	} else if (this.id == ID.PLAYER_TWO) {
	    g.setColor(Color.WHITE);
	    int fontSize = 20;
	    g.setFont(new Font("Helvetica", Font.PLAIN, fontSize));
	    g.drawString(this.name, 1080, 20);
	    g.setColor(Color.RED);
	    g.fillRect(1080, 25, 200, 20);
	    g.setColor(Color.GREEN);
	    g.fillRect(1080, 25, 200 * (curHP / maxHP), 20);
	    g.setColor(Color.BLUE);
	    g.fillRect(1080, 45, 200 * (curMana / maxMana), 20);
	}
	g.setColor(this.color);
	g.fillRect((int)this.values.posX, (int)this.values.posY, 50, 50);
    }

}
