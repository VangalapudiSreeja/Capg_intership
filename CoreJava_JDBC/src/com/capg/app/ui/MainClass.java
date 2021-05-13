package com.capg.app.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capg.app.beans.Instructor;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.exception.InstructorNotFoundException;
import com.capg.app.service.InstructorService;
import com.capg.app.service.InstructorServiceImpl;

public class MainClass {
	
	InstructorService service;
	Scanner sc = new Scanner(System.in);
	
	public MainClass() {
		service = new InstructorServiceImpl();
	}
	
	public static void main(String[] args) throws SQLException, InstructorNotFoundException {
		
		MainClass obj = new MainClass();
		
		while(true)
		{			
			System.out.println("1. Insert");
			System.out.println("2. Show All");
			System.out.println("3. Get By Code");
			System.out.println("4. Get By Location");
			System.out.println("5. Delete By Code");
			System.out.println("6. Get Count By Location");
			System.out.println("7. Get By Salary");
			System.out.println("8. Update Instructor Info");
			System.out.println("0. EXIT");
		
			int opt =new Scanner(System.in).nextInt(); 			
			
			if(opt == 1){
				obj.insertInstructorDetailsFromUser();
			}else if(opt == 2) {
				
				obj.readInstructorDetails();
			}else if(opt == 3) {
				obj.getInstructorByCode();
			}else if(opt == 4) {
				obj.getInstructyorByLocation();
			}else if(opt == 5) {
				obj.deleteInstructorByCode();
			}else if(opt == 6) {
				obj.getInstructorsCountByLocation();
			}else if(opt == 7) {
				obj.getInstructorBySalary();
			}else if(opt==8) {
				obj.updateInstructor();
			}
			else if(opt == 0) {
				System.exit(0);
			}	
		}
			
	}//end main
	
	private void updateInstructor() throws InstructorNotFoundException, SQLException {
		System.out.println("Enter code,name,salary,job start year,email and location to update");
		Instructor instructor = new Instructor(Integer.parseInt(sc.nextLine()), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine());
		Instructor i = service.updateInstructor(instructor);
		if(i!=null) {
			System.out.println("Updated Successfully");
		}else {
			System.out.println("Updation Failed");
		}		
	}

	private void getInstructorBySalary() throws NumberFormatException, SQLException {
		List<Instructor> l = service.getInstructorsBySalary(Integer.parseInt(sc.nextLine()));
		l.stream().forEach(instructor->displayInstructor(instructor));
		
	}

	private void getInstructorsCountByLocation() throws SQLException {
		List<InstructorsLocationCountDTO> l = service.getInstructorsCountByLocation();
		for(InstructorsLocationCountDTO i : l) {
			System.out.println(i);
		}		
	}

	private void deleteInstructorByCode() throws InstructorNotFoundException, SQLException {
		System.out.println("Enter the code: ");
		int c = Integer.parseInt(sc.nextLine());
		if(service.delteInstructorByCode(c)) {
			System.out.println("Deleted Successfully");
		}else {
			System.out.println("Deletion Failed");
		}
		
	}

	private void getInstructyorByLocation() throws SQLException {
		System.out.println("Enter the location: ");
		List<Instructor> l = service.getInstructorsByLocation(sc.nextLine());
		l.stream().forEach(instructor->displayInstructor(instructor));	
	}

	public void getInstructorByCode() throws SQLException {
		System.out.println("Enter the code: ");
		int c = Integer.parseInt(sc.nextLine());
		try {
			Instructor i = service.getInstructorByCode(c);
			if(i!=null) {
				displayInstructor(i);
			}else {
				System.out.println("code not found");
			}
		} catch (InstructorNotFoundException e) {
			System.out.println("code not found");
		}		
	}

	public void insertInstructorDetailsFromUser()
	{
		
		// ... write code to read data hope
		System.out.println("Enter code,name,salary,job start year,email and location");
		Instructor instructor = new Instructor(Integer.parseInt(sc.nextLine()), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine());
		
		try {
			boolean result = service.insertInstructor(instructor);
			
			if(result) System.out.println(" Instructor Added");
			else System.out.println("Contact Admin ...");
		} catch (Exception e) {
			showErr(e);
		}
		
	}
	public void readInstructorDetails()
	{
		
		try
		{
			List<Instructor> list = service.getInstructors() ;
			
			list.stream().forEach(instructor->displayInstructor(instructor));
		}
		catch(Exception e)
		{
			showErr(e);
		}	
	}
	
	public void displayInstructor(Instructor instructor)
	{		
		System.out.println(instructor);
		System.out.println("-------------------------------------------------------");
	}
	public void showErr(Exception e)
	{
		System.out.println("====>> "+e);
	}
}
