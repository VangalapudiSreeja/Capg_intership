package day7Task;

public class EmpCodeException extends Exception {
	
	public EmpCodeException() {
		super();
		System.out.println("Employee Code Exception");
	}

	public EmpCodeException(String string) {
		System.out.println("City code "+string+" not found");
	}

	@Override
	public String toString() {
		return "Exception Occured";
	}

}
