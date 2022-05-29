/* Andrew Wong
 * May.16.22
 * 
 * TicTacToe game with win counter and reset button
 */
package unit4.game;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe {

	public static void main(String[] args) {
		new TicTacToe();
	}

	/* Global Variables */
	JFrame frame;
	JPanel drPanel, txtPanel;
	JLabel playerTurn;
	JLabel xWinLabel;
	JLabel oWinLabel;
	JLabel tieLabel;

	JButton newGame;
	JButton resetScore;

	int xWinCounter = 0;
	int oWinCounter = 0;
	int tieCounter = 0;
	boolean xWin = false, oWin = false;

	final static int SIZE = 3; // size of grid
	final static int XX = 1;
	final static int OO = -1;
	final static int EMPTY = 0;

	boolean turnX = true;

	int[][] board = new int[SIZE][SIZE];

	TicTacToe() {
		init();
		createAndShowGUI();
	}

	void init() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = EMPTY;
			}
		}
		xWin = false;
		oWin = false;
		turnX = true;
	}

	void createAndShowGUI() {
		frame = new JFrame("TicTacToe");
		frame.setLayout(new BorderLayout(2, 1));
		frame.getContentPane().setBackground(Color.BLACK);

		txtPanel = new JPanel();
		txtPanel.setBackground(Color.LIGHT_GRAY);
		txtPanel.setLayout(new GridLayout(2, 3, 10, 10));

		// x win counter
		xWinLabel = new JLabel();
		xWinLabel.setText("X Wins: " + xWinCounter);
		xWinLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		xWinLabel.setHorizontalAlignment(JLabel.CENTER);
		txtPanel.add(xWinLabel);

		// tie counter
		tieLabel = new JLabel();
		tieLabel.setText("Ties: " + tieCounter);
		tieLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		tieLabel.setHorizontalAlignment(JLabel.CENTER);
		txtPanel.add(tieLabel);

		// o win counter
		oWinLabel = new JLabel();
		oWinLabel.setText("O Wins: " + oWinCounter);
		oWinLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		oWinLabel.setHorizontalAlignment(JLabel.CENTER);
		txtPanel.add(oWinLabel);

		// reset button
		resetScore = new JButton();
		resetScore.setText("Reset Scores");
		resetScore.addActionListener(new MyAL());
		txtPanel.add(resetScore);

		// player turn
		playerTurn = new JLabel();
		playerTurn.setText("X's Turn");
		playerTurn.setFont(new Font("Dialog", Font.BOLD, 15));
		playerTurn.setHorizontalAlignment(JLabel.CENTER);
		txtPanel.add(playerTurn);

		// new game button
		newGame = new JButton();
		newGame.setText("New Game");
		newGame.addActionListener(new MyAL());
		txtPanel.add(newGame);

		drPanel = new DrawingPanel();

		frame.add(txtPanel, BorderLayout.NORTH);
		frame.add(drPanel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 450);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private class DrawingPanel extends JPanel implements MouseListener {

		private int panW, panH; // size of panel
		private int boxW, boxH; // size of one box/square
		private int sp = 6; // pixels of space around X or O

		DrawingPanel() {
			this.setBackground(new Color(240, 240, 240));
			this.addMouseListener(this);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			initGraphics();

			// draw grid
			g.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(4));
			for (int i = 0; i < SIZE; i++) {
				g.drawLine(i * boxW, 0, i * boxW, panH);
				g.drawLine(0, i * boxH, panW, i * boxH);
			}

			// draw X or O
			g.setColor(Color.RED);
			g2.setStroke(new BasicStroke(3));
			for (int row = 0; row < SIZE; row++) {
				for (int col = 0; col < SIZE; col++) {
					if (board[row][col] == OO) {	
						g.drawOval(col * boxW + sp, row * boxH + sp, boxW - 2 * sp, boxH - 2 * sp);
					}
					if (board[row][col] == XX) {
						g.drawLine(col * boxW + sp, row * boxH + sp, (col + 1) * boxW - sp, (row + 1) * boxH - sp);
						g.drawLine(col * boxW + sp, (row + 1) * boxH - sp, (col + 1) * boxW - sp, row * boxH + sp);
					}
				}
			}
		}

		void initGraphics() {
			panW = this.getSize().width;
			panH = this.getSize().height;
			boxW = (int) ((panW / SIZE) + 0.5);
			boxH = (int) ((panH / SIZE) + 0.5);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (!xWin && !oWin) {
				int x = e.getX();
				int y = e.getY();
				int row = y / boxH;
				int col = x / boxW;

				// 1. If the square is not empty then return
				if (board[row][col] != 0)
					return;

				// 2. Put X or O in the correct place
				if (turnX) {
					board[row][col] = XX;
					playerTurn.setText("O's Turn");
				} else {
					board[row][col] = OO;
					playerTurn.setText("X's Turn");
				}
				turnX = !turnX;

				// 3. Check for a winner
				win();

				// 4. If there is no winner, then check for a tie
				int tiles = 0;
				for (int i = 0; i < SIZE; i++) {
					for (int j = 0; j < SIZE; j++) {
						if (board[i][j] == EMPTY) {
							tiles++;
						}
					}
				}
				if (tiles == 0 && !xWin && !oWin) {
					tie();
				}
				
				drPanel.repaint(); // don't forget this
				txtPanel.repaint();
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		void win() {
			// x wins
			for (int i = 0; i < SIZE; i++) {
				// horizontal || vertical
				if (board[i][0] + board[i][1] + board[i][2] == 3 || board[0][i] + board[1][i] + board[2][i] == 3) {
					playerTurn.setText("X Wins!");
					xWinCounter++;
					xWin = true;
				}
			}

			// o wins
			for (int i = 0; i < SIZE; i++) {
				// horizontal || vertical
				if (board[i][0] + board[i][1] + board[i][2] == -3 || board[0][i] + board[1][i] + board[2][i] == -3) {
					playerTurn.setText("O Wins!");
					oWinCounter++;
					oWin = true;
				}
			}

			// x wins: Diagonal
			if (board[0][0] + board[1][1] + board[2][2] == 3 || board[0][2] + board[1][1] + board[2][0] == 3) {
				playerTurn.setText("X Wins!");
				xWinCounter++;
				xWin = true;
			}

			// o wins: Diagonal
			if (board[0][0] + board[1][1] + board[2][2] == -3 || board[0][2] + board[1][1] + board[2][0] == -3) {
				playerTurn.setText("O Wins!");
				oWinCounter++;
				oWin = true;
			}
			xWinLabel.setText("X Wins: " + xWinCounter);
			oWinLabel.setText("O Wins: " + oWinCounter);
			txtPanel.repaint();
		}

		void tie() {
			playerTurn.setText("Tie");
			tieCounter++;
			tieLabel.setText("Ties: " + tieCounter);
			txtPanel.repaint();
		}
	}

	class MyAL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("New Game")) {
				init();
				playerTurn.setText("X's Turn");
				drPanel.repaint();
				txtPanel.repaint();
			}
			if (e.getActionCommand().equals("Reset Scores")) {
				init();
				playerTurn.setText("X's Turn");
				xWinCounter = 0;
				oWinCounter = 0;
				tieCounter = 0;
				xWinLabel.setText("X Wins: " + xWinCounter);
				tieLabel.setText("Ties: " + tieCounter);
				oWinLabel.setText("O Wins: " + oWinCounter);
				drPanel.repaint();
				txtPanel.repaint();
			}
		}
	}
}