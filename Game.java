package wizards.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Handler handler;
    /**
     * 
     */
    private static final long serialVersionUID = -4984271202747625627L;
    public final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public Game() {
	handler = new Handler();
	this.addKeyListener(new KeyInput(handler));
	new Window(WIDTH, HEIGHT, "Wizards Wonds", this);
	handler.addObject(new FireWizard(this, "Player 1", 1030, 700, ID.PLAYER_ONE));
	handler.addObject(new StormWizard(this, "Player 2", 200, 700, ID.PLAYER_TWO));
    }

    @Override
    public void run() {

	long lastTime = System.nanoTime();
	double amountOfTicks = 60.0;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
	long timer = System.currentTimeMillis();
	int frames = 0;
	MotionValues proj = new MotionValues(0, 500, 9, 2);
	int t = 0;
	while (running) {
	    long now = System.nanoTime();
	    delta += (now - lastTime) / ns;
	    lastTime = now;
	    t += delta;
	    while (delta >= 1) {
		tick();
		delta--;
	    }
	    if (running) {
		Physics.update(proj, (double)t / 1000.0);
		render(proj);
	    }
	    frames++;

	    if (System.currentTimeMillis() - timer > 1000) {
		timer += 1000;
		System.out.println("FPS: " + frames);
		frames = 0;
	    }
	}
	stop();

    }

    private void tick() {

    }

    private void render(MotionValues values) {
	BufferStrategy bs = this.getBufferStrategy();
	if (bs == null) {
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics g = bs.getDrawGraphics();

	g.setColor(Color.BLACK);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	handler.render(g);
	g.dispose();
	bs.show();

    }

    public synchronized void start() {
	thread = new Thread(this);
	thread.start();
	running = true;
    }

    public synchronized void stop() {
	try {
	    thread.join();
	    running = false;
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public static void main(String args[]) {

	new Game();

    }

}