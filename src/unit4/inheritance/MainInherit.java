package unit4.inheritance;

public class MainInherit {

	public static void main(String[] args) {
		
		//1. You cannot make an ancestor because it's abstract
		//Ancestor person = new Ancestor();
		 
		Parent p = new Parent();
		System.out.println("-- parent --");
		System.out.println(p.toString());
		p.fish();
		
		//2. Parent has learned the technique of Ancestral fishing
		p.ancientFishing();
		
		//Make two children
		Child sonny = new Child(5);
		Parent sally = new Child();		
		
		System.out.println("\n-- child --");
		System.out.println(sonny.toString());
		System.out.println(sally.toString());
		sonny.fish();
		sally.fish();
		
		sonny.sleep();
		//This does not work because parents can't sleep
		//sally.sleep(); 
		
		Child c = (Child) sally;
		c.sleep(); // all of the child methods are now available
		
		//fake out the system, make the parent a child
		//This will not work.
		//Child c2 = (Child)p;
		//c2.sleep(); 
		
		//This is supposed to print the parent hair colour, but 
		//it doesn't. There is only one hair varible. 
		//The child inherits a copy from the Parent, and the child
		//constructor sets it to blue. 
		c.parent_hair();
		
		System.out.println(c.height);
		c.area();
	}

}