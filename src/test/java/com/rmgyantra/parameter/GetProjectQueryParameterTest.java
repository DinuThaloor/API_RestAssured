package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectQueryParameterTest 
{
@Test
public void getProjectQueryParameter()
{
	given()
	    .queryParam("page", 2)
	    .when()
	      .get("http://reqres.in/api/users")
	      .then()
	      .assertThat()
	      .statusCode(200)
	      .log()
	      .all();
}
}
