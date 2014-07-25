package core;

import java.util.ArrayList;

import myutils.CanvasShell;
import myutils.Colors;
import myutils.KeyHandler;
import myutils.MouseHandler;

public class ParticleFrame extends CanvasShell {
	private static final long serialVersionUID = 1L;

	protected final float DEFAULTSPEEDTONERATE = 1.05f;

	int nParticle;
	int DEFAULTNPARTICLEBEAM = 50;

	protected ArrayList<ParticleSystem> particleSystems = new ArrayList<ParticleSystem>();

	public ParticleFrame(int width, int height, int scale, String title, double nsPerTick, double nsPerRender,
			int nParticle) {
		super(width, height, scale, title, nsPerTick, nsPerRender);
		this.nParticle = nParticle;
	}

	@Override
	protected void init() {
		particleSystems.add(new ParticleSystem(this));
	}

	@Override
	protected void myTick() {
		for (ParticleSystem ps : particleSystems) {
			// ps.checkAlive();
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
		if (keyHandler.add.pressed) {
			particleSystems.get(0).addParticleRandom(DEFAULTNPARTICLEBEAM);
			keyHandler.add.pressed = false;
		}
		if (keyHandler.subtract.pressed) {
			particleSystems.get(0).removeParticleRandom(DEFAULTNPARTICLEBEAM);
			keyHandler.subtract.pressed = false;
		}
		if (keyHandler.q.pressed) {
			nsPerTick*= DEFAULTSPEEDTONERATE;
			deltaTick=0;
			//nsPerRender /= DEFAULTSPEEDTONERATE;
			keyHandler.q.pressed = false;
		}
		if (keyHandler.e.pressed) {
			nsPerTick/= DEFAULTSPEEDTONERATE;
			deltaTick=0;
			//nsPerRender *= DEFAULTSPEEDTONERATE;
			keyHandler.e.pressed = false;
		}
	}

	@Override
	protected void myMouseHandling() {
		if (mouseHandler.left.clicked) {
			particleSystems.get(0).particles.add(new Particle(mouseHandler.left.locationRelative));
			mouseHandler.left.clicked = false;
		}
	}

	private void reset() {	
		keyHandler = new KeyHandler(this);
		mouseHandler = new MouseHandler(this);		
		particleSystems.set(0, new ParticleSystem(this));		
	}

}
