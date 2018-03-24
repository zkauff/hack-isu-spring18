package wizard_wars;

public class ShieldSpell extends UtilitySpell {
    public ShieldSpell(Element element, String name, int cost) {
	super(element, false, name, cost);
    }

    @Override
    public void cast(Wizard player) {
	player.status = StatusEffect.DEFENSE_UP;
    }

}
