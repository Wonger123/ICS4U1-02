/* Andrew Wong
 * May.25.22
 * 
 * Conway's Game of Life
 */
package unit4.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOfLife {

	public static void main(String[] args) {
		new GameOfLife();
	}

	/* Global Variables */
	JFrame frame;
	JPanel drPanel, txtPanel;
	JButton playPause, clearBoard;
	JLabel genNum;

	int tileCounter = 0; // maybe???
	int genCounter = 0;
	boolean simActive = false;

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int winW;
	static int winH;

	final static int SIZE = 40;
	final int CELLSIZE;
	final static int ALIVE = 1;
	final static int DEAD = 0;

	int[][] board = new int[SIZE][SIZE];

	Timer timer;
	int timerSpeed = 100;

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
		private int sp = 2;

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
			g2.setStroke(new BasicStroke(3));
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

				// 1. If the square is not DEAD then return
				if (board[row][col] != 0)
					return;

				// 2. Fill cell
				board[row][col] = ALIVE;

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
	}

	class MyAL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Play")) {
				playPause.setText("Pause");
				timer.start();
				simActive = true;
			}
			if (e.getActionCommand().equals("Pause")) {
				playPause.setText("Play");
				timer.stop();
				simActive = false;
			}
			if (e.getActionCommand().equals("Clear Board")) {
				init();
				playPause.setText("Play");
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
			int aliveCount;

			// Loop through every cell
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					aliveCount = neighbourCheck(i, j);

					if (board[i][j] == ALIVE) {
						if (aliveCount < 2)
							board[i][j] = DEAD;
						if (aliveCount > 3)
							board[i][j] = DEAD;
						else
							board[i][j] = ALIVE;
					} else {
						if (aliveCount == 3)
							board[i][j] = ALIVE;
						else
							board[i][j] = DEAD;
					}
				}
			}

			genCounter++;

			txtPanel.repaint();
			drPanel.repaint();
		}

		int neighbourCheck(int ci, int cj) {
			int aliveCount = 0;
			for (int i = ci - 1; i <= ci + 1; i++) {
				for (int j = cj - 1; j <= cj + 1; j++) {
					try {
						if (board[i][j] == ALIVE)
							aliveCount++;
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
			}
			if (board[ci][cj] == ALIVE)
				return aliveCount - 1;
			else
				return aliveCount;
		}
	}
}