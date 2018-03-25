package wizards.main;

import java.awt.Graphics;

public class ShieldSpell extends UtilitySpell {
    public ShieldSpell(Game game, Element element, String name, int cost) {
	super(game, element, false, name, cost);
    }

    @Override
    public void cast(Wizard player) {
	player.status = StatusEffect.DEFENSE_UP;
    }

    @Override
    public void tick() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void render(Graphics g) {
	// TODO Auto-generated method stub
	
    }

}
