package wizards.main;

import java.awt.Graphics;

public class StatBooster extends UtilitySpell{
    //if true, attack gets boosted, otherwise defense
    boolean attack;
    //note: the factor by which the stats gets boosted is determined by the type of wizard
    public StatBooster(Game game, boolean atkUP, Element element, String name, int cost) {
	super(game,element, false, name, cost);
	attack = atkUP;
    }

    @Override
    public void cast(Wizard player) {
	if(attack) {
	    player.status = StatusEffect.ATTACK_UP;
	    player.damageBoost += player.atkUp;
	    if(player.element == Element.DEATH) {
		player.curHP -= 15;
	    }
	} else {
	    //boosting defense really just adds buffer HP, which can exceed above maximum
	    player.status = StatusEffect.DEFENSE_UP;
	    player.curHP += player.defUp;
	}
	
    }

    @Override
    public void render(Graphics g) {
	// TODO Auto-generated method stub
	
    }

}
