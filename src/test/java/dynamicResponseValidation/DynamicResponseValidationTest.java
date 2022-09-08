package dynamicResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest 
{
@Test
public void dynamicResponseValidation()
{
	String expData="TY_PROJ_835";
	baseURI="http://localhost";
	port=8084;
	
Response resp=when().get("/projects");

boolean flag=false;

List<String> PID = resp.jsonPath().get("projectId");
for(String projectID:PID)
{
	if(projectID.equalsIgnoreCase(expData))
	{
		flag=true;
	}
}
Assert.assertTrue(flag);
System.out.println("data  verified");
resp.then().log().all();
}
}
