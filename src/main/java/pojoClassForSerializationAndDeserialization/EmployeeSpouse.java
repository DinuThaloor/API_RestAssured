package pojoClassForSerializationAndDeserialization;

public class EmployeeSpouse 
{
	String empName;
	String empId;
	String empEmail;
	int empPhoNo;
	Object spouse;
	public EmployeeSpouse(String empName, String empId, String empEmail, int empPhoNo, Object spouse) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empEmail = empEmail;
		this.empPhoNo = empPhoNo;
		this.spouse=spouse;
	}
	public EmployeeSpouse()
	{
		
	}
	public String getEmpName() {
		return empName;
	}
	public Object getSpouse() {
		return spouse;
	}
	public void setSpouse(Object spouse) {
		this.spouse = spouse;
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
	public int getEmpPhoNo() {
		return empPhoNo;
	}
	public void setEmpPhoNo(int empPhoNo) {
		this.empPhoNo = empPhoNo;
	}
}

