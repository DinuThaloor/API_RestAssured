package crudOperationUsingFramework;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.JavaUtility;

import POJO_Classes.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest 
{
@Test
public void updateProject()
{
	JavaUtility jLib=new JavaUtility();
	ProjectLibrary pLib=new ProjectLibrary("Raj", "beml"+jLib.getRandomNumber(), "completed", 3);
	
	given()
	     .pathParam("pId", "TY_PROJ_2204")
	     .contentType(ContentType.JSON).body(pLib)
	.when()     
	      .put(IConstants.baseURI+EndPointsLibrary.updateProject+"{pId}")
	.then()
	     .assertThat()
	     .contentType(ContentType.JSON).statusCode(200).log().all();
}
}
