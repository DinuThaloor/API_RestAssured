package crudOperationUsingFramework;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;

import POJO_Classes.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest 
{
@Test
public void getAllProjects()
{
    when()
         .get(IConstants.baseURI+EndPointsLibrary.getAllProjects)
     .then()
     .assertThat().contentType(ContentType.JSON).statusCode(200).log().all();
}
}
