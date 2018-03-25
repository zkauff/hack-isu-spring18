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
	    Projectile attack = (Projectile) spell;
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

	Projectile ember = new Projectile(this.game, this, this.getX(), this.getY(), 90, 15, 10, 10, Element.FIRE,
		"Ember", this.game.getAngle());
	Projectile squirt = new Projectile(this.game, this, this.getX(), this.getY(), 90, 15, 10, 10, Element.WATER,
		"Squirt", this.game.getAngle());
	Projectile spark = new Projectile(this.game, this, this.getX(), this.getY(), 90, 15, 10, 10, Element.STORM,
		"Spark", this.game.getAngle());
	Projectile leafMissile = new Projectile(this.game, this, this.getX(), this.getY(), 90, 15, 10, 10,
		Element.NATURE, "Leaf Missile", this.game.getAngle());
	Projectile boneSpike = new Projectile(this.game, this, this.getX(), this.getY(), 90, 15, 10, 10, Element.DEATH,
		"Bone spike", this.game.getAngle());
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
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 80, 25, 10, 25, Element.FIRE,
		    "Sear shot", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 50, 50, 20, 50, Element.FIRE,
		    "Magma lob", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 25, 75, 40, 150, Element.FIRE,
		    "ERUPTION", this.game.getAngle()));
	    boosted.add(new StatBooster(this.game, true, Element.FIRE, "Stoke the flames", 50));
	    break;

	case WATER:
	    // TODO: damage over time for puddle?
	    boosted.add(squirt);
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 60, 25, 30, 25, Element.WATER,
		    "Puddle", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 90, 50, 15, 60, Element.WATER,
		    "Torpedo", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 40, 75, 40, 150, Element.WATER,
		    "Puddle", this.game.getAngle()));
	    boosted.add(new StatBooster(this.game, false, Element.WATER, "Water shield", 0));
	    break;
	case STORM:
	    boosted.add(spark);
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 80, 25, 30, 25, Element.STORM,
		    "Bolt shot", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 90, 50, 15, 60, Element.STORM,
		    "Ice gust", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 30, 75, 100, 150, Element.STORM,
		    "STORM CLOUD", this.game.getAngle()));
	    boosted.add(new StatBooster(this.game, false, Element.STORM, "Storm Shield", 50));
	    break;

	case NATURE:
	    boosted.add(leafMissile);
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 80, 25, 30, 25, Element.NATURE,
		    "Razor Leaves", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 50, 50, 15, 60, Element.NATURE,
		    "Unstable overgrowth", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 30, 75, 40, 150, Element.NATURE,
		    "NATURE'S WRATH", this.game.getAngle()));
	    boosted.add(new HealSpell(this.game, 25, Element.NATURE, "Nature's Blessing", 50));
	    boosted.add(new StatBooster(this.game, false, Element.NATURE, "Strong as an oak", 50));
	    break;

	case DEATH:
	    boosted.add(boneSpike);
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 80, 25, 30, 25, Element.DEATH,
		    "Bone Tomahawk", this.game.getAngle()));
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 50, 50, 15, 60, Element.DEATH,
		    "Corpse Meteor", this.game.getAngle()));
	    // zombies/skeletons rush out from the death wizard, dealing massive damage to
	    // everything in the way
	    boosted.add(new Projectile(this.game, this, this.getX(), this.getY(), 30, 75, 40, 150, Element.DEATH,
		    "ADVANCE OF THE UNDEAD", this.game.getAngle()));
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
	g.fillRect((int) this.values.posX, (int) this.values.posY, 50, 50);
	if (this.element == Element.DEATH) {
	    g.setColor(Color.WHITE);
	    g.drawRect((int) this.values.posX, (int) this.values.posY, 50, 50);
	}
	if (this.game.player1.curHP < 0) {
	    g.setColor(Color.WHITE);
	    int fontSize = 50;
	    g.setFont(new Font("Helvetica", Font.PLAIN, fontSize));
	    g.drawString(this.game.player1.name + " died.", 640, 200);

	} else if(this.game.player2.curHP < 0) {
	    g.setColor(Color.WHITE);
	    int fontSize = 50;
	    g.setFont(new Font("Helvetica", Font.PLAIN, fontSize));
	    g.drawString(this.game.player2.name + " died.", 640, 200);
	}
    }

}
