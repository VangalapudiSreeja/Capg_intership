package com.capg.app.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.capg.app.beans.Instructor;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.exception.InstructorNotFoundException;

public class InstructorDAOImpl implements InstructorDAO {
	Connection con;
	PreparedStatement ps;
	
	public InstructorDAOImpl(){
		
		con = DatabaseUtil.con; // no need to create Util Class for all users/ one shared class
	}

	@Override
	public boolean insertInstructor(Instructor instructor)throws SQLException {
		
		boolean isInserted = false;
		
		int code = instructor.getInstructorCode();
		String name = instructor.getName();
		String email = instructor.getEmail();
		String location = instructor.getTrainerLocation();
		int salary = instructor.getSalary();
		int jobStartYear = instructor.getJobStartYear();
		
		
		String query = "insert into Instructor values(?,?,?,?,?,?)";
		
		ps = con.prepareStatement(query);
		ps.setInt(1, code);
		ps.setString(2,name);
		ps.setInt(3, salary);
		ps.setInt(4, jobStartYear);
		ps.setString(5,email);
		ps.setString(6,location);
		
		int i = ps.executeUpdate();
		
		if(i == 1) isInserted = true;
		
		return isInserted;
	}

	@Override
	public Instructor getInstructorByCode(int c) throws InstructorNotFoundException, SQLException {
		
		String sql = "select * from instructor where instructorcode = ?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, c);
		
		ResultSet rs = ps.executeQuery();
		List<Instructor> l = new ArrayList<>();
		
		while(rs.next())
		{
			int code = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("location");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");
			
		
			return new Instructor(code, name, salary, jobStartYear, email, location);
			
		}
		
		
		return null;
	}

	@Override
	public List<Instructor> getInstructors() throws SQLException {
		
		
		String sqlQuery = "select * from instructor";
		ps = con.prepareStatement(sqlQuery);
		
		ResultSet rs = ps.executeQuery();
		List<Instructor> list = new ArrayList<>();
		
		while(rs.next())
		{
			int code = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("location");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");
			
		
			list.add(new Instructor(code, name, salary, jobStartYear, email, location));
			
		}
		return list;
	}

	public List<Instructor> getInstructorsByLocation(String loc) throws SQLException {
		String sql = "select * from instructor where location = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, loc);
		
		ResultSet rs = ps.executeQuery();
		List<Instructor> l = new ArrayList<>();
		
		while(rs.next()) {
			int code = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("location");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");
			
		
			l.add(new Instructor(code, name, salary, jobStartYear, email, location));
			
		}		
		
		return l;	
		
	}

	@Override
	public List<InstructorsLocationCountDTO> getInstructorsCountByLocation() throws SQLException {
		String sql = "select location, count(instructorcode) as count from instructor group by location";
		List<InstructorsLocationCountDTO> l = new ArrayList<>();
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			InstructorsLocationCountDTO obj = new InstructorsLocationCountDTO();
			obj.setLocation(rs.getString("location"));
			obj.setCount(rs.getInt("count"));
			
			l.add(obj);
		}
		return l;
	}

	@Override
	public List<Instructor> getInstructorsBySalary(int s) throws SQLException {
		String sql = "select * from instructor where salary = ?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, s);
		
		ResultSet rs = ps.executeQuery();
		List<Instructor> l = new ArrayList<>();
		
		while(rs.next()) {
			int code = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("location");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");
			
		
			l.add(new Instructor(code, name, salary, jobStartYear, email, location));
			
		}	
		Collections.sort(l);
		/*for(Instructor i : l) {
			System.out.println(i);
		}*/
		return l;	
	}

	@Override
	public boolean delteInstructorByCode(int code) throws InstructorNotFoundException, SQLException {
		String sql = "delete from instructor where instructorcode = ?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, code);
		ResultSet rs = ps.executeQuery();
		return rs!=null ;
	}

	@Override
	public Instructor updateInstructor(Instructor oldInfoInstructor) throws InstructorNotFoundException, SQLException {
		String sql = "update instructor set salary = ? where instructorcode = ?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, oldInfoInstructor.getSalary());
		ps.setLong(2, oldInfoInstructor.getInstructorCode());
		ResultSet rs = ps.executeQuery();
		Instructor i = getInstructorByCode(oldInfoInstructor.getInstructorCode());
		return i;
	}

}
