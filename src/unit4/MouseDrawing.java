package unit4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseDrawing implements MouseListener, MouseMotionListener {

	public static void main(String[] args) {
		MouseDrawing md = new MouseDrawing();
		// md.run();
	}

	final static int PANW = 1000;
	final static int PANH = 800;
	JPanel panel;
	Point startPT = new Point(PANW / 2, PANH / 2);
	Point endPT = new Point(0, 0); // mouse location: default to 0,0
	boolean clearScreen = true;
	Color penColour = Color.YELLOW;

	MouseDrawing() {
		JFrame window = new JFrame("Mouse Drawing");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		panel = new DrawingPanel();
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		window.add(panel);
		window.pack(); // since the panel will determine size
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(PANW, PANH));
		}

		@Override
		public void paintComponent(Graphics g) {
			if (endPT.x == 0 || clearScreen) {
				super.paintComponent(g);
				clearScreen = false;
			}
			g.setColor(penColour);
			g.drawLine(startPT.x, startPT.y, endPT.x, endPT.y);
		}
	}

	/****** all mouse listener methods ******/
	@Override
	public void mouseMoved(MouseEvent e) {
		endPT = e.getPoint();
		// mx = e.getX(); //my = e.getY();
		panel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		clearScreen = true;
		panel.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
