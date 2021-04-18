package LAB5;

public class AgeException extends Exception {
	private String excMsg = "";

	public AgeException() {
		super();
	}

	public AgeException(String message) {
		super(message);
		this.excMsg = message;
	}

	@Override
	public String toString() {
		return "AgeException :- "+excMsg;
	}

}
