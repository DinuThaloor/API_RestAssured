package requestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForCrudOperations.PojoClassForAddProject;

public class PostAndGetProjectTest 
{
	@Test
	public void postAndGetProject()
	{
		JavaUtility jLib= new JavaUtility();

		PojoClassForAddProject pojo=new PojoClassForAddProject("sumanth","tyco "+jLib.getRandomNumber(),"created",16);
		Response response=given().contentType(ContentType.JSON).body(pojo)
				.when()
				.post("http://localhost:8084/addProject");

		String proId=response.jsonPath().get("projectId");
		System.out.println(proId);
		response.then().log().all();

		given()
		.pathParam("pId", proId)
		.when()
		.get("http://localhost:8084/projects/{pId}")
		.then().assertThat().statusCode(200).log().all();

	}
}
