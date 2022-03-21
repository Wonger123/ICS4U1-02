package unit3;

public class CarTest {

	public static void main(String[] args) {
		// static variable -- I don't need to make an object
		System.out.println(Toyota.company);

		Toyota car1 = new Toyota("Yarris");
		// car1.model = "Camry"; //final = cannot change
		// car1.odometer = 1000; //private = cannot access from other classes

		Toyota car2 = new Toyota("Corolla", 5000);
		System.out.println(car2.colour);
		System.out.println(car2.toString());

		// car1.company = "Junk-a-car";
		// System.out.println(car2.company);
		
		System.out.println(car2);
		car2.drive(567);
		System.out.println(car2);
		
		if (car2.getOdo() < 100) {
			// double the rental cost because it's a new car
		}
	}
}