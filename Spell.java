
public abstract class Spell {
    public boolean isHarmful;
    public Element element;
    public int manaCost;
    
    public Spell(Element element, boolean isHarmful, String name, int manaCost) {
	this.element = element;
	this.isHarmful = isHarmful;
    }
    
    public void setHarm(boolean harmful) {
	this.isHarmful = harmful;
    }
}

