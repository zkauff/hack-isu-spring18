package wizard_wars;

public abstract class Spell {
    public boolean isHarmful;
    public Element element;

    public Spell(Element element, boolean isHarmful) {
	this.element = element;
	this.isHarmful = isHarmful;
    }
    
    public void setHarm(boolean harmful) {
	this.isHarmful = harmful;
    }
}

