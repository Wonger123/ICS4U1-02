/* Andrew Wong
 * Apr.7.22
 * 
 * This is the Main class which calls upon specific methods in the
 * Elevator.java file.
 */
package unit3;

public class ElevTest {

	public static void main(String[] args) {
		
		Elevator south = new Elevator(1, 0, "South");
		Elevator east = new Elevator(5, 0, "East");
		
		System.out.println("1. Have 10 people get on south at the ground floor");
		south.openDoors();
		south.addPeople(10);
		System.out.println(south);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("2. 3 get out on floor 4 and the rest get out on the top floor");
		south.closeDoors();
		south.goToFloor(4);
		south.openDoors();
		south.removePeople(3);
		System.out.println(south + "\n");
		
		south.closeDoors();
		south.goToFloor(19);
		south.openDoors();
		south.removePeople(7);
		System.out.println(south);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("3. Have 8 get into east on the 5th floor");
		east.openDoors();
		east.addPeople(8);
		System.out.println(east);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("4. Try and add 30 more on the 8th floor");
		east.closeDoors();
		east.goToFloor(8);
		east.openDoors();
		east.addPeople(30);
		System.out.println(east);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("5. Try to go above the top floor");
		east.closeDoors();
		east.goToFloor(20);
		System.out.println(east);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("6. Try to go to a negative floor");
		east.goToFloor(-1);
		System.out.println(east);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("7. Move both elevators to the second floor");
		south.closeDoors();
		south.goToFloor(2);
		east.goToFloor(2);
		System.out.println(south + "\n");
		System.out.println(east);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("8. Open the doors on east");
		east.openDoors();
		System.out.println(east);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("9. Have a power failure");
		Elevator.setPowerState(false);
		System.out.println(Elevator.getPowerState());
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("10. Then test to make sure that your elevators can't move or close or open doors");
		south.openDoors();
		south.closeDoors();
		south.up();
		System.out.println(south + "\n");
		east.openDoors();
		east.closeDoors();
		east.up();
		System.out.println(east);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("11. Restore the power (you should see a message)");
		Elevator.setPowerState(true);
		System.out.println("Power On: " + Elevator.getPowerState());
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("12. Restore the power again (no message, the power is already on)");
		Elevator.setPowerState(true);
		System.out.println("Power On: " + Elevator.getPowerState());
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("13. Make elevator south move up one floor at a time from the ground floor to floor 10, stopping on each floor and opening and closing doors");
		south.goToFloor(1);
		for (int i = 0; i < 10; i++) {
			south.openDoors();
			south.closeDoors();
			System.out.println(south + "\n");
			south.up();
		}
	}
}