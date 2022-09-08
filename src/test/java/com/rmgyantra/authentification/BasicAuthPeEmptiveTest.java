package com.rmgyantra.authentification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuthPeEmptiveTest
{
@Test
public void basicAuthPeEmptiveTest()
{
	given()
	  .auth().preemptive().basic("rmgyantra", "rmgy@9999")
	  .when()
	    .get("http://localhost:8084/login")
	    .then()
	    .assertThat()
	    .statusCode(202)
	    .log().all();
}
}
