package swaggerPetStoreAssignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest 
{
@Test
public void addProject()
{
	JSONObject jobj=new JSONObject();
	jobj.put("id", 10);
	jobj.put("petId", 17);
	jobj.put("quantity",5);
	jobj.put("shipDate", "2022-09-06T10:58:49.275Z");
	jobj.put("status", "packed");
	jobj.put("complete", true);
	
	given()
	    .contentType(ContentType.JSON).body(jobj)
	    .when()
	       .post("https://petstore.swagger.io/v2/store/order")
	       .then()
	       .assertThat().contentType(ContentType.JSON).statusCode(200).log().all();
	
}

}
