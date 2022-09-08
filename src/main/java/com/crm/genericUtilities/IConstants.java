package com.crm.genericUtilities;

/**
 * 
 * @author dinuh
 *
 */
public interface IConstants 
{
	/**
	 * Here all the variables are static and final in nature by default in interface
	 */

	String filePath="./src/test/resources/rmgyantra.properties";
	String excelPath="./src/test/resources/Sdet37TestData.xlsx";
	String chromeKey="webdriver.chrome.driver";
	String chromeValue="./src/main/resources/chromedriver.exe";
	String firefoxKey="webdriver.gecko.driver";
	String firefoxValue="./src/main/resources/geckodriver.exe";
	String DBUrl="jdbc:mysql://localhost:3306/projects";
	String DBUsername="root";
	String DBPassword="root";
	int implicitlyWaitDuration=10;
	int explicitlyWaitDuration=10;
	
	String appUsername="rmgyantra";
	String appPassword="rmgy@9999";
	String baseURI="http://localhost:8084";
}
