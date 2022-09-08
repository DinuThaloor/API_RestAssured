package StaticResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationGetTest
{
@Test
public void staticResponseGet()
{
	String expData="TY_PROJ_002";
	baseURI="http://localhost";
	port=8084;
	
	Response resp=when().get("/projects");
	
	String actData=resp.jsonPath().getString("[1].projectId");
	Assert.assertEquals(actData, expData);
	System.out.println("data verified");
	resp.then().log().all();
	
	
	
			
}
}
