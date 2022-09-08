package requestChaining;

import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassForCrudOperations.PojoClassForAddProject;
import pojoClassForCrudOperations.PojoClassForUpdateProjectTest;

import static io.restassured.RestAssured.*;

public class PostAndUpdateProjectsTest
{
	@Test
	public void postAndUpdateProject()
	{
		JavaUtility jLib=new JavaUtility();

		PojoClassForAddProject pojo=new PojoClassForAddProject("Avinash","swiss"+jLib.getRandomNumber(),"created",16);
		Response response=given().contentType(ContentType.JSON).body(pojo)
				.when()
				.post("http://localhost:8084/addProject");

		String proId=response.jsonPath().get("projectId");
		System.out.println(proId);
		response.then().log().all();
		
		
		PojoClassForUpdateProjectTest  pojou=new PojoClassForUpdateProjectTest("avinash hg", "swiss pro"+jLib.getRandomNumber(), "completed", 16);
		given()
		  .pathParam("pId", proId).contentType(ContentType.JSON).body(pojou)
		  .when()
		      .put("http://localhost:8084/projects/{pId}")
		      .then().assertThat().statusCode(200).log().all();


	}

}
