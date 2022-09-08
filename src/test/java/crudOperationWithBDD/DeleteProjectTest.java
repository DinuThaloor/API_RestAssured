package crudOperationWithBDD;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest 
{
@Test
public void deleteProject()
{
	when()
	      .delete("http://localhost:8084/projects/TY_PROJ_840")
	      .then().assertThat().contentType(ContentType.JSON).statusCode(204).log().all();
}
}
