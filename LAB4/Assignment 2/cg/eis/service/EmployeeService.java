package com.cg.eis.service;

import java.util.Scanner;
import com.cg.eis.bean.Employee;
import com.cg.eis.pl.Services;

public class EmployeeService implements Services {
	Employee e = new Employee();
	Scanner sc = new Scanner(System.in);
	
	public void getInfo() {
		System.out.println("Enter id:");
		e.setId(sc.nextInt());
		System.out.println("Enter name:");
		e.setName(sc.next());
		System.out.println("Enter salary:");
		e.setSalary(sc.nextInt());
		System.out.println("Enter Designation:");
		e.setDesignation(sc.next());
		
	}
	public void insuranceScheme() {
		if(e.getDesignation().equals("Manager") && e.getSalary() > 50000)
		{
			e.setInsuranceScheme("Yearly");
		}
		else if(e.getDesignation().equals("TeamLaeder") && e.getSalary() > 30000)
		{
			e.setInsuranceScheme("6Months");
		} else {
			e.setInsuranceScheme("Monthly");
		}
	}
	public void Details()
	{
		System.out.println("Id of the user: " +e.getId());
		System.out.println("Name of the user: " +e.getName());
		System.out.println("Salary of the user: " +e.getSalary());
		System.out.println("Designation of the user: " +e.getDesignation());
		System.out.println("Insuarance Scheme of the user: " +e.getInsuranceScheme());
	}
}
