package unit4;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class MigLayoutAssignment extends JFrame{

	public static void main(String[] args) {
		
		new MigLayoutAssignment();
	}
	
	MigLayoutAssignment() {
		JFrame window = new JFrame("");
		window.setSize(800,700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new MigLayout("wrap 3, insets 10, debug")); // turn debug off later
		
		setupGUI(panel);
		
		window.add(panel);
		window.pack();
		window.setVisible(true);
	}
	
	void setupGUI(JPanel p) {
		p.setBackground(Color.GRAY);
		p.add(new JLabel("Find:"), "align right");
	}
}