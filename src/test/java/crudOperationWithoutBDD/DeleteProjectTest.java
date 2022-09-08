package crudOperationWithoutBDD;

import org.apache.commons.lang3.Validate;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProjectTest 
{
	@Test
	public void delete()
	{
		RequestSpecification reqspec=RestAssured.given();
		Response response=reqspec.delete("http://localhost:8084/projects/TY_PROJ_841");
		ValidatableResponse validate=response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(204);
		validate.log().all();
	}
}
