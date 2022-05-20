/* Andrew Wong
 * May.11.22
 * 
 * This program creates a loading icon animation with 20 balls bouncing around the screen
 */
package unit4.loadingIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LoadingIcon {

	public static void main(String[] args) {
		new LoadingIcon().run();
	}

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static final int WINW = (int) screenSize.getWidth();
	static final int WINH = (int) screenSize.getHeight();
	
	GraphicsPanel panel;

	Timer timer;
	int timerSpeed = 20;

	Ball b1x, b2x, b3x, b4x, b5x;
	Ball b6x, b7x, b8x, b9x, b10x;
	ArrayList<Ball> ballListX = new ArrayList<Ball>();

	Ball b1y, b2y, b3y, b4y, b5y;
	Ball b6y, b7y, b8y, b9y, b10y;
	ArrayList<Ball> ballListY = new ArrayList<Ball>();

	LoadingIcon() {
		// set up JFrame
		JFrame window = new JFrame("Bouncy Ball");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		b1x = new Ball(0, (WINH / 2) - 25, 15, 0);
		b2x = new Ball(0, (WINH / 2) - 25, 15, 0);
		b3x = new Ball(0, (WINH / 2) - 25, 15, 0);
		b4x = new Ball(0, (WINH / 2) - 25, 15, 0);
		b5x = new Ball(0, (WINH / 2) - 25, 15, 0);

		b6x = new Ball(WINW - 50, (WINH / 2) - 25, -15, 0);
		b7x = new Ball(WINW - 50, (WINH / 2) - 25, -15, 0);
		b8x = new Ball(WINW - 50, (WINH / 2) - 25, -15, 0);
		b9x = new Ball(WINW - 50, (WINH / 2) - 25, -15, 0);
		b10x = new Ball(WINW - 50, (WINH / 2) - 25, -15, 0);

		ballListX.add(b1x);
		ballListX.add(b2x);
		ballListX.add(b3x);
		ballListX.add(b4x);
		ballListX.add(b5x);
		ballListX.add(b6x);
		ballListX.add(b7x);
		ballListX.add(b8x);
		ballListX.add(b9x);
		ballListX.add(b10x);

		b1y = new Ball((WINW / 2) - 25, 0, 0, 15);
		b2y = new Ball((WINW / 2) - 25, 0, 0, 15);
		b3y = new Ball((WINW / 2) - 25, 0, 0, 15);
		b4y = new Ball((WINW / 2) - 25, 0, 0, 15);
		b5y = new Ball((WINW / 2) - 25, 0, 0, 15);

		b6y = new Ball((WINW / 2) - 25, WINH - 50, 0, -15);
		b7y = new Ball((WINW / 2) - 25, WINH - 50, 0, -15);
		b8y = new Ball((WINW / 2) - 25, WINH - 50, 0, -15);
		b9y = new Ball((WINW / 2) - 25, WINH - 50, 0, -15);
		b10y = new Ball((WINW / 2) - 25, WINH - 50, 0, -15);

		ballListY.add(b1y);
		ballListY.add(b2y);
		ballListY.add(b3y);
		ballListY.add(b4y);
		ballListY.add(b5y);
		ballListY.add(b6y);
		ballListY.add(b7y);
		ballListY.add(b8y);
		ballListY.add(b9y);
		ballListY.add(b10y);

		panel = new GraphicsPanel();
		panel.setPreferredSize(new Dimension(WINW, WINH));

		// remove JFrame
		window.setUndecorated(true);
		window.setContentPane(panel);
		window.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

		window.pack();
		window.setVisible(true);

		timer = new Timer(timerSpeed, new MyTimer());
		timer.start();
	}

	void run() {
		timer.start();
	}

	class GraphicsPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g.setColor(Color.RED);
			for (int i = 0; i < ballListX.size() / 2; i++) {
				g.fillOval(ballListX.get(i).x, ballListX.get(i).y, ballListX.get(i).width, ballListX.get(i).height);
			}

			g.setColor(Color.BLUE);
			for (int i = ballListX.size() / 2; i < ballListX.size(); i++) {
				g.fillOval(ballListX.get(i).x, ballListX.get(i).y, ballListX.get(i).width, ballListX.get(i).height);
			}

			g.setColor(Color.GREEN);
			for (int i = 0; i < ballListY.size() / 2; i++) {
				g.fillOval(ballListY.get(i).x, ballListY.get(i).y, ballListY.get(i).width, ballListY.get(i).height);
			}

			g.setColor(Color.YELLOW);
			for (int i = ballListY.size() / 2; i < ballListY.size(); i++) {
				g.fillOval(ballListY.get(i).x, ballListY.get(i).y, ballListY.get(i).width, ballListY.get(i).height);
			}
		}
	}

	class MyTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// horizontal movement
			for (int i = 0; i < ballListX.size(); i++) {
				ballListX.get(i).move();
			}

			// horizontal collision
			if (b1x.x + 50 >= b6x.x) {
				for (int i = 0; i < ballListX.size(); i++) {
					ballListX.get(i).vx *= -1;
				}

				b2x.vy -= 10;
				b3x.vy -= 5;
				b4x.vy += 5;
				b5x.vy += 10;

				b7x.vy -= 10;
				b8x.vy -= 5;
				b9x.vy += 5;
				b10x.vy += 10;
			}

			// vertical movement
			for (int i = 0; i < ballListY.size(); i++) {
				ballListY.get(i).move();
			}

			// vertical collision
			if (b1y.y + 50 >= b6y.y) {
				for (int i = 0; i < ballListY.size(); i++) {
					ballListY.get(i).vy *= -1;
				}

				b2y.vx -= 10;
				b3y.vx -= 5;
				b4y.vx += 5;
				b5y.vx += 10;

				b7y.vx -= 10;
				b8y.vx -= 5;
				b9y.vx += 5;
				b10y.vx += 10;
			}
			panel.repaint();
		}
	}
}