/* Andrew Wong
 * Apr.15.22
 * 
 * This program demonstrates Events in Java graphics
 * The homepage consists of 2 buttons, a checkbox, and a menu bar
 * The menu bar has 2 options which open a new window each
 * The "Random Color!" button on the homepage sets the background to a random color using randomly generated RGB values
 * The "Close" button will close the window and terminate the program
 * Only the "Close" button on the homepage will terminte the program, the close buttons on the other 2 windows will only close the window
 * The checkbox will set the background color to a random color on a timer when checked
 */
package unit4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EventsAssignment {

	public static void main(String[] args) {
		new EventsAssignment();
	}

	// global variables
	JFrame window1;
	JPanel panel;
	JButton btn1, btn2;
	JMenuBar menuBar;
	JMenu menu1;
	JMenuItem menuItem1, menuItem2;
	JCheckBox checkBox;
	Timer timer;
	int timerSpeed = 500;

	EventsAssignment() {
		// setup window1
		window1 = new JFrame("Events demo");
		window1.setSize(500, 300);
		window1.setLocationRelativeTo(null);
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setup menu bar
		menuBar = new JMenuBar();
		menu1 = new JMenu("Info");
		menuItem1 = new JMenuItem("About");
		menuItem1.addActionListener(new AL());
		menuItem2 = new JMenuItem("Help");
		menuItem2.addActionListener(new AL());
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menuBar.add(menu1);
		window1.setJMenuBar(menuBar);

		// setup panel
		panel = new JPanel();
		panel = new JPanel();
		btn1 = new JButton("Random Color!");
		btn2 = new JButton("Close");

		btn1.addActionListener(new RandomColor());
		btn2.addActionListener(e -> {
			window1.dispose();
			timer.stop();
		});

		checkBox = new JCheckBox("Automatic Colors");
		checkBox.addActionListener(new RandomColor());
		timer = new Timer(timerSpeed, new TimerListener());

		panel.add(btn1);
		panel.add(checkBox);
		panel.add(btn2);

		window1.add(panel);
		window1.setVisible(true);
	}

	class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int r = (int) (Math.random() * 255) + 1;
			int g = (int) (Math.random() * 255) + 1;
			int b = (int) (Math.random() * 255) + 1;
			Color randomColor = new Color(r, g, b);

			panel.setBackground(randomColor);
		}
	}

	class RandomColor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (checkBox.isSelected()) {
				timer.start();
			} else {
				timer.stop();
				int r = (int) (Math.random() * 255) + 1;
				int g = (int) (Math.random() * 255) + 1;
				int b = (int) (Math.random() * 255) + 1;
				Color randomColor = new Color(r, g, b);

				panel.setBackground(randomColor);
			}
		}
	}

	class AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("About")) {
				new AboutWindow();
			}
			if (e.getActionCommand().equals("Help")) {
				new HelpWindow();
			}
		}
	}

	class AboutWindow extends JFrame {

		JFrame window2;
		JPanel panel;
		JLabel label1, label2;
		JButton btn1;

		AboutWindow() {
			window2 = new JFrame("About");
			window2.setSize(500, 200);

			panel = new JPanel();
			label1 = new JLabel("This is a program the changes the background color");
			label2 = new JLabel("to a random color on a button press.");
			panel.add(label1);
			panel.add(label2);
			btn1 = new JButton("Close");
			btn1.addActionListener(e -> {
				window2.dispose();
			});
			panel.add(btn1);

			window2.add(panel);
			window2.setVisible(true);
		}
	}

	class HelpWindow extends JFrame {

		JFrame window3;
		JPanel panel;
		JLabel label1, label2;
		JButton btn1;

		HelpWindow() {
			window3 = new JFrame("About");
			window3.setSize(500, 200);

			char ch = '"';
			panel = new JPanel();
			label1 = new JLabel("To change the background color to a random color,");
			label2 = new JLabel("simply press the " + ch + "Random Color!" + ch + " button.");
			panel.add(label1);
			panel.add(label2);
			btn1 = new JButton("Close");
			btn1.addActionListener(e -> {
				window3.dispose();
			});
			panel.add(btn1);

			window3.add(panel);
			window3.setVisible(true);
		}
	}
}