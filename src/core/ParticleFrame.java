package core;

import java.util.ArrayList;

import myutils.CanvasShell;
import myutils.Colors;
import myutils.Utils;
import myutils.Vector2D;

public class ParticleFrame extends CanvasShell {
	private static final long serialVersionUID = 1L;

	private int nParticle;

	protected ArrayList<ParticleSystem> particleSystems = new ArrayList<ParticleSystem>();

	public ParticleFrame(int width, int height, int scale, String title, double nsPerTick, double nsPerRender,
			int nParticle) {
		super(width, height, scale, title, nsPerTick, nsPerRender);
		this.nParticle = nParticle;
	}

	@Override
	protected void init() {
		particleSystems.add(new ParticleSystem(screen, mouseLocationRelative));
	}

	@Override
	protected void myTick() {
		// Vector2D l = new Vector2D(Utils.random.nextInt(WIDTH/2),
		// Utils.random.nextInt(HEIGHT/2));
		Vector2D l = new Vector2D();
		Vector2D v = new Vector2D();
		Vector2D a = new Vector2D();
		for (ParticleSystem ps : particleSystems) {
			ps.checkAlive();
			for (int i = 0; i < nParticle; i++) {
				// v.setRandom();
				// v.setMagnitude(Utils.random.nextDouble());
				l.x = Utils.random.nextInt(WIDTH) - cx;
				l.y = Utils.random.nextInt(HEIGHT) - cy;
				ps.particles.add(new Particle(l, v, a));
			}
			ps.calc();
		}
		for (ParticleSystem ps : particleSystems) {
			ps.move();
		}
		for (ParticleSystem ps : particleSystems) {
			// ps.check_loop();
			// ps.check_rebound();
		}
	}

	@Override
	protected void myRender() {
		screen.clear(Colors.get(53f / 255f, 0, 78f / 255f));
		for (ParticleSystem ps : particleSystems) {
			ps.display();
		}
	}

	@Override
	protected void myDebugInfo() {
		// TODO Auto-generated method stub
		// System.out.println(particleSystems.get(0).particles.size());
	}

	@Override
	protected void myKeyHandling() {
		if (keyHandler.r.pressed) {
			reset();
		}
	}

	@Override
	protected void myMouseHandling() {
		// TODO Auto-generated method stub

	}

	private void reset() {
		particleSystems.set(0, new ParticleSystem(screen, mouseLocationRelative));
	}

}
