package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeSpouse;
import pojoClassForSerializationAndDeserialization.Spouse;

public class SpouseSerialization
{
public static void main(String[] args) throws Throwable, Throwable, Throwable
{	
	Spouse spouse=new Spouse("rach","rach@gmail.com","bengaluru",645723);
	EmployeeSpouse employeeSpouse=new EmployeeSpouse("sachin","tyss53","sach@gmail.com",6576425,spouse);
	ObjectMapper  objectMapper=new ObjectMapper();
	objectMapper.writeValue(new File("./spouse.json"),employeeSpouse);
}
}
