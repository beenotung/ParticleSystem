package myutils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {

	CanvasShell canvasShell;

	public Mouse left = new Mouse();
	public Mouse middle = new Mouse();
	public Mouse right = new Mouse();

	public int amountScrolled = 0;

	public MouseHandler(CanvasShell canvasShell) {
		this.canvasShell = canvasShell;
		canvasShell.addMouseListener(this);
		canvasShell.addMouseMotionListener(this);
		canvasShell.addMouseWheelListener(this);
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
		convertOnScreen(canvasShell.mouseLocationOnScreen, e.getX(), e.getY());
		convertRelative(canvasShell.mouseLocationRelative, e.getX(), e.getY());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll(e.getUnitsToScroll());
	}

	private void toggle(int button, int x, int y, boolean isClicked) {
		switch (button) {
		case 1:
			left.toggle(x, y, isClicked);
			break;
		case 2:
			middle.toggle(x, y, isClicked);
			break;
		case 3:
			right.toggle(x, y, isClicked);
			break;
		default:

		}
	}

	private void scroll(int unitsToScroll) {
		amountScrolled -= unitsToScroll;
	}

	public void convertOnScreen(Vector2D v, int x, int y) {
		v.x = x / canvasShell.SCALE - canvasShell.screen.xOffset;
		v.y = y / canvasShell.SCALE - canvasShell.screen.yOffset;
	}

	public void convertRelative(Vector2D v, int x, int y) {
		v.x = x / canvasShell.SCALE - canvasShell.cx - canvasShell.screen.xOffset;
		v.y = y / canvasShell.SCALE - canvasShell.cy - canvasShell.screen.yOffset;
	}
}
