package unit4.images;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class underwaterFish {

	public static void main(String[] args) {
		new underwaterFish();
	}

	JFrame frame;
	DrawingPanel panel;

	BufferedImage water, fish;

	underwaterFish() {
		frame = new JFrame("Underwater Fish");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 700);

		panel = new DrawingPanel();
		water = loadImage("images/underwater.jpg");
		fish = loadImage("images/fish.png");

		frame.add(panel);
		frame.setVisible(true);
	}

	static BufferedImage loadImage(String filename) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename, "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		// DEBUG
		// if (img == null) System.out.println("null");
		// else System.out.printf("w=%d, h=%d%n",img.getWidth(),img.getHeight());

		return img;
	}

	class DrawingPanel extends JPanel {

		DrawingPanel() {
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(water, 0, 0, getWidth(), getHeight(), null);

			g.drawImage(fish, 0, 10, null);

			int fishScaler = fish.getWidth() / 120;
			Image shrinkFish = fish.getScaledInstance(120, fish.getHeight() / fishScaler, Image.SCALE_DEFAULT);
			g.drawImage(shrinkFish, 550, 50, null);

			g.drawImage(shrinkFish, 400, 300, -120, fish.getHeight() / fishScaler, null);
			g.drawImage(shrinkFish, 450, 400, 120, -fish.getHeight() / fishScaler, null);
			g.drawImage(shrinkFish, 700, 400, -120, -fish.getHeight() / fishScaler, null);

			g.drawImage(fish, 100, 400, fish.getWidth() / 2, 400 + (fish.getHeight() / 2), 0, 0, fish.getWidth() / 2,
					fish.getHeight(), null);
			g.drawImage(fish, 250, 400, 150 + fish.getWidth() / 2, 400 + (fish.getHeight() / 2), fish.getWidth() / 2, 0,
					fish.getWidth(), fish.getHeight(), null);
		}
	}
}