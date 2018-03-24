
import java.awt.image.DataBufferInt;

public class Render {
	
	private int pW, pH;//Pixel Width/Height
	private int[] p; //Pixles
	
	public Render(GameMain gm) {
		pW = gm.getWidth();
		pH = gm.getHeight();
		p = ((DataBufferInt)gm.getWindow().getImage().getRaster().getDataBuffer()).getData();
		
	}
	
	public void clear() {
		
		for(int i=0; i<p.length; i++) {
			p[i] =0;
		}
		
	}
	
}
