package com.crm.genericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass
{
DataBaseUtility dLib=new DataBaseUtility();
JavaUtility jLib=new JavaUtility();

@BeforeSuite

public void dbConfig() 
{
	dLib.connectToDB();
	baseURI="http://localhost";
	port=8084;
	
}


@AfterSuite
public void closedbConnection()
{
	dLib.closeDB();
}
}
