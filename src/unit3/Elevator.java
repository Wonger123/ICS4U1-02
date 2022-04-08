package unit3;

public class Elevator {

	// class level variables
	static final String MANUFACTURER = "Otis";
	static final int TOP_FLOOR = 19;
	static final int MAX_OCCUPANTS = 25;
	static boolean powerOn = true;

	// object level variables
	private String name;
	private int floor = 1;
	private int people = 0;
	private boolean doorsOpen = false;

	// constructor
	Elevator(int elevFloor, int elevPeople, String elevName) {
		floor = elevFloor;
		people = elevPeople;
		name = elevName;
	}

	public static void setPowerState(boolean powerOn) {
		if (!Elevator.powerOn) {
			System.out.println("Power is on.");
		}
		Elevator.powerOn = powerOn;

	}
	
	static boolean getPowerState() {	
		return Elevator.powerOn;
	}

	// instance methods
	void up() {
		// power is on, doors are closed, don't go above top floor
		if (Elevator.powerOn) {
			if (!doorsOpen) {
				if (floor < TOP_FLOOR) {
					floor++;
				}
				else {
					System.out.println("The elevator is already at the top floor.");
				}
			}
			else {
				System.out.println("The elevator doors must be closed first.");
			}
		}
		else {
			System.out.println("The power must be on to use the elevator.");
		}
	}

	void down() {
		// power is on, doors are closed, don't go below bottom floor
		if (Elevator.powerOn) {
			if (!doorsOpen) {
				if (floor > 0) {
					floor++;
				}
				else {
					System.out.println("The elevator is already at the lowest floor.");
				}
			}
			else {
				System.out.println("The elevator doors must be closed first.");
			}
		}
		else {
			System.out.println("The power must be on to use the elevator.");
		}
	}

	void goToFloor(int n) {
		// power is on, doors are closed, don't go above top floor or below bottom floor
		if (Elevator.powerOn) {
			if (!doorsOpen) {
				if (n >= 1 && n <= TOP_FLOOR) {
					floor = n;
				}
				else {
					System.out.println("You cannot go to that floor.");
				}
			}
			else {
				System.out.println("The elevator doors must be closed first.");
			}
		}
		else {
			System.out.println("The power must be on to use the elevator.");
		}
	}
	
	void openDoors() {
		// power is on
		if (Elevator.powerOn) {
			if (!doorsOpen) {
				doorsOpen = true;
			}
			else {
				System.out.println("Elevator doors are already open.");
			}
		}
		else {
			System.out.println("Power must be on to open doors.");
		}
	}
	
	void closeDoors() {
		// power is on
		if (Elevator.powerOn) {
			if (doorsOpen) {
				doorsOpen = false;
			}
			else {
				System.out.println("Elevator doors are already closed.");
			}
		}
		else {
			System.out.println("Power must be on to close doors.");
		}
	}
	
	void addPeople(int peopleAdded) {
		// doors are open, don't go above max occupancy, peopleAdded is positive
		if (doorsOpen) {
			if (peopleAdded > 0) {
				if (people + peopleAdded < MAX_OCCUPANTS) {
					people += peopleAdded;
				}
				else {
					int peopleRemaining = (people + peopleAdded) - MAX_OCCUPANTS;
					people = MAX_OCCUPANTS;
					System.out.println("Elevator full, " + peopleRemaining + " people could not get on the elevator.");
				}
			}
			else {
				System.out.println("You cannot add negative people.");
			}
		}
		else {
			System.out.println("The elevator doors must be opened first.");
		}
	}
	
	void removePeople(int peopleRemoved) {
		// doors are open, don't go below 0, peopleRemoved is positive
		if (doorsOpen) {
			if (peopleRemoved > 0) {
				if (people - peopleRemoved >= 0) {
					people -= peopleRemoved;
				}
				else {
					System.out.println("You cannot remove more than the current number of people in the elevator.");
				}
			}
			else {
				System.out.println("You cannot remove negative people.");
			}
		}
		else {
			System.out.println("The elevator doors must be opened first.");
		}
	}
	
	@Override
	public String toString() {
		String s = String.format("Elevtor: %s%nCurrent Floor: %d%nPower On: %b%nCurrent Capacity: %d%nDoors Open: %s", name, floor, powerOn, people, doorsOpen);
		return s;
	}
}