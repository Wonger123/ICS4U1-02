package unit4.loadingIcon;

import java.awt.*;
import javax.swing.*;

public class PendulumExample extends JPanel implements Runnable {

	private double angle = Math.PI / 2;
	private int length;
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Pendulum Example");
		PendulumExample p = new PendulumExample(100);
		f.add(p);
		new Thread(p).start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
	}

	public PendulumExample(int length) {
		this.length = length;
		setDoubleBuffered(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		int anchorX = getWidth() / 2, anchorY = getHeight() / 4;
		int ballX = anchorX + (int) (Math.sin(angle) * length);
		int ballY = anchorY + (int) (Math.cos(angle) * length);
		g.drawLine(anchorX, anchorY, ballX, ballY);
		g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
		g.fillOval(ballX - 7, ballY - 7, 14, 14);
	}

	public void run() {
		double angleAccel, angleVelocity = 0, dt = 0.1;
		while (true) {
			angleAccel = -9.81 / length * Math.sin(angle);
			angleVelocity += angleAccel * dt;
			angle += angleVelocity * dt;
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(2 * length + 50, length / 2 * 3);
	}
}