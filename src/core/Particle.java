package core;

import myutils.Vector2D;

public class Particle {
	protected Vector2D location;
	protected Vector2D velocity;
	protected Vector2D acceleration;
	protected float lifespan=255;

	Particle(Vector2D l) {
		location = l.clone();
		velocity = new Vector2D();
		acceleration = new Vector2D();		
	}

	Particle(Vector2D l, Vector2D v) {
		location = l.clone();
		velocity = v.clone();
		acceleration = new Vector2D();
	}

	Particle(Vector2D l, Vector2D v, Vector2D a) {
		location = l.clone();
		velocity = v.clone();
		acceleration = a.clone();
	}

	void move() {
		velocity.plus(acceleration);
		location.plus(velocity);
		lifespan -= 2.0;
	}

	boolean isDead() {
		return (lifespan < 0.0);
	}
}
