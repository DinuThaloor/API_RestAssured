package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class EmployeeSerialization
{
	public static void main(String[] args) throws Throwable
	{
		//create a object for class employee
		Employee employee=new Employee("Hemanth","tyss1994","dinuhemanth@gmail.com",9611496);
		//create a object for object mapper
		ObjectMapper objectMapper=new ObjectMapper();
		//use the write value method to write into the jason file
		objectMapper.writeValue(new File("./employee.json"), employee);

	}
}

