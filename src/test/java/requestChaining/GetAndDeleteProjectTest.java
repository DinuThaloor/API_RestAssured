package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAndDeleteProjectTest 
{
	@Test
	public void getAndDeleteTest()
	{
		Response response=given().contentType(ContentType.JSON)
				.when()
				.get("http://localhost:8084/projects");

		String proId=response.jsonPath().getString("[4].projectId");
		System.out.println(proId);
		response.then().log().all();
		
		given()
		.pathParam("pId", proId)
		.when()
		.delete("http://localhost:8084/projects/{pId}")
		.then().assertThat().statusCode(204).log().all();

	}
}
