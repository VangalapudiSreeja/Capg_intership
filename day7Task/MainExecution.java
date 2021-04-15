package day7Task;

public class MainExecution {
	
	public static void main(String[] args) {

		EmployeeService service = new EmployeeService();
		
		try {	
			
			String codes[] = service.getEmployeeCodes();
			
			String city[] = service.getEmployeeCity();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		/*for example 
		 *       011 : Delhi 
		 *       022 : Mumbai 
		 *       080 : Banglore
		 *       020 : Pune*/
		
	}//end main

}//end class



