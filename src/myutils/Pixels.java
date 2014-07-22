package myutils;

public class Pixels {
	public int[] pixels;
	public int WIDTH, HEIGHT;
	public int WIDTHh, HEIGHTh;
	public float scale, xOffset, yOffset;
	final float DEFAULTZOOMRATE = 1.05f;

	Pixels(int[] p, int width, int height) {
		this.pixels = p;
		WIDTH = width;
		HEIGHT = height;
		WIDTHh = WIDTH / 2;
		HEIGHTh = HEIGHT / 2;
		reset();
	}

	public void add(Vector2D l, int i) {
		int x = (int) Math.round(l.x * scale + xOffset) + WIDTHh;
		int y = (int) Math.round(l.y * scale + yOffset) + HEIGHTh;
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
		// yOffset += 1 / scale;
		yOffset++;
	}

	public void scrollUpDown() {
		// yOffset -= 1 / scale;
		yOffset--;
	}

	public void scrollUpLeft() {
		// xOffset += 1 / scale;
		xOffset++;
	}

	public void scrollUpRight() {
		// xOffset -= 1 / scale;
		xOffset--;
	}

	public void zoomIn() {
		scale *= DEFAULTZOOMRATE;
	}

	public void zoomOut() {
		scale /= DEFAULTZOOMRATE;
	}

	public void reset() {
		xOffset = 0;
		yOffset = 0;
		scale = 1;
	}
}
