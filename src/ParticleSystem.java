import java.util.ArrayList;

public class ParticleSystem implements Runnable {

	private boolean running = false;
	protected ArrayList<Particle> particles = new ArrayList<Particle>();



	@Override
	public void run() {
		while (running) {
			System.out.println("Running");
		}
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public void stop() {
		running = false;
	}
}
