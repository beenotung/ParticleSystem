package core;

import java.util.ArrayList;

import myutils.Colors;
import myutils.Pixels;

public class ParticleSystem {
	protected int WIDTH,HEIGHT;
	protected int xMin, yMin, xMax, yMax;
	protected int xMin2,yMin2 ,xMax2, yMax2;
	Pixels screen;

	protected double REBOUNDRATIO = 0.90;

	protected ArrayList<Particle> particles = new ArrayList<Particle>();

	public ParticleSystem(int width, int height, Pixels screen) {
		WIDTH = width;
		HEIGHT = height;
		xMin = -width / 2;
		yMin = -height / 2;
		xMax = width / 2;
		yMax = height / 2;
		if (width % 2 == 0)
			xMax--;
		if (height % 2 == 0)
			yMax--;
		this.screen = screen;
		xMin2=xMin*2;
		yMin2=yMin*2;
		xMax2=xMax*2;
		yMax2=yMax*2;
		init();
	}

	protected void init() {
		// addParticle();
	}

	protected void checkAlive() {
		for (int i = particles.size() - 1; i >= 0; i--)
			if (particles.get(i).isDead())
				particles.remove(i);
	}

	protected void calc() {
		for (Particle p : particles) {
			// p.acceleration.setRandom();
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
				p.location.x += WIDTH;
			
			while (p.location.x >= xMax)
				p.location.x -= WIDTH;
			while (p.location.y < yMin)
				p.location.y += HEIGHT;
			while (p.location.y >= yMax)
				p.location.y -= HEIGHT;
		}
	}

	protected void check_rebound() {
		for (Particle p : particles) {
			if (p.location.x < xMin) {
				p.location.x =xMin2-p.location.x;
				p.velocity.x *= -REBOUNDRATIO;
			}
			if (p.location.y < yMin) {
				p.location.y =yMin2-p.location.y;
				p.velocity.y *= -REBOUNDRATIO;
			}
			if (p.location.x >= (xMax - 1)) {
				p.location.x =xMax2-p.location.x;
				p.velocity.x *= -REBOUNDRATIO;
			}			
			if (p.location.y >= (yMax - 1)) {
				p.location.y =yMax2-p.location.y;
				p.velocity.y *= -REBOUNDRATIO;
			}
		}
	}

	protected void display() {
		int x, y;
		for (Particle p : particles) {
			screen.add(p.location, Colors.get(1, 0, 0));
		}
	}
}
