package com.crm.genericUtilities;

import io.restassured.response.Response;
/**
 * this class consists of rest assured specific reusable methods
 * @author dinuh
 *
 */
public class RestAssuredLibrary 
{
	/**
	 * this method will get the json data through json path from response body
	 * @param response
	 * @param path
	 * @return
	 */
public String getJsonData(Response response,String path)
{
	String jsonData=response.jsonPath().get(path);
	return jsonData;
}
}
