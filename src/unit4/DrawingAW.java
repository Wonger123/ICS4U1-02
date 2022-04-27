/* Andrew Wong
 * Apr.25.22
 * 
 * This program draws a picutre on a JPanel
 */
package unit4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingAW extends JFrame {

	public static void main(String[] args) {
		new DrawingAW();
	}

	DrawingAW() {
		this.setSize(900, 600);
		this.setTitle("Drawing - AW");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingPanel panel = new DrawingPanel();

		this.add(panel);
		this.setVisible(true);
	}

	class DrawingPanel extends JPanel {
		DrawingPanel() {
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int red = 55, green = 54, blue = 54;
			// background
			for (int i = 0; i < 200; i++) {
				g.setColor(new Color(red, green, blue));
				g.fillRect(0, 600 - (i * 3) + 4, 900, 4);
				blue++;
				if (i % 4 == 0) {
					red++;
				}
				if (i % 3 == 0) {
					green++;
				}
			}

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// stars in background
			for (int i = 0; i < 500; i++) {
				int x = (int) (Math.random() * 899) + 1;
				int y = (int) (Math.random() * 599) + 1;
				g.setColor(Color.WHITE);
				g.fillRect(x, y, 2, 2);
			}

			// ground
			g.setColor(Color.decode("#4a4a4a"));
			g.fillRect(0, 450, 900, 150);

			// star on mountain peak
			g.setColor(Color.decode("#f7fc97"));
			g.fillOval(400, 160, 100, 100);
			for (int i = 0; i < 5; i++) {
				g.drawOval(398 - (i * 2), 158 - (i * 2), 104 + (i * 4), 104 + (i * 4));
			}

			// mountain
			g.drawPolygon(moutain(g));

			// beacon building
			g.drawPolygon(beamEmitter(g));

			// ground texturing
			g.setColor(Color.decode("#7a7a7a"));
			g2.setStroke(new BasicStroke(2));
			for (int i = 0; i < 450; i++) {
				int j = (int) (Math.random() * 7) + 4;
				g2.drawLine(900 - (i * 2), 450, 900 - (i * 2), 450 - j);
				int k = (int) (Math.random() * 20) + 14;
				g2.drawLine(900 - (i * 2), 450, 900 - (i * 2), 450 + k);
			}
			
			g.setColor(Color.BLACK);
			String str2 = "Andrew. W";
			g.setFont(new Font("Comic Sans", Font.PLAIN, 18));
			g.drawString(str2, 775, 550);
		}

		public Polygon moutain(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// mountain
			g.setColor(Color.decode("#575757"));
			Polygon mtn = new Polygon();
			mtn.addPoint(250, 450);
			mtn.addPoint(650, 450);
			mtn.addPoint(450, 200);
			g.fillPolygon(mtn);

			// mountain peak
			g.setColor(Color.decode("#737373"));
			Polygon mtnPeak = new Polygon();
			mtnPeak.addPoint(450, 200);
			mtnPeak.addPoint(370, 300);
			mtnPeak.addPoint(530, 300);
			g.fillPolygon(mtnPeak);

			// snow on mountain peak
			g.setColor(Color.WHITE);
			Polygon mtnPeakSnow = new Polygon();
			mtnPeakSnow.addPoint(450, 200);
			mtnPeakSnow.addPoint(417, 240);
			mtnPeakSnow.addPoint(483, 240);
			g.fillPolygon(mtnPeakSnow);

			return mtnPeakSnow;
		}

		public Polygon beamEmitter(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// building with beacon
			g.setColor(Color.decode("#C0C0C0"));
			g.fillRect(80, 435, 75, 15);
			g.setColor(new Color(173, 255, 255, 200)); // laser
			g2.setStroke(new BasicStroke(3));
			g.drawLine(125, 415, 125, 250);

			g.setColor(Color.decode("#C0C0C0")); // left pillar
			Polygon buildingLeftPillar = new Polygon();
			buildingLeftPillar.addPoint(121, 438);
			buildingLeftPillar.addPoint(121, 425);
			buildingLeftPillar.addPoint(116, 425);
			buildingLeftPillar.addPoint(121, 405);
			buildingLeftPillar.addPoint(121, 380);
			buildingLeftPillar.addPoint(114, 380);
			buildingLeftPillar.addPoint(105, 415);
			buildingLeftPillar.addPoint(109, 425);
			buildingLeftPillar.addPoint(100, 425);
			buildingLeftPillar.addPoint(100, 425);
			buildingLeftPillar.addPoint(95, 438);
			g.fillPolygon(buildingLeftPillar);

			Polygon buildingRightPillar = new Polygon(); // right pillar
			buildingRightPillar.addPoint(129, 438);
			buildingRightPillar.addPoint(140, 438);
			buildingRightPillar.addPoint(140, 422);
			buildingRightPillar.addPoint(133, 395);
			buildingRightPillar.addPoint(129, 395);
			g.fillPolygon(buildingRightPillar);

			g.setColor(new Color(0, 255, 255, 100)); // building details
			g.fillRect(118, 384, 3, 19);
			g.fillRect(129, 398, 3, 24);

			g.setColor(Color.GRAY);

			String str1 = "07";
			g.setFont(new Font("Orbitron", Font.BOLD, 11));
			g.drawString(str1, 107, 415);

			Polygon leftBottomTrapezoid = new Polygon(); // building detail
			leftBottomTrapezoid.addPoint(118, 432);
			leftBottomTrapezoid.addPoint(118, 428);
			leftBottomTrapezoid.addPoint(102, 428);
			leftBottomTrapezoid.addPoint(100, 432);
			g.fillPolygon(leftBottomTrapezoid);

			return leftBottomTrapezoid;
		}
	}
}