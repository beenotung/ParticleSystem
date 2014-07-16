package myutils;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
 
public abstract class SimpleCanvas extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private boolean running;
	private Thread t;

	protected final int WIDTH;
	protected final int HEIGHT;
	protected final int SCALE;
	private final String NAME;

	private JFrame frame;

	private BufferedImage image;
	protected int[] pixels;

	protected int tickCount = 0;
	protected int ticks = 0;
	protected int renders = 0;
	double nsPerTick;
	double nsPerRender;

	protected SimpleCanvas(int width, int height, int scale, String name, double nsPerTick, double nsPerRender) {
		WIDTH = width / scale;
		HEIGHT = height / scale;
		SCALE = scale;
		NAME = name;
		this.nsPerTick = nsPerTick;
		this.nsPerRender = nsPerRender;

		setMaximumSize(new Dimension(WIDTH * SCALE * 2, HEIGHT * SCALE * 2));
		setMinimumSize(new Dimension(WIDTH * SCALE / 2, HEIGHT * SCALE / 2));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		long currentTime;
		double deltaTick = 0;
		double deltaRender = 0;
		long lastDebug = System.currentTimeMillis();
		boolean shouldRender = false;
		while (running) {
			currentTime = System.nanoTime();
			deltaTick += (currentTime - lastTime) / nsPerTick;
			deltaRender += (currentTime - lastTime) / nsPerRender;
			lastTime = currentTime;
			if (deltaTick > 0) {
				System.out.println("deltatick: "+deltaTick);
				System.out.println("ticks "+ticks+" start");				
				ticks++;
				tick();
				deltaTick--;
				shouldRender = true;
				System.out.println("ticks "+ticks+" end");
			}
			if ((deltaRender > 0) && (shouldRender)) {
				System.out.println("deltaRender: "+deltaRender);
				System.out.println("renders "+renders+" start");
				System.out.println("renders++;");
				renders++;
				System.out.println("render();");
				render();
				System.out.println("deltaRender--;");
				deltaRender--;
				System.out.println("shouldRender = false;");
				shouldRender = false;
				System.out.println("renders "+renders+" end");
			}

			if (System.currentTimeMillis() - lastDebug >= 1000) {
				lastDebug += 1000;
				System.out.println(ticks + " TPS, " + renders + " FPS");
				ticks = 0;
				renders = 0;
				displayDebugInfo();
			}
		}
	}

	protected abstract void displayDebugInfo();

	private void tick() {
		tickCount++;
		mytick();
	}

	protected abstract void mytick();

	private void render() {
		System.out.println("1");
		BufferStrategy bufferStrategy = getBufferStrategy();
		if (bufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		
		System.out.println("2");
		clear(pixels);
		System.out.println("3");
		myrender();

		System.out.println("4");
		Graphics graphics = bufferStrategy.getDrawGraphics();
		graphics.drawImage(image, 0, 0, frame.getWidth(), frame.getHeight(), null);
		// graphics.drawImage(image,0,0,WIDTH,HEIGHT,0,0,WIDTH,HEIGHT,frame);
		
		System.out.println("5");
		graphics.dispose();
		bufferStrategy.show();
	}

	protected abstract void myrender();

	private void clear(int[] pixels) {
		int color = Colors.get(0, 0, 0);
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = color;
	}

	protected abstract void init();

	public synchronized void start() {
		if (t == null)
			t = new Thread(this);
		t.start();
		running = true;
	}

	public void stop() {
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

}
