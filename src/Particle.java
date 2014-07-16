import java.awt.Color;

import myutils.Utils;
import myutils.PVector;

public class Particle {
	PVector location;
	PVector velocity;
	PVector acceleration;
	float lifespan;
 
	Particle(PVector l) {
		location = l.get();
		acceleration = new PVector();
		velocity = new PVector();
		lifespan = 255;
	}

	void update() {
		velocity.add(acceleration);
		location.add(velocity);
		lifespan -= 2.0;
	}

	void display() {
		stroke(Color.BLACK, lifespan);
		fill(Color.GRAY, lifespan);
		ellipse(location.x, location.y, 8, 8);
	}

	private void stroke(Color black, float lifespan2) {
		// TODO Auto-generated method stub

	}

	private void fill(Color gray, float lifespan2) {
		// TODO Auto-generated method stub

	}

	private void ellipse(float x, float y, int i, int j) {
		// TODO Auto-generated method stub

	}

	boolean isDead() {
		return (lifespan < 0.0);
	}
}
