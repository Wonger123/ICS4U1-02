package unit3;

public class ElevTest {

	public static void main(String[] args) {
		
		Elevator south = new Elevator(1, 0, true, 0, 0);
		Elevator east = new Elevator(1, 0, true, 0, 0);
	
		System.out.println("Have 10 people get on south at the ground floor");
		
		System.out.println("3 get out on floor 4 and the rest get out on the top floor");
		
		System.out.println("Have 8 get into east on the 5th floor");

		System.out.println("Try and add 30 more on the 8th floor");

		System.out.println("Try to go above the top floor");

		System.out.println("Try to go to a negative floor");

		System.out.println("Move both elevators to the second floor");

		System.out.println("Open the doors on east");

		System.out.println("Have a power failure");
		
		System.out.println("Then test to make sure that your elevators can't move or close or open doors");
		
		System.out.println("Restore the power (you should see a message)");

		System.out.println("Restore the power again (no message, the power is already on)");

		System.out.println("Make elevator south move up one floor at a time from the ground floor to floor 10, stopping on each floor and opening and closing doors");

	}
}