package unit4;

import java.awt.Color;

/**
 * Usage:
 * 
 * You do not need to ever make a ColourRainbow object since all of the methods
 * and variables are static.
 *
 * The next colour is selected by calling ColourRainbow.getNextColour() For
 * example: g.setColor( ColourRainbow.getNextColour() );
 * 
 * You can change the parameter "stepSize" to change how fast the colours
 * change.
 **/

public class ColourRainbow {

	private static int red = 255, green = 0, blue = 0;
	static int stepSize = 5;

	static Color getNextColour() {

		Color newColour = new Color(red, green % 256, blue);
		// Red to orange to yellow to green
		// red stays at 100%
		// add in green
		// then remove red
		if (red == 255 && green < 255 && blue == 0) {
			green += stepSize;
			if (green > 255)
				green = 255;
		} else if (red > 0 && green == 255 && blue == 0) {
			red -= stepSize;
			if (red < 0) {
				red = 0;
			}
		}

		// green to cyan to blue
		// add in blue
		// green goes from 255 to 0
		else if (green == 255 && blue < 255) {
			blue += stepSize;
			if (blue > 255)
				blue = 255;
		} else if (green > 0 && blue == 255) {
			green -= stepSize;
			if (green < 0) {
				green = 0;
			}
		}

		// blue to magenta to red
		else if (blue == 255 && red < 255) {
			red += stepSize;
			if (red > 255)
				red = 255;
		} else if (blue > 0 && red == 255 && green == 0) {
			blue -= stepSize;
			if (blue < 0) {
				blue = 0;
			}
		}

		return newColour;
	}
}
