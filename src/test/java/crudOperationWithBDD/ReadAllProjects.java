package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadAllProjects 
{
	@Test
	public void readProjectTest()
	{
		when()
		.get("http://localhost:8084/projects")
		.then().assertThat().contentType(ContentType.JSON).statusCode(200).log().all();
	}
}
