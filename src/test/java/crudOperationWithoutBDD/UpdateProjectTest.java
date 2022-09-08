package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest
{
	@Test
	public void update()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "DinuHemanth");
		jobj.put("projectName", "BGMI INDIA");
		jobj.put("status", "updated");
		jobj.put("teamSize", 10);

		RequestSpecification reqspec=RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);

		Response response=reqspec.put("http://localhost:8084/projects/TY_PROJ_1402");
		ValidatableResponse validate=response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
