package LAB5;
import java.util.Scanner;

public class ValidateAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age");
		int n = sc.nextInt();
		ValidateException v = new ValidateException();
		try {
			v.doValidate(n);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
