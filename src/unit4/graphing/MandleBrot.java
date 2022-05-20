package unit4.graphing;

import java.awt.*;
import javax.swing.*;

public class MandleBrot extends JPanel {

	public static void main(String[] args) {
		new MandleBrot();
	}

	// constants
	static int PANW = 1000;
	static int PANH = 600;
	static int MAXITER = 255;

	// global variables
	double xmin = -2.5;
	double xmax = +1.0;
	double ymin = -1.0;
	double ymax = +1.0;
	double xstep = (xmax - xmin) / PANW; // x increment for 1 pixel
	double ystep = (ymax - ymin) / PANH; // y increment

	// constructor for Jpanel
	MandleBrot() {
		JFrame w = setupGUI();
		w.setVisible(true);
		// setupGUI().setVisible(true);
	}

	JFrame setupGUI() {
		JFrame window = new JFrame("Manlebrot");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set properties of JPanel
		this.setPreferredSize(new Dimension(PANW, PANH));
		window.add(this);
		window.pack();
		window.setLocationRelativeTo(null);
		return window;
	}

	@Override // this method runs upon "setVisible(true)"
	protected void paintComponent(Graphics g) {
		// go through each point
		for (double x = xmin; x < xmax; x += xstep) {
			for (double y = ymin; y < ymax; y += ystep) {
				Color clr = Color.WHITE;
				int n = iterate(x, y);
				if (n == 0)
					clr = Color.BLACK;
				else {
					clr = Color.getHSBColor(n / 255.0f, 1.0f, 1.0f);
				}
				plotPoint(x, y, g, clr);
			}
		}
	}

	int iterate(double cReal, double cImag) {
		double zReal = 0.0;
		double zImag = 0.0;
		double temp;

		int i = 0;
		while (i++ < MAXITER) {
			// calculate the nexy z
			temp = zReal * zReal - zImag * zImag + cReal;
			zImag = 2 * zReal * zImag + cImag;
			zReal = temp;
			// if z^2 is more than 4, then it's close to infinity
			if (zReal * zReal + zImag * zImag > 4)
				break;
		}

		// If we have not gotten past 4 after 255 iterations, then return 0.
		// Otherwise return the number of iterations to get past 4.
		return (i > MAXITER) ? 0 : i;
	}

	void plotPoint(double x, double y, Graphics g, Color c) {
		int px = (int) ((PANW * (x - xmin)) / (xmax - xmin));
		int py = (int) ((PANH * (y - ymin)) / (ymax - ymin));
		py = PANH - py; // to invert the y axis

		g.setColor(c);
		g.fillRect(px, py, 1, 1);
	}
}