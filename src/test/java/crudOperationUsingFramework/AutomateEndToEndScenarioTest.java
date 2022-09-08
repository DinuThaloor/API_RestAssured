package crudOperationUsingFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericUtilities.DataBaseUtility;
import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.FileUtility;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.WebDriverUtility;
import com.mysql.jdbc.Driver;

import POJO_Classes.ProjectLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AutomateEndToEndScenarioTest
{
	public WebDriver driver;
	//create a project using api then capture id from response validate in gui using selenium then validate the same in database
	//delte the same in api validate in gui then validate in database
	@Test
	public void automateEndToEndScenario() throws IOException, SQLException
	{
		//create a project using api and capture project id
		JavaUtility jLib=new JavaUtility();
		ProjectLibrary pLib=new ProjectLibrary("Divya", "thaichi "+jLib.getRandomNumber(), "in progress", 30);

		Response response=given()
				.contentType(ContentType.JSON)
				.body(pLib)
				.when()
				.post(IConstants.baseURI+EndPointsLibrary.createProject);
		String proId=response.jsonPath().getString("projectId");
		System.out.println(proId);
		response.then().log().all();

		//validate that project created using api
		given()
		.pathParam("pId", proId)
		.when()
		.get("http://localhost:8084/projects/{pId}")
		.then().assertThat().statusCode(200).log().all();

		//validate project in gui
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");

		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		wLib.waitTillPageGetsLoad(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.id("usernmae")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> projectIdElement = driver.findElements(By.xpath("//td[1]"));

		boolean temp=true;
		int projectCount=0;
		for(WebElement projectId:projectIdElement)
		{
			String project = projectId.getText();	
			if(project.equalsIgnoreCase(proId))
			{
				temp=false;
				break;
			}
			projectCount++;
		}
		if(temp==false)
		{
			System.out.println("project is prestent in GUI");
		}
		else
		{
			System.out.println("project is not present in GUI");
		}
		System.out.println(projectCount);
		driver.close();

		//verify in database
		
	DataBaseUtility dLib=new DataBaseUtility();
	dLib.connectToDB();
	String query="select * from project";
	dLib.executeQuery(query, 1, proId);
	dLib.closeDB();
	
	//delete in API
	when()
	      .delete(IConstants.baseURI+EndPointsLibrary.deleteProject+proId)
	  .then()
	        .assertThat().statusCode(204).log().all();
	
	//verify in GUI
	if (BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	wLib.waitTillPageGetsLoad(driver);
	driver.get(URL);
	driver.manage().window().maximize();
	driver.findElement(By.id("usernmae")).sendKeys(USERNAME);
	driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	List<WebElement> projectIdElement1 = driver.findElements(By.xpath("//td[1]"));

	boolean temp1=true;
	int projectCount1=0;
	for(WebElement projectId1:projectIdElement1)
	{
		String project1 = projectId1.getText();	
		if(project1.equalsIgnoreCase(proId))
		{
			temp=false;
			break;
		}
		projectCount++;
	}
	if(temp==false)
	{
		System.out.println("project is deleted in GUI");
	}
	else
	{
		System.out.println("project is not deleted in GUI");
	}
	System.out.println(projectCount);
	driver.close();
	
	//verify in the database
	
	dLib.connectToDB();
	String query1="select * from project";
	dLib.executeQuery(query1, 1, proId);
	dLib.closeDB();
	
	      
	}
}
