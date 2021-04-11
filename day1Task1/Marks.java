package day1Task1;
import java.util.Scanner;

public class Marks {
	public static void main(String[] args) {
		int EnglishMarks, java, db, springTools;
		float TotalMarks, AvgMarks;
		Scanner sc =  new Scanner(System.in);
		EnglishMarks = sc.nextInt();
		java = sc.nextInt();
		db = sc.nextInt();
		springTools = sc.nextInt();
		TotalMarks =  EnglishMarks+java+db+springTools;
		AvgMarks = TotalMarks/4;
		System.out.println("TotalMarks = "+TotalMarks);
		System.out.println("AvgMarks = "+AvgMarks);
	}

}
