package myutils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {

	public Vector2D mouseLocation;

	public Mouse left = new Mouse();
	public Mouse middle = new Mouse();
	public Mouse right = new Mouse();

	public int amountScrolled = 0;

	public MouseHandler(CanvasShell canvasShell, Vector2D mouseLocation) {
		canvasShell.addMouseListener(this);
		canvasShell.addMouseMotionListener(this);
		canvasShell.addMouseWheelListener(this);
		this.mouseLocation = mouseLocation;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		toggle(e.getButton(), e.getX(), e.getY(), true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseLocation.x = e.getX();
		mouseLocation.y = e.getY();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll(e.getUnitsToScroll());
	}

	private void toggle(int button, int x, int y, boolean isClicked) {
		switch (button) {
		case 1:
			left.toggle(x, y, isClicked);
		case 2:
			middle.toggle(x, y, isClicked);
		case 3:
			right.toggle(x, y, isClicked);
			break;
		default:

		}
	}

	private void scroll(int unitsToScroll) {
		amountScrolled -= unitsToScroll;
	}

}