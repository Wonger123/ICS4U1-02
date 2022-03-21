package unit1;

public class Grades {

	public static void main(String[] args) {
	
		for (int mark = 0; mark < 100; mark += 5) {
			calc(mark);
			System.out.println(mark + " = " + calc(mark));
		}
	}
		
	static String calc(int mark) {
		
		String grade = "";
		
		if (mark < 50) grade = "F";
		else if (mark < 60) grade = "D";
		else if (mark < 70) grade = "C";
		else if (mark < 80) grade = "B";
		else if (mark < 90) grade = "A";
		else if (mark >= 90) grade = "A+";
		
		return grade;
	}
}
