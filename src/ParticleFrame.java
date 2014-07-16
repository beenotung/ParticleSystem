import myutils.Colors;
import myutils.SimpleCanvas;
import myutils.PVector;

public class ParticleFrame extends SimpleCanvas {
	private static final long serialVersionUID = 1L;

	ParticleSystem ps;

	protected ParticleFrame(int width, int height, int scale, String name,
			double nsPerTick, double nsPerRender) {
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
		/*int x, y;
		System.out.println("myrender");
		for (Particle p : ps.particles) {
			x = Math.round(p.location.x);
			y = Math.round(p.location.y);
			System.out.println(x + ", " + y);
			pixels[x + y * WIDTH] = Colors.get(1, 1, 1);
		}*/
	}

	@Override
	protected void init() {
		System.out.println("init");
		// TODO Auto-generated method stub
		PVector l = new PVector(WIDTH / 2, HEIGHT / 3);
		Particle p = new Particle(l);
		ps.particles.add(p);
	}

}
