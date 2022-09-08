package com.rmgyantra.authentification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenTest 
{
@Test
public void bearerTokenTest()
{
	JSONObject jobj=new JSONObject();
	jobj.put("name", "SDET37RestAssured2");
	given()
	   .auth().oauth2("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")
	   .body(jobj)
	   .contentType(ContentType.JSON)
	   .when()
	     .post("https://api.github.com/user/repos")
	     .then()
	       .assertThat()
	       .statusCode(201)
	       .log().all();
	     
	
}
}
