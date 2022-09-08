package crudOperationForReqresApiWithBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadAllProjectsTest 
{
	@Test
	public void readProject()
	{
		when()
		.get("https://reqres.in/api/users?page=2")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
