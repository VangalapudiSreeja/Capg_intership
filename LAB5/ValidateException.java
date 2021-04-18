package LAB5;

public class ValidateException {
	public void doValidate(int age)throws AgeException
	{
		if(age>15)
		{
			 // book the tickets 
			System.out.println("Allowed");
		}
		else
		{
			// raised the exception
			throw new AgeException("Cannot allow age less than 15 and you age is "+age);
		}
		
	}

}
