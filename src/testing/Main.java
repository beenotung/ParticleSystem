package testing;

import core.ParticleFrame;

public class Main {

	public static void main(String[] args) {
		double TPS = 100D;
		double FPS = 60D;
		ParticleFrame particleFrame = new ParticleFrame(800, 600, 3, "Particle Frame Title\tV2.0\t\t-Beeno_Tung", 1e9D / TPS, 1e9D / FPS);
		particleFrame.start();
	}

}
