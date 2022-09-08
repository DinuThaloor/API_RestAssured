package swaggerPetStoreAssignment;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectTest 
{
@Test
public void getProject()
{
	given()
	   .pathParam("orderId", 10)
	.when()
	  .get("https://petstore.swagger.io/v2/store/order/{orderId}")
	  .then().assertThat().statusCode(200).log().all();
}
}
