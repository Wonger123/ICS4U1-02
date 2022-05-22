package unit3.inheritance.family;

class Parent extends Ancestor {

	/* NEVER do this. You are creating a new variable 
	that SHADOWs the original one */
	//String hair = "green";
	
	//toes show up here. Ancestor has no toes. 
	//All descendents from here have toes
	int toes = 7; 
	int height = 0;
	
	Parent() {
		hair = "green";		
	}
	
	Parent(int h) {
		hair = "green";
		height = h;
	}
	@Override
	void swim() {
		System.out.println("floating down the river");		
	}
	@Override
	void fish() {
		System.out.println("using a fishing rod");
	}	
	@Override
	public String toString() {
		return String.format("%s hair, %d toes", hair, toes);
	}
	void ancientFishing() {
		super.fish();
	}
	
	//This is to show the problems with shadowing variables.
	//This uses "height". If you create a new "height" variable
	//in Child class, then this returns the wrong value.
	void area() {
		System.out.println(height*height);
	}
}