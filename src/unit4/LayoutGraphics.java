package unit4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*  --- Layout Information ---
 * JFrame defaults to BorderLayout
 *    BorderLayout.CENTER is the default location when you add things
 *    BorderLayout.CENTER will grow to fill all available space
 * JPanel defaults to FlowLayout
 * 	  FlowLayout wraps depending on the width of the window.
 *    It defaults to being centred in the window.
 * 
 * All layouts can be created with horizontal and vertical gaps.
 */
public class LayoutGraphics extends JFrame {

	public static void main(String[] args) {
		new LayoutGraphics();
	}

	/* Global variables */
	
	//You can create the object here or in your setup part of the program.
	JPanel panelA;
	JPanel panelB = new JPanel();
	
	LayoutGraphics(){
		this.setSize(800,700);
		this.setTitle("Layouts");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //centres the window
		
		/** set up panel A **/
		panelA = new JPanel();
		panelA.setBackground(Color.PINK);
		//panelA.setSize(400, 700); //????
		panelA.setPreferredSize(new Dimension(400, 500));
		this.add(panelA, BorderLayout.WEST);
		
		/** set up panel B **/
		panelB.setBackground(Color.GREEN);
		
		//4 rows, 2 cols, 10 pixel gaps between buttons
		panelB.setLayout(new GridLayout( 4,2, 10,10));
		for (int i=0; i < 8; i++) {
			panelB.add(new JButton("Button " + i));
		}
		
		this.add(panelB, BorderLayout.EAST);
		
		this.pack(); //optional. Make the window as small as possible.
		this.setVisible(true);
	}
}
