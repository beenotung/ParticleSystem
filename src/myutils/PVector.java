package myutils;

public class PVector {
	public float x;
	public float y;
 
	public PVector(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public PVector() {
		x = 0;
		y = 0;
	}

	public PVector get() {
		return new PVector(x, y);
	}

	public void add(PVector pv) {
		x += pv.x;
		y += pv.y;
	}
}
