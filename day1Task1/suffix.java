package day1Task1;
import java.util.Scanner;

public class suffix {
	public static void main(String[] args) {
		int date;
		System.out.println("Enter date");
		Scanner sc =  new Scanner(System.in);
		date=sc.nextInt();
		if(date>31)
		{
			System.out.println("Date is Invalid");
		}
		else
		{
			switch(date%10)
			{
			case 1:
				System.out.println("Date after suffix : " + date + "st");
				break;
			case 2:
				System.out.println("Date after suffix : " + date + "nd");
				break;
			case 3:
				System.out.println("Date after suffix : " + date + "rd");
				break;
			default:
				System.out.println("Date after suffix : " + date + "th");
			}
		}
	}
}
