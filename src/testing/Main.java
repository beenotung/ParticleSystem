package testing;

import core.ParticleFrame;

public class Main {

	public static void main(String[] args) {
		double TPS = 60D;
		double FPS = 60D;
		ParticleFrame particleFrame = new ParticleFrame(800, 600, 3, "Particle Frame Title", 1e9D / TPS, 1e9D / FPS);
		particleFrame.start();
	}

}
