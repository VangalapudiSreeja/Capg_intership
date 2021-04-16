package LAB3;
import java.util.Scanner;
import java.time.*;


public class DateDuration {
	public static void main(String[] args) {
 	   System.out.println("enter date in the format of yyyy mm dd");
 	   Scanner sc=new Scanner(System.in);
 	   int y=sc.nextInt();
 	   int m=sc.nextInt();
 	   int d=sc.nextInt();
        LocalDate givendate = LocalDate.of(y, m, d);
        LocalDate presentdate = LocalDate.now();
        sc.close();
        Period diff = Period.between(givendate, presentdate);
        System.out.printf("Difference is"+diff.getYears()+" years"+diff.getMonths()+" months "+diff.getDays()+"days");
	    
	}

}
