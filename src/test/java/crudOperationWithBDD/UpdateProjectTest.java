package crudOperationWithBDD;

import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Vedik subbaih");
		jobj.put("projectName", "GRP PRO");
		jobj.put("status", "completed");
		jobj.put("teamSize", "20");
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.put("http://localhost:8084/projects/TY_PROJ_1603")
		.then().assertThat().contentType(ContentType.JSON).statusCode(200).log().all();

	}
}
