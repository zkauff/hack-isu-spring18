package wizards.main;

public abstract class Spell extends GameObject{
    public boolean isHarmful;
    public Element element;
    public int manaCost;
    
    public Spell(Game game, Element element, boolean isHarmful, String name, int manaCost) {
	super(game, 0,0,element,ID.PROJECTILE);
	this.element = element;
	this.isHarmful = isHarmful;
    }
    
    public void setHarm(boolean harmful) {
	this.isHarmful = harmful;
    }
}

