package day1Task1;
import java.util.Scanner;
public class pattern1c {
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter value");
	    n=sc.nextInt();
		int k=1,c=2;
		for (int i=1;i<=n;i++){
			if(i%2!=0){
				for(int j=1;j<=i;j++){
					System.out.print(" "+k);
				k+=2;
				}
			System.out.print("\n");
			}else{
				for (int j=2;j<=i+1;j++){
					System.out.print(" "+c);
				c+=2;
			 }
			 System.out.print("\n");
			 }
		}
	}

}
