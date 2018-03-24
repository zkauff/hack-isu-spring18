package wizard_wars;
import java.util.ArrayList;

public abstract class Wizard {
    
    public int maxHP;
    public int curHP;
    public int superMeter;
    public Element element;
    protected ArrayList<Projectile> fireAttacks;
    protected ArrayList<Projectile> waterAttacks;
    protected ArrayList<Projectile> stormAttacks;
    protected ArrayList<Projectile> earthAttacks;
    //references the attacklist of the element this wizard has boosted
    protected ArrayList<Projectile> boosted;
    
    public Wizard(int hp, Element element) {
	this.maxHP = hp;
	this.curHP = maxHP;
	superMeter = 0;
	this.element = element;
	switch(element) {
	case FIRE:
	    this.boosted = fireAttacks;
	    break;
	case WATER:
	    this.boosted = waterAttacks;
	    break;
	case STORM:
	    this.boosted = stormAttacks;
	    break;
	case EARTH:
	    this.boosted = earthAttacks;
	    break;
	}
	
	
    }
    
    
    
}
