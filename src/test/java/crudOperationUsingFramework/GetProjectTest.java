package crudOperationUsingFramework;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;

import POJO_Classes.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProjectTest 
{
@Test
public void getProject()
{
	given()
	     .pathParam("pId", "TY_PROJ_2204")
	
.when()
     .get(IConstants.baseURI+EndPointsLibrary.getSingleProject+"{pId}")
     .then()
          .assertThat().contentType(ContentType.JSON).statusCode(200).log().all();
}
}