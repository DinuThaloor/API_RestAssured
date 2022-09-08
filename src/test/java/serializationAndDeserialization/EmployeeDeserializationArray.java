package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeArray;

public class EmployeeDeserializationArray
{
public static void main(String[] args) throws Throwable, Throwable, Throwable 
{
	ObjectMapper objectMapper=new ObjectMapper();
	EmployeeArray employeeArray=objectMapper.readValue(new File("./employeeArray.json"),EmployeeArray.class);
	System.out.println(employeeArray.getEmpName());
	System.out.println(employeeArray.getEmpId());
	System.out.println(employeeArray.getEmpMail()[0]);
	System.out.println(employeeArray.getEmpMail()[1]);
	System.out.println(employeeArray.getEmpPhoNo()[0]);
	System.out.println(employeeArray.getEmpPhoNo()[1]);
}
}
