package swaggerPetStoreAssignment;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest 
{
@Test
public void getAllProjects()
{
	when()
	   .get("https://petstore.swagger.io/v2/store/inventory")
	   .then()
	   	.assertThat()
	   	.statusCode(200)
	   	.log().all();
}
}
