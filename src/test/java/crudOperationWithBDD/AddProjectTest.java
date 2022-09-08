package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest 
{
	@Test
	public void create()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "vedik");
		jobj.put("projectName", "GPR");
		jobj.put("status", "completed");
		jobj.put("teamSize", 7);

		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.post("http://localhost:8084/addProject")
		.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();

	}
}
