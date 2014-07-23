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
		particleSystems.add(new ParticleSystem(WIDTH, HEIGHT, screen, mouseLocation));
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
				v.setRandom();
				 v.setMagnitude(Utils.random.nextDouble()*10);
				ps.particles.add(new Particle(l, v, a));
			}
			ps.calc();
		}
		for (ParticleSystem ps : particleSystems) {
			ps.move();
		}
		for (ParticleSystem ps : particleSystems) {
			// ps.check_loop();
			ps.check_rebound();
		}
	}

	@Override
	protected void myRender() {
		screen.clear(Colors.get(0,0,0));
		for (ParticleSystem ps : particleSystems) {
			ps.display();
		}
	}

	@Override
	protected void myDebugInfo() {
		// TODO Auto-generated method stub
		// System.out.println(particleSystems.get(0).particles.size());
	}

}
