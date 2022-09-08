package com.rmgyantra.authentification;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2
{
@Test
public void oauth2() 
{
	Response response=given()
	  .formParam("client_id", "BGMI")
	  .formParam("client_secret", "8c0973d76cb7012cd3c0301e1a3fdb76")
	  .formParam("grant_type", "client_credentials")
	  .formParam("redirect_uri", "http:bgmi.com")
	  .formParam("code", "authorization_code")
	  .when()
	       .post("http://coop.apps.symfonycasts.com/token");
	
	String token=response.jsonPath().get("access_token");
	System.out.println(token);
	
	given()
	   .auth().oauth2(token)
	   .pathParam("user_id", 3768)
	   .when()
	   .post("http://coop.apps.symfonycasts.com/api/{user_id}/chickens-feed")
	   .then().assertThat().statusCode(200).log().all();
	   
}
}
