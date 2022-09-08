package crudOperationUsingFramework;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.JavaUtility;

import POJO_Classes.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
@Test
public void createProject()
{
	JavaUtility jLib=new JavaUtility();
	ProjectLibrary pLib=new ProjectLibrary("Vivek", "sesco "+jLib.getRandomNumber(), "created", 10);
	
	given()
	     .contentType(ContentType.JSON)
	     .body(pLib)
	 .when()
	     .post(IConstants.baseURI+EndPointsLibrary.createProject)
	 .then()
	      .assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
}
}
