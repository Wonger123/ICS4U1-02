package unit4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics2 extends JFrame {

	public static void main(String[] args) {
		
		new Graphics2();
	}
	
	JPanel panelA;
	JPanel panelB = new JPanel();
	
	Graphics2() {
		this.setSize(800, 700);
		this.setTitle("Layouts ???");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window ends the program
		this.setLocationRelativeTo(null); // centers the window
		
		panelA = new JPanel();
		panelA.setBackground(Color.PINK);
		panelA.setPreferredSize(new Dimension(400, 700));
		this.add(panelA, BorderLayout.WEST);
		
		panelB.setBackground(Color.GREEN);	
		this.add(panelB, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
	}
}