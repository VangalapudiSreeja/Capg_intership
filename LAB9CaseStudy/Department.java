package LAB9CaseStudy;

public class Department {
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	
	public Department(Integer departmentId, String departmentName, Integer managerId) {
		super();
		// TODO Auto-generated constructor stub
		
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	

}
