package differentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectWithJsonObjectTest 
{
	@Test
	public void create()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "mauna");
		jobj.put("projectName", "HBK");
		jobj.put("status", "created");
		jobj.put("teamSize", 8);

		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.post("http://localhost:8084/addProject")
		.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();

	}
}
