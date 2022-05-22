package unit3.inheritance.family;

abstract class Ancestor {

	String hair = "purple";
	
	void fish() {
		System.out.println("fish whisperer");
	}
	
	//all descendents must be able to swim
	abstract void swim();
}