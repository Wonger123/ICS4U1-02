package unit3;

public class Elevator {

	// class level variables
	static String manufacturer = "Otis";
	static int topFloor = 19;
	static int maxOccupants = 25;
	static boolean powerOn = true;

	// object level variables
	int floor = 1;
	int people = 0;
	boolean doorsOpen = false;
	int peopleAdded, peopleRemoved;

	// constructor
	Elevator(int elevFloor, int elevPeople, boolean elevDoorsOpen, int elevPeopleAdded, int elevPeopleRemoved) {
		floor = elevFloor;
		people = elevPeople;
		doorsOpen = elevDoorsOpen;
		peopleAdded = elevPeopleAdded;
		peopleRemoved = elevPeopleRemoved;
	}

	static void setPowerState() {
		powerOn = true;
	}

	// instance methods
	void up() {
		if (powerOn = false) {
			System.out.println("Power not on. Turn power on before using the elevator.");
		}
		if (doorsOpen = true) {
			System.out.println("Please close the doors before using the elevator");
		}
		if (floor < 1 || floor > 19) {
			if (floor < 1) System.out.println("Cannot go lower than floor 1.");
			if (floor > 19) System.out.println("Max floor is 19.");
		}
		else {
			floor++;
		}
	}

	void down() {
		if (powerOn = false) {
			System.out.println("Power not on. Turn power on before using the elevator.");
		}
		if (doorsOpen = true) {
			System.out.println("Please close the doors before using the elevator");
		}
		if (floor < 1 || floor > 19) {
			if (floor < 1) System.out.println("Cannot go lower than floor 1.");
			if (floor > 19) System.out.println("Max floor is 19.");
		}
		else {
			floor--;
		}
	}

	void goToFloor(int n) {
		if (powerOn = false) {
			System.out.println("Power not on. Turn power on before using the elevator.");
		}
		if (doorsOpen = true) {
			System.out.println("Please close the doors before using the elevator");
		}
		if (floor < 1 || floor > 19) {
			if (floor < 1) System.out.println("Cannot go lower than floor 1.");
			if (floor > 19) System.out.println("Max floor is 19.");
		}
		else {
			floor = n;
		}
	}
	
	void openDoors() {
		if (powerOn = false) {
			System.out.println("Power not on. Turn power on before opening the doors.");
		}
		else {
			doorsOpen = true;
		}
	}
	
	void closeDoors() {
		if (powerOn = false) {
			System.out.println("Power not on. Turn power on before closing the doors.");
		}
		else {
			doorsOpen = false;
		}
	}
	
	void addPeople(int peopleAdded) {
		if (doorsOpen = false) {
			System.out.println("Please open doors to enter the elevator.");
		}
		if (people > maxOccupants) {
			System.out.println("Elevator is currently full.");
		}
		if (floor < 1) {
			System.out.println("Elevator cannot be underground");
		}
		else {
			people = people + peopleAdded;
		}
	}
	
	void removePeople(int peopleRemoved) {
		if (doorsOpen = false) {
			System.out.println("Please open doors to enter the elevator.");
		}
		if (people > maxOccupants) {
			System.out.println("Elevator is currently full.");
		}
		if (floor < 1) {
			System.out.println("Elevator cannot be underground");
		}
		else {
			people = people - peopleAdded;
		}
	}
	
	public String toString() {
		String s = String.format("Current floor: %d%nCurrent capacity: %d%nDoors open: %s", floor, people, doorsOpen);
		return s;
	}
}