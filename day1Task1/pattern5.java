package day1Task1;
import java.util.Scanner;
public class pattern5 {
	
	public static void main(String[] args)  
	{  
		Scanner sc = new Scanner(System.in);  
		System.out.println("Enter the number of rows : ");  
		int rows = sc.nextInt(); 
		int i,k,j;
		for (i=1;i<= rows; i++)   
		{  
			for (j = rows; j > i ; j--)   
			{  
				System.out.print(" ");  
			}  
			System.out.print("*");  
			for (k = 1; k < 2*(i -1) ;k++)    
				System.out.print(" ");     
			if( i==1)     
				System.out.println("");  
			else  
				System.out.println("*");   
		}   
		for (i=rows-1; i>= 1 ; i--)  
		{  
			for (j = rows; j > i ; j--)   
			{  
				System.out.print(" ");  
			}  
			System.out.print("*");  
			for (k = 1; k < 2*(i -1) ;k++)   
			{  
				System.out.print(" ");  
			}  
			if(i==1)  
				System.out.println("");  
			else  
				System.out.println("*");  
		}  

	}

}
