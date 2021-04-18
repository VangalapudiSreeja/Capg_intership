package LAB5;
import java.util.Scanner;

public class UserName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String n = sc.nextLine();
		NameValidateException ne = new NameValidateException();
		try {
			ne.doValidateName(n);
		} catch (NameException e) {
			System.out.println(e);
		}

	}


}
