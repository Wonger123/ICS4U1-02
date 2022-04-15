package unit4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons implements ActionListener {
	public static void main(String[] args) {
		new Buttons();
	}

	// global variables
	JFrame window;
	JPanel panel;
	JButton btn1;

	Buttons() {
		// setup panel
		panel = new JPanel();
		btn1 = new JButton("Red");
		btn1.setActionCommand("R");
		JButton btn2 = new JButton("Green");
		JButton btn3 = new JButton("Blue");
		btn1.addActionListener(new MyAL());
		// btn1.addActionListener(new MoveAL());
		btn2.addActionListener(new MyAL());
		// btn2.addActionListener(new MoveAL());
		btn3.addActionListener(this);
		// btn3.addActionListener(new MoveAL());
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		// setup JFrame
		window = new JFrame("Events demo");
		window.setSize(500, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.setVisible(true);
	} // end of constructor

	// inner class. Must implement ActionListener
	class MyAL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("R")) {
				panel.setBackground(Color.RED);
				btn1.setText("Good choice");
			} else {
				panel.setBackground(Color.GREEN);
			}
		}
	}

	class MoveAL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int x = (int) (1000 * Math.random());
			int y = (int) (1000 * Math.random());
			window.setLocation(x, y);
		}
	}

	// This is for the actionListener that's implemented in the main (Buttons) class
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.setBackground(Color.BLUE);
	}
}