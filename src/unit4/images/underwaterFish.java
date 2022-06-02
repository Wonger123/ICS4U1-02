package unit4.images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class underwaterFish {

	public static void main(String[] args) {
		new underwaterFish();
	}
	
	JFrame window;
	JPanel panel;
	
	underwaterFish() {
		window = new JFrame("Underwater Fish");
		window.setSize(800, 600);
		panel = new JPanel();
		
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}