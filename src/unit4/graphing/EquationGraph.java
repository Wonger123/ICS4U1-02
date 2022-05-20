package unit4.graphing;

import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;

public class EquationGraph {
	// colouring pixels individually

	public static void main(String[] args) {
		new EquationGraph();
	}

	double xmin = -5.0, xmax = +5.0;
	double ymin = -5.0, ymax = +5.0;
	double xstep;

	EquationGraph() {
		JFrame window = new JFrame("Graphing Equations");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		// window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setSize(900, 900);
		window.setLocationRelativeTo(null);
		window.setBackground(Color.BLACK);

		DrawingPanel panel = new DrawingPanel();
		window.add(panel);
		window.setVisible(true);
	}

	private class DrawingPanel extends JPanel {
		int panW, panH;

		// constructor
		DrawingPanel() {
		}

		@Override
		public void paintComponent(Graphics g) {
			panW = this.getWidth();
			panH = this.getHeight();
			xstep = (xmax - xmin) / (double) panW;

			drawAxes(g, Color.WHITE);
			for (double x = xmin; x < xmax; x += xstep) {
				double y;
				// equation comes here
				y = Math.sin(x);
				plotPt(x, y, g, Color.RED);
				
				y = Math.cos(x);
				plotPt(x, y, g, Color.GREEN);
				
				y = Math.tan(x);
				plotPt(x, y, g, Color.BLUE);
			}
		}

		void drawAxes(Graphics g, Color c) {
			g.setColor(c);
			int x = 0, y = 0;
			
			int px = (int) ((panW * (x - xmin)) / (xmax - xmin));
			g.drawLine(px, 0, px, panH);
			
			int py = (int) ((panH * (y - ymin)) / (ymax - ymin));
			g.drawLine(0, py, panW, py);
		}

		void plotPt(double x, double y, Graphics g, Color c) {
			int px = (int) ((panW * (x - xmin)) / (xmax - xmin));
			int py = (int) ((panH * (y - ymin)) / (ymax - ymin));
			py = panH - py; // to invert the y axis

			g.setColor(c);
			g.fillRect(px, py, 1, 1);
		}
	}
}