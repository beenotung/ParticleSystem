import myutils.Colors;
import myutils.SimpleCanvas;
import myutils.PVector;

public class ParticleFrame extends SimpleCanvas {
	private static final long serialVersionUID = 1L;

	ParticleSystem ps;

	protected ParticleFrame(int width, int height, int scale, String name, double nsPerTick, double nsPerRender) {
		super(width, height, scale, name, nsPerTick, nsPerRender);
		// TODO Auto-generated constructor stub
		ps = new ParticleSystem();
	}

	@Override
	protected void displayDebugInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void mytick() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void myrender() {
		// TODO Auto-generated method stub
		for (int y = 0; y < HEIGHT; y++)
			for (int x = 0; x < WIDTH; x++)
				pixels[x + y * WIDTH] = Colors.get(1.0*x / WIDTH, 1.0*y / HEIGHT, 1.0);
				//pixels[x + y * WIDTH] =Colors.get(1.0, 1.0, 1.0);
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		PVector l = new PVector(WIDTH / 2, HEIGHT / 3);
		Particle p = new Particle(l);
		ps.particles.add(p);
	}

}
