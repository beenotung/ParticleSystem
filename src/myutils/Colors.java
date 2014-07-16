package myutils;

public class Colors {

	public static int get(double d) {
		return (int) Math.round(d * 255);
	}

	/*public static int get(int r, int g, int b) {
		return (r & 0x0ff) << 16 | (g & 0x0ff) << 8 | (b & 0x0ff);
	}*/
 
	public static int get(double r, double g, double b) {
		return get(get(r), get(g), get(b));
	}

}
