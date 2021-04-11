package day1Task1;
import java.util.Scanner;

public class EmpSalary {
	public static void main(String[] args) {
		double basicSalary, HRA, DA, MonthlySalary, AnnualSalary, Tax=0, TotalAnnualSalary;
		System.out.println("Enter the basic salary of an employee");
		Scanner sc = new Scanner(System.in);
		basicSalary = sc.nextDouble();
		HRA = (basicSalary*40)/100;
		DA =  ((HRA+basicSalary)*60/100);
		System.out.println("HRA is : " + HRA + "\nDA is : " + DA);
		AnnualSalary = (basicSalary+HRA+DA)*12;
		System.out.println("The Annual Salary before tax included is : " + AnnualSalary);
		if(AnnualSalary<200000)
		{
			Tax = 0;
			System.out.println("Annual Salary after Tax = "+Tax);
		}
		else if(AnnualSalary >= 200000 && AnnualSalary <= 600000)
		{
			Tax  = AnnualSalary-((AnnualSalary*10)/100);
		}
		else if(AnnualSalary > 600000)
		{
			Tax = AnnualSalary-((AnnualSalary*20)/100);
			System.out.println("AnnualSalary after Tax = "+Tax);
		}
		
	}
}

