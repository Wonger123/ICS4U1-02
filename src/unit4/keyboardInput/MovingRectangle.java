package unit4.keyboardInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingRectangle {

	public static void main(String[] args) {
		new MovingRectangle();
	}

	JFrame window;
	DrawingPanel panel;
	Rectangle player;
	static int panW = 800, panH = 600;

	MovingRectangle() {
		player = new Rectangle(panW / 2, panH - 200, 100, 60);
		window = new JFrame("Let's move this rectangle!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new DrawingPanel();

		window.add(panel); // the panel will control the size
		window.pack(); // there we need pack
		window.setVisible(true);
	}

	private class DrawingPanel extends JPanel implements KeyListener {

		DrawingPanel() {
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new Dimension(panW, panH));
			this.addKeyListener(this);
			this.setFocusable(true); // need something like this to get focus
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.RED);
			g.drawRect(player.x, player.y, player.width, player.height);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 'W' && player.y > 0)
				player.y -= 5;
			if (e.getKeyCode() == 'A' && player.x > 0)
				player.x -= 5;
			if (e.getKeyCode() == 'S' && player.y + player.height < panH)
				player.y += 5;
			if (e.getKeyCode() == 'D' && player.x + player.width < panW)
				player.x += 5;
			
			// window.setTitle("Key: " + e.getKeyCode());
			// cursor keys
			// # or KeyEvent.VK
			if (e.getKeyCode() == KeyEvent.VK_UP && player.y > 0)
				player.y -= 5;
			if (e.getKeyCode() == KeyEvent.VK_LEFT && player.x > 0)
				player.x -= 5;
			if (e.getKeyCode() == 40 && player.y + player.height < panH)
				player.y += 5;
			if (e.getKeyCode() == 39 && player.x + player.width < panW)
				player.x += 5;
			this.repaint(); // panel must be repainted
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
}