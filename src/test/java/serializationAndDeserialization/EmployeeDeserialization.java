package serializationAndDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class EmployeeDeserialization
{
public static void main(String[] args) throws Throwable, Throwable, Throwable 
{
	//create an object for object mapper
	ObjectMapper objectMapper=new ObjectMapper();
	//use the readvalue method to read from json file
	Employee employee=objectMapper.readValue(new File("./employee.json"), Employee.class);
	System.out.println(employee.getEmpName());
	System.out.println(employee.getEmpId());
	System.out.println(employee.getEmpEmail());
	System.out.println(employee.getEmpPhNo());
}

}
