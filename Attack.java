package wizard_wars;

public class Attack extends Spell {
    private int damage;
    private int speed;
    private int areaOfEffect;

    public Attack(int damage, int speed, int aoe, Element element, String name, int cost) {
	super(element, true, name, cost);
	this.damage = damage;
	this.speed = speed;
	this.areaOfEffect = aoe;
    }

    public void setDamage(int damage) {
	this.damage = damage;
    }

    public int getDamage() {
	return damage;
    }

    public void setSpeed(int speed) {
	this.speed = speed;
    }

    public int getSpeed() {
	return speed;
    }

    public int getAOE() {
	return areaOfEffect;
    }

}
