/* Andrew Wong
 * May.25.22
 * 
 * Conway's Game of Life
 */
package unit4.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameOfLife {

	public static void main(String[] args) {
		new GameOfLife();
	}

	/* Global Variables */
	JFrame frame;
	JPanel drPanel, txtPanel;
	JButton playPause, clearBoard;
	JLabel genNum;

	int genCounter = 0;
	boolean simActive = false;

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int winW;
	static int winH;

	final static int SIZE = 100;
	final int CELLSIZE;
	final static int ALIVE = 1;
	final static int DEAD = 0;

	int[][] board = new int[SIZE][SIZE];

	Timer timer;
	int timerSpeed = 150;

	GameOfLife() {
		int h = (int) screenSize.getHeight();
		CELLSIZE = h / SIZE;

		winW = CELLSIZE * SIZE;
		winH = CELLSIZE * SIZE + 10;

		timer = new Timer(timerSpeed, new MyTimer());

		init();
		createAndShowGUI();
	}

	void init() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = DEAD;
			}
		}
		simActive = false;
		genCounter = 0;
		timer.stop();
	}

	void run() {
	}

	void createAndShowGUI() {
		frame = new JFrame("TicTacToe");
		frame.setLayout(new BorderLayout(2, 1));
		frame.getContentPane().setBackground(Color.BLACK);

		txtPanel = new JPanel();
		txtPanel.setBackground(Color.LIGHT_GRAY);
		txtPanel.setLayout(new GridLayout(1, 3, 10, 10));

		// generation counter
		genNum = new JLabel();
		genNum.setText("Generation: " + genCounter);
		genNum.setFont(new Font("Dialog", Font.BOLD, 15));
		genNum.setHorizontalAlignment(JLabel.CENTER);
		txtPanel.add(genNum);

		// play/pause button
		playPause = new JButton();
		playPause.setText("Play");
		playPause.addActionListener(new MyAL());
		txtPanel.add(playPause);

		// clear board button
		clearBoard = new JButton();
		clearBoard.setText("Clear Board");
		clearBoard.addActionListener(new MyAL());
		txtPanel.add(clearBoard);

		drPanel = new DrawingPanel();

		frame.add(txtPanel, BorderLayout.NORTH);
		frame.add(drPanel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(winW, winH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private class DrawingPanel extends JPanel implements MouseListener {

		private int panW, panH; // size of panel
		private int sp = 1;

		DrawingPanel() {
			this.setBackground(Color.LIGHT_GRAY);
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
			for (int i = 0; i < SIZE; i++) {
				g.drawLine(i * CELLSIZE, 0, i * CELLSIZE, panH);
				g.drawLine(0, i * CELLSIZE, panW, i * CELLSIZE);
			}

			// fill cell
			g.setColor(Color.BLUE);
			for (int row = 0; row < SIZE; row++) {
				for (int col = 0; col < SIZE; col++) {
					if (board[row][col] == ALIVE) {
						g.fillRect(col * CELLSIZE + sp, row * CELLSIZE + sp, CELLSIZE - 2 * sp, CELLSIZE - 2 * sp);
					}
				}
			}
		}

		void initGraphics() {
			panW = drPanel.getSize().width;
			panH = drPanel.getSize().height;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (!simActive) {
				int x = e.getX();
				int y = e.getY();
				int row = y / CELLSIZE;
				int col = x / CELLSIZE;

				// fill/remove cell
				if (board[row][col] == DEAD) {
					board[row][col] = ALIVE;
				} else {
					board[row][col] = DEAD;
				}

				drPanel.repaint();
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
	}

	class MyAL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Play")) {			// start sim
				playPause.setText("Pause");
				timer.start();
				simActive = true;
			}
			if (e.getActionCommand().equals("Pause")) {			// pause sim
				playPause.setText("Play");
				timer.stop();
				simActive = false;
			}
			if (e.getActionCommand().equals("Clear Board")) {	// clear board
				init();
				playPause.setText("Play");
				genCounter = 0;
				genNum.setText("Generation: " + genCounter);
				timer.stop();
				simActive = false;

				drPanel.repaint();
				txtPanel.repaint();
			}
		}
	}

	class MyTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int aliveCount = 0;
			int[][] boardCopy = new int[SIZE][SIZE];

			// loop through every cell
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					aliveCount = neighbourCheck(i, j);

					if (board[i][j] == ALIVE) {
						if (aliveCount < 2) 			// under-population
							boardCopy[i][j] = DEAD;
						else if (aliveCount > 3) 		// over-populatin
							boardCopy[i][j] = DEAD;
						else 							// remains alive
							boardCopy[i][j] = ALIVE;
					} else {
						if (aliveCount == 3) 			// birth
							boardCopy[i][j] = ALIVE;
						else 							// remains dead
							boardCopy[i][j] = DEAD;
					}
				}
			}
			board = boardCopy;

			genCounter++;
			genNum.setText("Generation: " + genCounter);

			txtPanel.repaint();
			drPanel.repaint();
		}

		public int neighbourCheck(int ci, int cj) {
			int aCounter = 0;
			// top edge
			if (ci == 0 && cj != 0 && cj != SIZE - 1) {
				for (int row = ci; row <= ci + 1; row++) {
					for (int col = cj - 1; col <= cj + 1; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// bottom edge
			if (ci == SIZE - 1 && cj != 0 && cj != SIZE - 1) {
				for (int row = ci - 1; row <= ci; row++) {
					for (int col = cj - 1; col <= cj + 1; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// left edge
			if (ci != 0 && ci != SIZE - 1 && cj == 0) {
				for (int row = ci - 1; row <= ci + 1; row++) {
					for (int col = cj; col <= cj + 1; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// right edge
			if (ci != 0 && ci != SIZE - 1 && cj == SIZE - 1) {
				for (int row = ci - 1; row <= ci + 1; row++) {
					for (int col = cj - 1; col <= cj; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// top-left corner
			if (ci == 0 && cj == 0) {
				for (int row = ci; row <= ci + 1; row++) {
					for (int col = cj; col <= cj + 1; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// top-right corner
			if (ci == 0 && cj == SIZE - 1) {
				for (int row = ci; row <= ci + 1; row++) {
					for (int col = cj - 1; col <= cj; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// bottom-left corner
			if (ci == SIZE - 1 && cj == 0) {
				for (int row = ci - 1; row <= ci; row++) {
					for (int col = cj; col <= cj + 1; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// bottom-right corner
			if (ci == SIZE - 1 && cj == SIZE - 1) {
				for (int row = ci - 1; row <= ci; row++) {
					for (int col = cj - 1; col <= cj; col++) {
						if (board[row][col] == ALIVE) {
							aCounter++;
						}
					}
				}
			}
			// rest of the grid
			if (ci > 0 && ci < SIZE - 1 && cj > 0 && cj < SIZE - 1) {
				for (int row = ci - 1; row <= ci + 1; row++) {
					for (int col = cj - 1; col <= cj + 1; col++) {
						if (board[row][col] == ALIVE)
							aCounter++;
					}
				}
			}

			// remove centre celL from count if it is alive
			if (board[ci][cj] == ALIVE)
				aCounter--;
						
			return aCounter;
		}
	}
}