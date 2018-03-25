package wizards.main;

public abstract class Spell extends GameObject{
    public boolean isHarmful;
    public int manaCost;
    
    public Spell(Game game, double x, double y, int cost, Element element) {
	super(game, x, y, element, ID.PROJECTILE);
	this.manaCost = cost;
    }
    
    public void setHarm(boolean harmful) {
	this.isHarmful = harmful;
    }
}

