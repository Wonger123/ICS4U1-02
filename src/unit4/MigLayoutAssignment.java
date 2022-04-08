package unit4;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

public class MigLayoutAssignment extends JFrame {

	public static void main(String[] args) {

		new MigLayoutAssignment();
	}

	MigLayoutAssignment() {
		JFrame window = new JFrame("Pizza Order");
		window.setSize(800, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new MigLayout("wrap 3, gapy 20, insets 10, debug")); // turn debug off later

		setupGUI1(panel);

		window.add(panel);
		window.pack();
		window.setVisible(true);
	}

	void setupGUI1(JPanel p) {
		p.setBackground(Color.LIGHT_GRAY);
		p.add(new JLabel("Name:"), "align right");
		p.add(new JTextField(30), "span 2, wrap");

		p.add(new JLabel("Phone:"), "align right");
		p.add(new JTextField(15), "wrap");

		p.add(new JLabel("Address:"), "align right");
		p.add(new JTextField(30), "span 2, wrap");

		JPanel radioSize = new JPanel(new GridLayout(3, 1));
		JRadioButton small = new JRadioButton("Small");
		JRadioButton medium = new JRadioButton("Medium");
		JRadioButton large = new JRadioButton("Large");

		small.setSelected(true);

		ButtonGroup sizeButtonGroup = new ButtonGroup();

		sizeButtonGroup.add(small);
		sizeButtonGroup.add(medium);
		sizeButtonGroup.add(large);

		radioSize.add(small);
		radioSize.add(medium);
		radioSize.add(large);

		p.add(radioSize, "align center, top");

		JPanel radioStyle = new JPanel(new GridLayout(2, 1));
		JRadioButton thin = new JRadioButton("Thin");
		JRadioButton thick = new JRadioButton("Thick");

		thin.setSelected(true);

		ButtonGroup styleButtonGroup = new ButtonGroup();

		styleButtonGroup.add(thin);
		styleButtonGroup.add(thick);

		radioStyle.add(thin);
		radioStyle.add(thick);

		p.add(radioStyle, "align center, top");

		JPanel radioToppings = new JPanel(new GridLayout(5, 1));
		JRadioButton pepperoni = new JRadioButton("Pepperoni");
		JRadioButton mushrooms = new JRadioButton("Mushrooms");
		JRadioButton olives = new JRadioButton("Olives");
		JRadioButton bacon = new JRadioButton("Bacon");
		JRadioButton peppers = new JRadioButton("Peppers");

		pepperoni.setSelected(true);

		ButtonGroup toppingsButtonGroup = new ButtonGroup();

		toppingsButtonGroup.add(pepperoni);
		toppingsButtonGroup.add(mushrooms);
		toppingsButtonGroup.add(olives);
		toppingsButtonGroup.add(bacon);
		toppingsButtonGroup.add(peppers);

		radioToppings.add(pepperoni);
		radioToppings.add(mushrooms);
		radioToppings.add(olives);
		radioToppings.add(bacon);
		radioToppings.add(peppers);

		p.add(radioToppings, "align center, top");
	}
}