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

	public Vector2D clone() {
		return new Vector2D(x, y);
	}

	public void add(Vector2D pv) {
		x += pv.x;
		y += pv.y;
	}
}
