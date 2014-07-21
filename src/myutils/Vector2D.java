package myutils;

public class Vector2D {
	public double x;
	public double y;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D() {
		x = 0;
		y = 0;
	}

	public void setRandom() {
		double d = Utils.random.nextDouble() * 2 * Math.PI;
		x = Math.cos(d);
		y = Math.sin(d);
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
		double r = 1 / getMagnitude() * d;
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
