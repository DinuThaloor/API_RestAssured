package crudOperationWithoutBDD;

import java.security.PublicKey;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ReadProjectTest 
{
	@Test
	public void read()
	{
		RequestSpecification reqspec=RestAssured.given();
		Response response=reqspec.get("http://localhost:8084/projects/TY_PROJ_1402");
		ValidatableResponse validate=response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}
}

