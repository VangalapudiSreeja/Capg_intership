package com.cg.eis.pl;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.*;

public class MainUI {

	static Scanner sc;
	EmployeeService empService;

	public MainUI() {
		empService = new EmployeeServiceImpl();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		MainUI obj = new MainUI();
		while(true) {
			System.out.println("0.To Exit\n1.To Insert Employee Data\n2.To Display All Employee\n3.To Display Salary in Range\n"
					+ "4.get Employee By Id\n5.get All Employee Scheme\n6.Delete Employee By Id\n7.Employee Salary");
			int n = Integer.parseInt(sc.nextLine());
			switch(n) {
			case 0: System.exit(0);
			break;
			case 1: obj.insertEmployeeInforamtion();
			break;
			case 2: obj.displayAllEmployee();
			break;
			case 3: obj.displaySalaryRangeEmployee();
			break;
			case 4: obj.getEmployeeById();
			break;
			case 5: obj.getAllEmployeeByScheme();
			break;
			case 6: obj.deleteEmployee();
			break;
			case 7: obj.employeeSalary();
			break;

			}
		}
		
	}
	
	private void employeeSalary() {
		System.out.println("Enter the salary of the employee");
		Collection<Employee> empList = empService.getAllEmployees();
		int p = Integer.parseInt(sc.nextLine());
		for (Employee employee : empList) {
			if(employee.getSalary() == p) {
				displayEmployee(employee);
			}
		}
	}

	public void insertEmployeeInforamtion() 
	{
		System.out.println(" \n Enter Employee Information to insert data\n");
		
		System.out.println(" Enter Employee Name ");
		String empName = sc.nextLine();
		
		System.out.println(" Enter Employee Id ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Employee Salary ");
		int salary = Integer.parseInt(sc.nextLine());
		
		Employee e = new Employee(empName, id, salary);
		
		try
		{
			boolean isInserted = empService.insertEmployee(e);
			
			// -----
		}
		catch(Exception excep)
		{
			
			System.out.println(" Contact HR "+excep);
		}
		
		
	}
	
	public void displayAllEmployee()
	{
		System.out.println("\n=========== Employees Information ===========\n");
		Collection<Employee> empList = empService.getAllEmployees();
		
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	

	private void displaySalaryRangeEmployee() {
		System.out.println("Enter the range of salaries");
		int l = Integer.parseInt(sc.nextLine());
		int u = Integer.parseInt(sc.nextLine());
		System.out.println("\n=========== Employees Information in range of salary===========\n");
		Collection<Employee> empList = empService.getAllEmployees();
		
		for (Employee employee : empList) {
			if(employee.getSalary() > l && employee.getSalary() < u) {
				displayEmployee(employee);
			}
		}
	}
	
	public void getEmployeeById() {
		System.out.println("Enter the Id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("\n=========== Employees Information in wrt Id===========\n");
		Collection<Employee> empList = empService.getAllEmployees();
		int f=0;
		for (Employee employee : empList) {
			if(employee.getId() == id ) {
				f=1;
				displayEmployee(employee);
			}
		}
		if(f==0) System.out.println("Employee Id not found");
		
	}
	

	public void deleteEmployee() {
		System.out.println("Enter the Id to delete: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("\n===========  Employees Information after deleting wrt Id===========\n");
		List<Employee> empList = empService.deleteEmployee(id);
				
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	
	public void getAllEmployeeByScheme() {
		System.out.println("\n=========== Employees Insurance Information ===========\n");
		Collection<Employee> empList = empService.getAllEmployees();
		
		for (Employee e : empList) {
			System.out.println(" Name "+e.getEmpName());
			System.out.println(" ID "+e.getId());
			System.out.println(" Salary "+e.getSalary());
			System.out.println(" Designation "+e.getDesignation());
			System.out.println(" InsuranceScheme "+e.getInsuranceScheme());
			System.out.println("\n---------------------------------------------\n");
		}
	}
	
	public void displayEmployee(Employee e)
	{
		System.out.println(" Name "+e.getEmpName());
		System.out.println(" ID "+e.getId());
		System.out.println(" Salary "+e.getSalary());
		System.out.println("\n---------------------------------------------\n");
		
		
	}
}