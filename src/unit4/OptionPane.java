package unit4;

import javax.swing.JOptionPane;

public class OptionPane {

	public static void main(String[] args) {

		int num = JOptionPane.showConfirmDialog(null, "Would you like some cake?", "Cake",
				JOptionPane.YES_NO_CANCEL_OPTION);

		if (num == 0) {
			String flavour = JOptionPane.showInputDialog(null, "What kind of cake do you like?", "Cake Flavour",
					JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(null, "I like " + flavour + " cake too!", "CAKE!", JOptionPane.INFORMATION_MESSAGE);
		}
		if (num == 1) {
			JOptionPane.showConfirmDialog(null, "Do you like cake?", "Cake", JOptionPane.YES_NO_OPTION);
		}
		if (num == 2) {
			System.out.println("Cancel pressed");
			System.exit(0);
		}

		JOptionPane.showMessageDialog(null, "The Cake is a Lie.", "The Cake is a Lie.", JOptionPane.WARNING_MESSAGE);
	}
}