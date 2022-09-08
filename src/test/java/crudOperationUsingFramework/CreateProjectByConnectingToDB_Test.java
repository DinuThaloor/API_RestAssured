package crudOperationUsingFramework;

import org.testng.annotations.Test;

import com.crm.genericUtilities.BaseAPIClass;
import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.JavaUtility;

import POJO_Classes.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectByConnectingToDB_Test extends BaseAPIClass
{
@Test
public void createProject()
{
	JavaUtility jLib=new JavaUtility();
	ProjectLibrary pLib=new ProjectLibrary("Manasa", "Refinitive"+jLib.getRandomNumber(), "ongoing", 8);
	given()
	    .contentType(ContentType.JSON)
	    .body(pLib)
	.when()
	     .post(EndPointsLibrary.createProject)
	 .then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();    
}
}
