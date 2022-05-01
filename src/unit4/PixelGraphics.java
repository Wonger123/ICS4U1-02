package unit4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelGraphics {
	// colouring pixels individually

	public static void main(String[] args) {
		new PixelGraphics();
	}

	PixelGraphics() {
		JFrame window = new JFrame("Pixel Graphics");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);

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

			for (int x = 0; x < panW; x++) {
				for (int y = 0; y < panH; y++) {
					//Color c = new Color(x % 256, y % 256, (x + y) % 256);
					//Color c = new Color(50, 50, (x * x + y * y) / 4 % 256);
					//Color c = new Color((x ^ y) % 256, 0, 0);
					double rr = (Math.cos(x * Math.PI/180) - Math.sin(y * Math.PI/180)) * 255;
					double gg = (Math.cos((y) * Math.PI/180) + Math.sin((x) * Math.PI/180)) * 255;
					double bb = (Math.cos(x * Math.PI/180) + Math.sin(y * Math.PI/180)) * 255;
					Color c = new Color((int)(Math.abs(rr))%256, (int)(Math.abs(gg))%256, (int)(Math.abs(bb))%256);


					g.setColor(c);
					g.fillRect(x, y, 1, 1);
				}
			}
		}
	}
}