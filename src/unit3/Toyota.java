package unit3;

class Toyota {

	// 1. static variables (and constants)
	// there is only one copy of these
	static String company = "Harwood Car Rentals";
	
	// 2. instance variables (not static)
	// each object gets its OWN COPY of these
	// FINAL = cannot be changed
	final String model;
	//PRIVATE = don't let other classes mess with this variable
	private int odometer;
	String colour = "Blue";
	double fuel = 40.0;	// in Litres
	
	// 3. constructor(s) - create objects
	/*Toyota() {
		// System.out.println("make toyota");
	}*/
	
	Toyota (String m) {
		model = m;
		odometer = 25; // default value, driving from factory
	}
	Toyota (String model, int odometer) {
		this.model = model;
		// use "this" to refer to an instance variable
		this.odometer = odometer;
	}

	// 4.static methods

	// 5. instance methods
	// getters and setters
	int getOdo() {
		return odometer;
	}
	void setOdo(int dod) {
		System.out.println("You criminal! This is forbidden.");
	}
	
	void drive(int km) {
		odometer += Math.abs(km); // do not allow negative km
	}
	
	// this method must return 1 line of text describing the object
	public String toString() {
		String s = String.format("Model=%s. %dkm. Colour: %s", model, odometer, colour);
		return s;
	}
}