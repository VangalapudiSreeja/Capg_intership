package LAB9;

import java.util.Scanner;
import java.util.function.BiFunction;

public class UsernamePassword {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String u_name = sc.next();
		System.out.println("Enter Password");
		String pass= sc.next();

		BiFunction<String,String,Boolean>validate= (str1,str2) -> {
			if (str1.equals("Sreeja") && str2.equals("1234"))
				return true;
			return false;
		};
		if (validate.apply(u_name,pass))
			System.out.println("Valid credentials");
		else
			System.out.println("Invalid credentials");
	}

}
