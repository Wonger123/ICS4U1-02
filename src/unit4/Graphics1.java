package unit4;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphics1 {

	public static void main(String[] args) {
		new Graphics1();
	}

	//constructor
	Graphics1() {
		//set up the graphics
		JFrame window = new JFrame();
		window.setSize(800,700);
		window.setTitle("First Graphics program");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setResizable(false); // normally
		window.setLocationRelativeTo(null); //centres the window
		
		//setup panel
		JPanel panel = new JPanel();
		
		
		//					  R   G  B
		Color c1 = new Color(100, 0, 170);  //each # is 0-255
									//green + some blue
		Color c2 = Color.decode("#00CC3F"); 
		//panel.setBackground(Color.YELLOW);
		panel.setBackground(c2);
		
		panel.add(new JLabel("hello"));
		JLabel label1 = new JLabel("GoodBye");
		label1.setBackground(Color.WHITE);
		label1.setOpaque(true);
		label1.setForeground(Color.RED);		
		panel.add(label1);
		
		for (int i = 1; i <= 10; i++) {
			panel.add(new JButton("Btn"+ i));
		}
		
		window.add(panel);		
		
		window.setVisible(true);  //this is the last thing you do (normally)
	}
}
