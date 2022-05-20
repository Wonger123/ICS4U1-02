package unit4.loadingIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PendulumProgram extends JFrame {

	public static void main(String[] args) {
		new PendulumProgram();
	}

	// global variables
	DrawingPanel panel;
	static int panW = 500;
	static int panH = 500;

	Timer timer;
	int timerSpeed = 15;

	double angle = Math.PI / 2;
	int length;
	int anchorX, anchorY;
	int ballX, ballY;

	Pendulum p1 = new Pendulum(200, 30);

	PendulumProgram() {
		// set up window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new DrawingPanel();

		this.add(panel);
		this.pack();
		this.setVisible(true);

		timer = new Timer(timerSpeed, new MyTimer());
		timer.start();
	}

	class Pendulum {

		double dt;

		Pendulum(int a, double t) {
			length = a;
			dt = t;
			recalc();
		}

		void draw(Graphics g2) {
			anchorX = getWidth() / 2;
			anchorY = getHeight() / 3;
			ballX = anchorX + (int) (Math.sin(angle) * length);
			ballY = anchorY + (int) (Math.cos(angle) * length);
			g2.drawLine(anchorX, anchorY, ballX, ballY);
			g2.fillOval(anchorX - 3, anchorY - 4, 7, 7);
			g2.fillOval(ballX - 15, ballY - 15, 30, 30);
		}

		public void recalc() {
			ballX = anchorX + (int) (Math.sin(angle) * length);
			ballY = anchorY + (int) (Math.cos(angle) * length);
		}
	}

	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setBackground(Color.DARK_GRAY);
			this.setPreferredSize(new Dimension(panW, panH));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;	
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g.setColor(Color.WHITE);
			p1.draw(g2);
		}
	}

	class MyTimer implements ActionListener {
		double tick = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			angle = Math.toRadians(90 * Math.sin(tick / p1.dt));
			p1.recalc();
			tick++;
			panel.repaint();
		}
	}
}