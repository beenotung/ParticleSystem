package core;

import java.util.ArrayList;

import myutils.Colors;
import myutils.Vector2D;

public class ParticleSystem {
	protected int WIDTH, HEIGHT;
	protected int[] pixels;

	protected ArrayList<Particle> particles = new ArrayList<Particle>();

	public ParticleSystem(int width, int height, int[] pixels) {
		WIDTH = width;
		HEIGHT = height;
		this.pixels = pixels;
		init();
	}

	void init() {
		Vector2D l=new Vector2D(WIDTH/2, HEIGHT/2);
		Vector2D v=new Vector2D(0.5, -0.5);
		Vector2D a=new Vector2D(0,0);
		particles.add(new Particle(l, v, a));
	}

	protected void calc() {
		for (Particle p : particles) {
			
		}
	}

	protected void move() {
		for (Particle p : particles) {
			p.move();
		}
	}
	protected void check_loop() {
		for (Particle p : particles) {			
			while (p.location.x<0)p.location.x+=WIDTH;
			while (p.location.x>=WIDTH)p.location.x-=WIDTH;
			while (p.location.y<0)p.location.y+=HEIGHT;			
			while (p.location.y>=HEIGHT)p.location.y-=HEIGHT;
		}
	}
	protected void check_rebound() {
		for (Particle p : particles) {
			if(p.location.x<0)p.location.x*=-1;
			if(p.location.x>=(WIDTH-1))p.location.x-=p.location.x-(WIDTH-1);
			if(p.location.y<0)p.location.y*=-1;
			if(p.location.y>=(HEIGHT-1))p.location.y-=p.location.y-(HEIGHT-1);
		}
	}

	protected void display() {
		int x, y;
		for (Particle p : particles) {
			x = (int) Math.round(Math.floor(p.location.x));
			y = (int) Math.round(Math.floor(p.location.y));
			/*while (x<0)x+=WIDTH;
			while (y<0)y+=HEIGHT;
			while (x>=WIDTH)x-=WIDTH;
			while (y>=HEIGHT)y-=HEIGHT;*/		
			pixels[x + y * WIDTH] = Colors.get(1, 0, 0);
		}
	}

}
