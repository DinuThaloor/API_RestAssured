package differentWaysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectUsingHAshMapTest 
{
@Test
public void addProject()
{
	JavaUtility jLib=new JavaUtility();
	baseURI="http://localhost";
	port=8084;
	HashMap hashMap=new HashMap();
	hashMap.put("createdBy", "Verma");
	hashMap.put("projectName","FIFA"+jLib.getRandomNumber());
	hashMap.put("status", "created");
	hashMap.put("teamSize", 15);
	
	given()
	      .body(hashMap)
	      .contentType(ContentType.JSON)
	      
    .when()
	      .post("/addProject")
	.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();      
	      
}
}
