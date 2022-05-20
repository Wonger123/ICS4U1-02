/* Andrew Wong
 * May.20.22
 * 
 * Moves a ball from left to right across the screen
 * "Pause" button stops the animaton and changes the text on the button to "Resume"
 * "Resume" button resumes the animation and changes the text on the button to "Pause"
 * "Reverse" button changes the direction of the ball's movement
 * "Pause/Resume" button pauses the animation regardless if the ball is moving right of left
 */
package unit4.graphicsTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestMain {

	public static void main(String[] args) {
		new TestMain().run();
	}

	static final int WINW = 800;
	static final int WINH = 600;

	GraphicsPanel drPanel;
	JPanel btnPanel;
	
	JButton pause;
	JButton reverse;

	Timer timer;
	int timerSpeed = 20;

	Ball ball;

	TestMain() {
		JFrame window = new JFrame("Test");
		window.setLayout(new BorderLayout(2, 1));

		ball = new Ball(200, 200, 10);

		// drawing panel with animation
		drPanel = new GraphicsPanel();
		drPanel.setPreferredSize(new Dimension(WINW, WINH - 100));

		// btn panel
		btnPanel = new JPanel();
		btnPanel.setBackground(Color.BLACK);
		
		// pause btn
		pause = new JButton();
		pause.setText("Pause");
		pause.addActionListener(new MyAl());
		btnPanel.add(pause);
		
		// reverse btn
		reverse = new JButton();
		reverse.setText("Reverse");
		reverse.addActionListener(new MyAl());
		btnPanel.add(reverse);

		window.add(drPanel, BorderLayout.CENTER);
		window.add(btnPanel, BorderLayout.SOUTH);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WINW, WINH);
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

			// drawing ball
			g.setColor(Color.RED);
			g.fillOval(ball.x, ball.y, ball.width, ball.height);
		}
	}

	class MyTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// moving ball
			ball.move();
			drPanel.repaint();
		}
	}

	class MyAl implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Pause")) {
				timer.stop();
				pause.setText("Resume");
			}
			if (e.getActionCommand().equals("Resume")) {
				timer.start();
				pause.setText("Pause");
			}
			if (e.getActionCommand().equals("Reverse")) {
				ball.vx *= -1;
			}
		}
	}
}