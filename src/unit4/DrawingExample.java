package unit4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingExample extends JFrame {

	public static void main(String[] args) {
		new DrawingExample();
	}

	DrawingExample() {
		// setup JFrame
		this.setSize(800, 600);
		this.setTitle("First Drawing");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingPanel panel = new DrawingPanel();
		panel.setBackground(Color.BLACK);
		this.add(panel);
		this.setVisible(true);
		// panel.paintComponent(null);
	}

	class DrawingPanel extends JPanel {
		DrawingPanel() {
			// this.setBackground(Color.ORANGE);
		}

		// ALL drawing happens here:
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // run the JPanel paintComponent first
			g.setColor(Color.ORANGE);
			g.fillRect(100, 100, 300, 80);
			g.setColor(Color.CYAN);
			g.fillOval(0, 0, 100, 100);
			g.drawLine(250, 0, 250, 600);
		}
	}
}