package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeArray;

public class EmployeeSerializationArray
{
public static void main(String[] args) throws Throwable, Throwable, Throwable 
{
	String[] empEmail= {"dinu@gmail.com","hem@gmail.com"};
	int[] empPhNo= {64787346,874657};
	EmployeeArray employeeArray=new EmployeeArray("Dinu","tyss564",empEmail,empPhNo);
	ObjectMapper objectMapper=new ObjectMapper();
	objectMapper.writeValue(new File("./employeeArray.json"), employeeArray);
}
}
