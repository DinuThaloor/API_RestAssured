package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClassForCrudOperations.PojoClassForAddProject;

public class AddProjectUsingDataProviderTest 
{
@Test(dataProvider = "getData")
public void createProject(String createdBy,String projectName,String status,int teamSize)
{
	JavaUtility jLib=new JavaUtility();
	PojoClassForAddProject pojo=new PojoClassForAddProject(createdBy,projectName+jLib.getRandomNumber(),status,teamSize);
	baseURI="http://localhost";
	port=8084;
	
	given()
	      .body(pojo)
	      .contentType(ContentType.JSON)
	 .when()
	        .post("/addProject")
	  .then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();             
}
@DataProvider(name="getData")
public Object[][]data()
{
	Object[][] data=new Object[4][4];
	data[0][0]="Dinu";
	data[0][1]="TRH";
	data[0][2]="completed";
	data[0][3]=10;
	
	data[1][0]="HArsha";
	data[1][1]="fesco";
	data[1][2]="created";
	data[1][3]=15;
	
	data[2][0]="Ranju";
	data[2][1]="glama";
	data[2][2]="ongoing";
	data[2][3]=16;
	
	data[3][0]="Killer";
	data[3][1]="betziue";
	data[3][2]="progress";
	data[3][3]=150;
	
	return data;
}			
}
