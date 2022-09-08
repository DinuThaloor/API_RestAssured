package crudOperationUsingFramework;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest 
{
@Test
public void deleteProject()
{
given()
      .pathParam("pId", "TY_PROJ_2204")
.when()
      .delete(IConstants.baseURI+EndPointsLibrary.deleteProject+"{pId}")
 .then()
     .assertThat().contentType(ContentType.JSON).statusCode(204).log().all();
}
}
