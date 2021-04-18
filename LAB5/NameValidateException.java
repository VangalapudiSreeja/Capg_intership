package LAB5;

public class NameValidateException {
	public void doValidateName(String n) throws NameException{
		String a[] = n.split(" ");
		if(a.length == 2) {
			for(String s:a) {
				if(s.equals("")) {
					throw new NameException("Invalid Name Format");
				}else {
					System.out.print(s+" ");
				}
			}
		}else {
			throw new NameException("Invalid Name Format");
		}
	}

}
