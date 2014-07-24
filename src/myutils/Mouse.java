package myutils;

public class Mouse {
	public int x, y;
	public boolean clicked = false;
	public int numTimesClicked = 0;

	public void toggle(int xPos,int yPos,boolean isClicked) {
		x=xPos;
		y=yPos;
		if (clicked = isClicked)
			numTimesClicked++;
	}
	public void reset(){
		this.numTimesClicked=0;
	}
}
