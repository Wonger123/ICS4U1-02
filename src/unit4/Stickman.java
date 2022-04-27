package unit4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Stickman extends JFrame {

	public static void main(String[] args) {
		new Stickman();
	}

	Stickman() {
		// setup JFrame
		this.setSize(800, 600);
		this.setTitle("First Drawing");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingPanel panel = new DrawingPanel();
		panel.setBackground(Color.GRAY);
		
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
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));

			g.setColor(Color.RED);
			g.drawLine(350, 400, 400, 300); // left leg
			g.drawLine(450, 400, 400, 300); // right leg
			g.drawLine(400, 300, 400, 200); // torso
			g.drawOval(350, 100, 100, 100); // head
			g.drawLine(400, 225, 330, 310); // left arm
			g.drawLine(400, 225, 470, 310); // right arm
		}
	}
}