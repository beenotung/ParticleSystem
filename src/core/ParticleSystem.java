package core;

import java.util.ArrayList;

import myutils.Colors;
import myutils.Utils;
import myutils.Vector2D;

public class ParticleSystem {
	ParticleFrame particleFrame;

	protected int xMin, yMin, xMax, yMax;
	protected int xMin2, yMin2, xMax2, yMax2;

	protected float REBOUNDRATIO = 0.90f;
	protected float G = 6.6742e-11f;

	protected ArrayList<Particle> particles = new ArrayList<Particle>();

	public ParticleSystem(ParticleFrame particleFrame) {
		this.particleFrame = particleFrame;

		xMin = -particleFrame.WIDTH / 2;
		yMin = -particleFrame.HEIGHT / 2;
		xMax = particleFrame.WIDTH / 2;
		yMax = particleFrame.HEIGHT / 2;
		if (particleFrame.WIDTH % 2 == 0)
			xMax--;
		if (particleFrame.HEIGHT % 2 == 0)
			yMax--;
		xMin2 = xMin * 2;
		yMin2 = yMin * 2;
		xMax2 = xMax * 2;
		yMax2 = yMax * 2;
		init();
	}

	protected void init() {
		addParticleRandom(particleFrame.nParticle);
	}

	protected void addParticleRandom(int NParticleBeam) {
		Vector2D l = new Vector2D();
		for (int i = 0; i < NParticleBeam; i++) {
			l.setRandom();
			l.setMagnitude(Math.min(particleFrame.cx, particleFrame.cy) * Utils.random.nextFloat());
			particles.add(new Particle(l));
		}
	}

	protected void removeParticleRandom(int NParticleBeam) {
		for (int i = 0; i < Math.min(NParticleBeam, particles.size()); i++)			
			particles.remove(Utils.random.nextInt(particles.size()));
	}

	protected void checkAlive() {
		for (int i = particles.size() - 1; i >= 0; i--)
			if (particles.get(i).isDead())
				particles.remove(i);
	}

	protected void calc() {
		for (Particle p : particles) {
			p.acceleration = Vector2D.subtract(particleFrame.mouseHandler.mouseMoved.locationRelative, p.location);
			p.acceleration.setMagnitude((float) Math.pow(p.acceleration.getMagnitude(), -2));
			if (p.acceleration.getMagnitude() >= 1) {
				p.acceleration.setMagnitude(0);
				p.velocity.multiply(-1);
			}
			// p.acceleration.max(1);
		}
	}

	protected void move() {
		for (Particle p : particles) {
			p.move();
		}
	}

	protected void check_loop() {
		for (Particle p : particles) {
			while (p.location.x < xMin)
				p.location.x += particleFrame.WIDTH;
			while (p.location.x >= xMax)
				p.location.x -= particleFrame.WIDTH;
			while (p.location.y < yMin)
				p.location.y += particleFrame.HEIGHT;
			while (p.location.y >= yMax)
				p.location.y -= particleFrame.HEIGHT;
		}
	}

	protected void check_rebound() {
		for (Particle p : particles) {
			if (p.location.x < xMin) {
				p.location.x = xMin2 - p.location.x;
				p.velocity.x *= -REBOUNDRATIO;
			}
			if (p.location.y < yMin) {
				p.location.y = yMin2 - p.location.y;
				p.velocity.y *= -REBOUNDRATIO;
			}
			if (p.location.x >= (xMax - 1)) {
				p.location.x = xMax2 - p.location.x;
				p.velocity.x *= -REBOUNDRATIO;
			}
			if (p.location.y >= (yMax - 1)) {
				p.location.y = yMax2 - p.location.y;
				p.velocity.y *= -REBOUNDRATIO;
			}
		}
	}

	protected void display() {
		for (Particle p : particles) {
			particleFrame.screen.add(p.location, Colors.get(1f, 244f / 255f, 234f / 255f));
		}
	}
}
