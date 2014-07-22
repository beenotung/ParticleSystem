package testing;

import core.ParticleFrame;

public class Main {

	public static void main(String[] args) {
		int width = 800;
		int height = 600;
		//width=1024;
		//height=768;
		double TPS = 50D;
		double FPS = 45D;
		int nParticle = 512;
		ParticleFrame particleFrame = new ParticleFrame(width, height, 1, "Particle Frame Title V2.6\t-Beeno_Tung",
				1e9D / TPS, 1e9D / FPS, nParticle);
		particleFrame.start();
	}

}
