package pojoClassForSerializationAndDeserialization;

public class EmployeeArray 
{
	String empName;
	String empId;
	String[] empMail;
	int[] empPhoNo;
	public EmployeeArray(String empName, String empId, String[] empMail, int[] empPhoNo) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empMail = empMail;
		this.empPhoNo = empPhoNo;
	}
	public EmployeeArray()
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
	public String[] getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String[] empMail) {
		this.empMail = empMail;
	}
	public int[] getEmpPhoNo() {
		return empPhoNo;
	}
	public void setEmpPhoNo(int[] empPhoNo) {
		this.empPhoNo = empPhoNo;
	}
}
