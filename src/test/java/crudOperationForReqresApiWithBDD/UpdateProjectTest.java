package crudOperationForReqresApiWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("name", "arvind");
		jobj.put("job", "watchman");
		
		given().body(jobj).contentType(ContentType.JSON)
		.when().put("https://reqres.in/api/users/2")
		.then().assertThat().contentType(ContentType.JSON).statusCode(200).log().all();
	}
}
