package day1Task1;
import java.util.Scanner;
public class pattern3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i, j,k, rows;
		System.out.print("Enter the no. of rows: ");
		rows=sc.nextInt();
		for (i=1; i<= rows ; i++)  
		{  
			for (j = i; j < rows ; j++)   
			{  
				System.out.print(" ");  
			}     
			for (k = 1; k <= (2*i -1) ;k++)   
			{  
				if(k==1 || i == rows || k==(2*i-1))   
				{  
					System.out.print("*");  
				}  
				else   
				{  
					System.out.print(" ");  
				}  
			}  
			System.out.println("");  
		}  
	}
}
