package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectPathParameterTest 
{
@Test
public void getProject()
{
	given()
	    .pathParam("pid", "TY_PROJ_002")
	    .when()
	    .get("http://localhost:8084/projects/{pid}")
	    .then()
	      .assertThat().statusCode(200).log().all();

}
}
