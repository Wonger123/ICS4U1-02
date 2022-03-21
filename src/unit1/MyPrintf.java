package unit1;

public class MyPrintf {

	public static void main(String[] args) {
		
		//1.
		System.out.printf("x = %.5f%n%n",1.0/7);
		
		//2.
		String name = "Bessy";
		String colour = "brown";
		int weight = 1200;
		System.out.printf("The cow's name is %s, she is %s and weighs %d kg.%n%n",name,colour,weight);
		
		//3.
		int xx = 2022;
		System.out.println("| 12345678 |");
		System.out.println("| ======== |");
		System.out.printf("| %8d |%n", xx);
		System.out.printf("| %08d |%n", xx);
		System.out.printf("| %+8d |%n", xx);
		System.out.printf("| %-8d |%n", xx);
		System.out.printf("| %8.1f |%n", (double)xx);
	}
}
