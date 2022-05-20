/* Andrew Wong
 * May.20.22
 * 
 * Information about the ball object for TestMain.java
 */
package unit4.graphicsTest;

class Ball {
	
	int x;
	int y;
	int width = 50;
	int height = 50;
	int vx; // horizontal velocity
	
	Ball(int a, int b, int c) {
		x = a;
		y = b;
		vx = c;
	}
	
	void move() {
		x += vx;
		
		// moving left --> right
		if (this.x > TestMain.WINW && vx > 0) {
			x = 0;
		}
		// moving right --> left
		if (this.x + width < 0 && vx < 0) {
			x = TestMain.WINW;
		}
	}
}