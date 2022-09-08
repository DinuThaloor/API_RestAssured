package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TimeValidatrionForReadProjectsTest 
{
@Test
public void readProjects()
{
	baseURI="http://localhost";
	port=8084;
	when().get("/projects")
	.then().assertThat()
	.time(Matchers.greaterThan(200L),TimeUnit.MILLISECONDS);
	}
}