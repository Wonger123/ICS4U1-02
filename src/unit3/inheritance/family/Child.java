package unit3.inheritance.family;

class Child extends Parent {
	//int height = 25; //this is SHADOWING the parent variable
	
	Child() {
		hair = "blue";
		toes = 2;
		height = 25; //this is the correct way to change height
	}
	
	Child(int t){
		this(); //This runs the constructor that matches ()
		toes = t;
	}
	@Override
	void fish() {
		System.out.println("uses a net");
	}
	
	//a new method that is not in Parent class
	void sleep() {
		System.out.println("child object is sleeping");
	}
	
	//Attempt to print parent's hair colour (and fail).
	void parent_hair() {
		System.out.println(super.hair);
	}
}