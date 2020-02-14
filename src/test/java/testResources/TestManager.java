package testResources;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import utils.DataReader;
import utils.ExtentManager;
import pages.HomePage;
import resources.Common;
import resources.DriverSource;
import utils.Reporting;
import com.aventstack.extentreports.model.Log;

public class TestManager extends DriverSource {
	
			WebDriver chromedriver;
			
			public static ExtentReports extent;
			//public static ExtentReports report = new ExtentReports();
			public ExtentTest logger;
			File extentConfigFile = new File("./classes/extent-config.xml");
			DataReader reader = new DataReader();
			
			
			@BeforeSuite
			public void onStart(ITestContext context) {
				extent = ExtentManager.createInstance("extent.html");
				ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
				htmlReporter.config().setEncoding("utf-10");
				htmlReporter.config().setReportName("Automation Report");
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				
				
				
			}
			
			
			
	
	@BeforeTest
	public void verifyLogin() throws Exception {
			chromedriver=getDriverInstance();
			
			getDriverInstance().get(reader.getData("WebUrl"));
			getDriverInstance().manage().window().maximize();
			WebDriverWait signInWait = new WebDriverWait(getDriverInstance(),190);
			WebElement element = signInWait.until(ExpectedConditions.visibilityOfElementLocated(reader.getLocator("signIn")));
					
			element.click();
			Thread.sleep(2000);
			element = signInWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailId")));
			
		    //element = getDriverInstance().findElement(By.id("emailId"));
			element.sendKeys(Common.email);
			element = getDriverInstance().findElement(By.id("password"));
			element.sendKeys(Common.password);
			Thread.sleep(3000);
			element = getDriverInstance().findElement(By.xpath(Common.submitDetails));
			element.click();
			Thread.sleep(3000);
		//	assertTrue(getDriverInstance().getPageSource().contains(Common.logText));
			
			}
	@BeforeTest
	public void createLogger() {
		
	}

	public void nameTest(String Test) {
		ExtentReports report = new ExtentReports();
		logger = report.createTest(Test);
	}

//	@Test
//	public void testExtent() throws IOException, InterruptedException {
//		TakesScreenshot ts = (TakesScreenshot)getDriverInstance();
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots"+".png";
//		File finalDestination = new File(destination);
//		Files.copy(source, finalDestination);
//	}
    
	
	//The Below method is a listener method for TestNG tests
	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws IOException, Exception {
		if (result.getStatus() == ITestResult.FAILURE)
		{ result.getThrowable();
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		logger.fail("snapshot"+logger.addScreenCaptureFromPath(reader.getData("resultPath")));}
		
		else if (result.getStatus() == ITestResult.SKIP)
		{   result.getThrowable();
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		logger.skip("snapshot"+logger.addScreenCaptureFromPath(reader.getData("resultPath")));}

		else
		{result.getThrowable();
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		logger.pass("snapshot"+logger.addScreenCaptureFromPath(reader.getData("resultPath")));}



	}

	@AfterSuite
	public void sendReport() {
		extent.flush();
	}
	
	
	
	
	
	
	

	
	
	
	}
	
