package wizard_wars;

public abstract class Projectile {
	private int damage;
	private int speed;
	private int areaOfEffect;	
	public Element element;
	
	public Projectile(int damage, int speed, int aoe) {
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

	public void setSpeed(int speed){
	    this.speed = speed;
	}
	public int getSpeed(){
		return speed;
	}
}

