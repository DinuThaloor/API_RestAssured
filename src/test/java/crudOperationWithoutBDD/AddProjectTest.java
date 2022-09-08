package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest
{
	@Test
	public void create()
	{
		//json body created
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Dinu");
		jobj.put("projectName", "BGMI");
		jobj.put("status", "created");
		jobj.put("teamSize", "5");
		//precondition(body and content type)
		RequestSpecification reqspec=RestAssured.given();
		reqspec.body(jobj);
		reqspec.contentType(ContentType.JSON);
		//(action)validation
		Response response=reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse validate=response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();

	}

}
