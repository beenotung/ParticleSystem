package core;

import myutils.Vector2D;

public class Particle {
	Vector2D location;
	Vector2D velocity;
	Vector2D acceleration;
	float lifespan;

	Particle(Vector2D l) {
		location = l.clone();
		velocity = new Vector2D();
		acceleration = new Vector2D();
		lifespan = 255;
	}

	Particle(Vector2D l, Vector2D v) {
		location = l.clone();
		velocity = v.clone();
		acceleration = new Vector2D();
		lifespan = 255;
	}

	Particle(Vector2D l, Vector2D v, Vector2D a) {
		location = l.clone();
		velocity = v.clone();
		acceleration = a.clone();
		lifespan = 255;
	}

	void move() {
		velocity.add(acceleration);
		location.add(velocity);
		lifespan -= 2.0;
	}

	boolean isDead() {
		return (lifespan < 0.0);
	}
}
