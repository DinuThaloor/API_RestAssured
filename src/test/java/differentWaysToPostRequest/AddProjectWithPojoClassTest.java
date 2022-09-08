package differentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClassForCrudOperations.PojoClassForAddProject;

public class AddProjectWithPojoClassTest 
{
@Test
public void createProject()
{
	PojoClassForAddProject obj=new PojoClassForAddProject("vidya", "TRH", "created", 18);
	given()
	       .body(obj).contentType(ContentType.JSON)
	.when()
	       .post("http://localhost:8084/addProject")
   .then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
}
}
