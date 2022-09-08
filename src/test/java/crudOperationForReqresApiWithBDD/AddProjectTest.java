package crudOperationForReqresApiWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class AddProjectTest 
{
	@Test
	public void create()
	{
	//json body created
		JSONObject jobj=new JSONObject();
		jobj.put("name", "Sanjay");
		jobj.put("job", "trainer");

		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.post("https://reqres.in/api/users")
		.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();

	}
}
