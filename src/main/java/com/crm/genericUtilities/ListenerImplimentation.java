package com.crm.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation extends BaseClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
	test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result)
	{
	test.log(Status.PASS, result.getMethod().getMethodName());
	test.log(Status.PASS, result.getThrowable());
	
	}
//screenshot on failed test script
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getMethod().getMethodName());
		try {
			String screenShot=wLib.takeScreenshot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenShot);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
//		String testName=result.getMethod().getMethodName();
//		System.out.println("-----------i am listening-------");
//		
//		TakesScreenshot takesScreenshot=(TakesScreenshot)BaseClass.sdriver;
//		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
//		LocalDateTime localDateTime=LocalDateTime.now();
//		String dateTime=localDateTime.toString().replace(" ","_").replace(":","_");
//		File dest=new File("./screenshots/"+"_"+testName+"_"+dateTime+".PNG");
//		try
//		{
//			FileUtils.copyFile(src, dest);
//		}
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//			System.out.println("problem in saving screenshot"+e.getMessage());
//		}
	}

	public void onTestSkipped(ITestResult result)
	{
	test.log(Status.SKIP, result.getMethod().getMethodName());
	test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context)
	{
	ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("./ExtentReport/report1.html");
	extentSparkReporter.config().setTheme(Theme.DARK);
	extentSparkReporter.config().setReportName("Dinu");
	extentSparkReporter.config().setDocumentTitle("extent report 1");
	
	report=new ExtentReports();
	report.attachReporter(extentSparkReporter);
	report.setSystemInfo("PlatformName", "Window10");
	report.setSystemInfo("doc created by","Hemanth");
	report.setSystemInfo("report verified by","Dinu");
	
	}

	public void onFinish(ITestContext context)
	{
		report.flush();
	}

}
