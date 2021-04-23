package com.cg.eis.service;

import java.util.Collection;
import java.util.List;
import com.cg.eis.bean.Employee;
import java.util.List;

public interface EmployeeService {
	
	public boolean insertEmployee(Employee e);
	public Collection<Employee> getAllEmployees();
	public Collection<Employee> getAllEmployeesBySalary(int range1,int range2);
	public Employee getEmployeeById(int id);
	public List<Employee> deleteEmployee(int id);
	
	public Collection<Employee> getAllEmployeeInsuranceScheme();
}
