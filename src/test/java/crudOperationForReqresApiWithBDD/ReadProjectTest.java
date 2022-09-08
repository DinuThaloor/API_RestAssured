package crudOperationForReqresApiWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ReadProjectTest 
{
@Test
public void readProject()
{
	when()
	.get("https://reqres.in/api/users/2")
	.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
}
}
