import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame{
	
	public GameManager() {
		
		
		
	}

	@Override
	public void update(GameMain gm, float dt) {
		
	}

	@Override
	public void render(GameMain gm, Render r) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) {
		
		GameMain gm = new GameMain(new GameManager());
		gm.start();
		
	}

}
