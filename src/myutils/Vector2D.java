package myutils;

public class Vector2D {
	public float x;
	public float y;

	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D() {
		x = 0;
		y = 0;
	}

	public void setRandom() {
		double d = Utils.random.nextDouble() * 2 * Math.PI;
		x = (float) Math.cos(d);
		y = (float) Math.sin(d);
	}

	public Vector2D clone() {
		return new Vector2D(x, y);
	}

	public double getMagnitude() {
		return (Math.sqrt(x * x + y * y));
	}

	public void setMagnitude(double d) {
		if (getMagnitude() == 0) {
			setRandom();
			return;
		}
		float r = (float) (1 / getMagnitude() * d);
		x *= r;
		y *= r;
	}

	public void normalize() {
		setMagnitude(1);
	}

	public void add(Vector2D pv) {
		x += pv.x;
		y += pv.y;
	}
}