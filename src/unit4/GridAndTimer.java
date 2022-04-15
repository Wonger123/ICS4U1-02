/* Andrew Wong
 * Apr.5.22
 * Demonstrating how a Timer works, also more GridLayout
 */
package unit4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer; // make sure it's SWING.timer

public class GridAndTimer {

	public static void main(String[] args) {
		
		new GridAndTimer().run();
	}
	
	JPanel panel;
	Timer timer;
	int timerSpeed = 500; // ms
	
	GridAndTimer() {
		JFrame window = new JFrame("Testing Grid Layout");
		window.setSize(800,700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,3)); // 5 rows, 3 columns
		panel.setBackground(Color.LIGHT_GRAY);
		
		window.add(panel);
		window.setVisible(true);
		
		timer = new Timer(timerSpeed, new TimerListener()); // 500ms
	}
	
	void run() {
		timer.start();
	}
	
	class TimerListener implements ActionListener {
		
		int num = 1;
		
		// this will run every n seconds (500ms)
		@Override
		public void actionPerformed(ActionEvent e) {
			if (num >= 20) {
				timer.stop();
			}
			panel.add(new JButton("" + num));
			panel.validate();
			num++;
		}
	}
}