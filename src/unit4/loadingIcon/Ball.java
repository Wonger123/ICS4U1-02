/* Andrew Wong
 * May.11.22
 * 
 * This class contains all the information for each ball in LoadingIcon.java
 */
package unit4.loadingIcon;

class Ball {

	int x;
	int y;
	int width = 50;
	int height = 50;
	int vx; // v = velocity
	int vy; // how many pixels each time it moves

	Ball(int a, int b, int c, int d) {
		x = a;
		y = b;
		vx = c;
		vy = d;
	}

	void move() {
		x += vx;
		y += vy;

		/** check for bounce **/
		if (this.y < 0) { // top
			vy *= -1;
		}
		if (y + width > LoadingIcon.WINH) { // bottom
			vy *= -1;
		}
		if (this.x < 0) { // left side
			vx *= -1;
		}
		if (x + width > LoadingIcon.WINW) { // right side
			vx *= -1;
		}
	}
}