package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeSpouse;
import pojoClassForSerializationAndDeserialization.Spouse;

public class SpouseDeserialization
{
public static void main(String[] args) throws Throwable, Throwable, Throwable 
{
	ObjectMapper objectMapper=new ObjectMapper();
	EmployeeSpouse employeeSpouse=objectMapper.readValue(new File("./spouse.json"), EmployeeSpouse.class);
	System.out.println(employeeSpouse.getEmpName());
	System.out.println(employeeSpouse.getEmpId());
	System.out.println(employeeSpouse.getEmpEmail());
	System.out.println(employeeSpouse.getEmpPhoNo());
	System.out.println(employeeSpouse.getSpouse());
}
}
