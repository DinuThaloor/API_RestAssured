package pojoClassForSerializationAndDeserialization;

public class Employee {
	String empName;
	String empId;
	String empEmail;
	int empPhNo;
	public Employee(String empName, String empId, String empEmail, int empPhNo) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empEmail = empEmail;
		this.empPhNo = empPhNo;
	}
	public Employee()
	{
		
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public int getEmpPhNo() {
		return empPhNo;
	}
	public void setEmpPhNo(int empPhNo) {
		this.empPhNo = empPhNo;
	}
}
