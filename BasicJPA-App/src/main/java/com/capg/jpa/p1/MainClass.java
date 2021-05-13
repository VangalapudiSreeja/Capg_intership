package com.capg.jpa.p1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
public static void main(String[] args) {
		
	MainClass obj = new MainClass();
	
	Configuration cfg = new Configuration();
	SessionFactory fac = cfg.configure().buildSessionFactory();
	Session session = fac.openSession();
	
	Student std1 = obj.getStudents(); 
	Student std2 = obj.getStudents(); 
	
	Course course1 = obj.getCourse(); 
	Course course2 = obj.getCourse();
	
	///----- Creating collections----
	
	List<Course> courseList1 = new ArrayList<Course>();
	courseList1.add(course1);
	courseList1.add(course2);
	
	
	List<Course> courseList2 = new ArrayList<Course>();
	courseList2.add(course1);
	courseList2.add(course2);
	
	// -------- Creating collections for  Student to Course ---------
	
	List<Student> student1 = new ArrayList<Student>();
	student1.add(std1);
	student1.add(std2);
	
	List<Student> student2 = new ArrayList<Student>();
	student2.add(std1);
	student2.add(std2);
	
	
	
	
	// ------------ Adding Collection of Course to student ----- 
	
	std1.setCourseList(courseList1);
	std2.setCourseList(courseList1);
	
			
	// ------------ Adding Collection of Student to Course ----- 
			
	course1.setStudents(student1);
	course2.setStudents(student1);
	
			
			
	Transaction t = session.beginTransaction();
	
	
	session.save(std1);
	session.save(std2);

	
	session.save(course1);
	session.save(course2);
	
	t.commit();
	
	System.out.println(" Data Saved");
	
	session.close();

}

public Student getStudents() {
	Student std = new Student();
	System.out.println("Enter Student  Name ");
	std.setStudent(new Scanner(System.in).nextLine());
	System.out.println("Enter USN");
	std.setUsn(new Scanner(System.in).nextInt());
	
	return std;
}

public Course getCourse()
{
	Course course = new Course();
	System.out.println("Enter Course Name ");
	course.setCourseName(new Scanner(System.in).nextLine());
	System.out.println("Enter Course ID ");
	course.setCourse_id(new Scanner(System.in).nextInt());
	return course;
}

}
