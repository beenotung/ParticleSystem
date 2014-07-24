package myutils;

public class Pixels {
	public int[] pixels;
	public int WIDTH, HEIGHT;
	public int cx, cy;
	public float scale, xOffset, yOffset;
	final float DEFAULTZOOMRATE = 1.05f;

	Pixels(int[] p, int width, int height) {
		this.pixels = p;
		WIDTH = width;
		HEIGHT = height;
		cx = WIDTH / 2;
		cy = HEIGHT / 2;
		reset();
	}

	public void add(Vector2D l, int i) {
		int x = (int) Math.round((l.x +- xOffset) * scale) + cx;
		int y = (int) Math.round((l.y - yOffset) * scale) + cy;
		if (inside(x, y, 0, 0, WIDTH - 1, HEIGHT - 1))
			pixels[x + y * WIDTH] = i;
	}

	public void clear(int c) {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = c;
	}

	public static boolean inside(int x, int y, int xMin, int yMin, int xMax, int yMax) {
		return (x >= xMin) && (x <= xMax) && (y >= yMin) && (y <= yMax);
	}

	public void scrollUp() {
		yOffset -= 1 / scale;
	}

	public void scrollDown() {
		yOffset += 1 / scale;
	}

	public void scrollLeft() {
		xOffset -= 1 / scale;
	}

	public void scrollRight() {
		xOffset += 1 / scale;
	}

	public void zoom(int r) {
		scale *= Math.pow(DEFAULTZOOMRATE, r);
	}

	public void reset() {
		xOffset = 0;
		yOffset = 0;
		scale = 1;
	}

	public void setOffset(int x, int y) {
		xOffset -= x/scale/Math.PI;
		yOffset -= y/scale/Math.PI;		
	}
}
