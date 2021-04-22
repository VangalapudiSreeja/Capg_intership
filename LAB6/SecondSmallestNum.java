package LAB6;

import java.util.Scanner;

public class SecondSmallestNum {
	
	public static void main(String args[]){  
		Scanner sc = new Scanner(System.in);
		int n;
        System.out.println("Enter number of elements in array:");
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }  
		System.out.println("Second smallest: "+getSecondSmallest(a,n));    
	}  
	public static int getSecondSmallest(int[] a, int total){  
		int temp;  
		for (int i = 0; i < total; i++)   
		{  
			for (int j = i + 1; j < total; j++)   
		    {  
				if (a[i] > a[j])   
		        {  
					temp = a[i];  
		            a[i] = a[j];  
		            a[j] = temp;  
		        }  
		    }  
		 }  
		 return a[1]; 
	}   
	

}
