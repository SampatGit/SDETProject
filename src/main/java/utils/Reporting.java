package utils;

import java.io.File;


import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.CopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

import resources.DriverSource;
import testResources.TestManager;


public class Reporting extends TestManager {

	
	//public static ExtentReports report = new ExtentReports();
	File extentConfigFile = new File("./classes/extent-config.xml");
	

//	@Test
//	public void testExtent() throws IOException, InterruptedException {
//		TakesScreenshot ts = (TakesScreenshot)getDriverInstance();
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots"+".png";
//		File finalDestination = new File(destination);
//		Files.copy(source, finalDestination);
//	}

	public String capture(WebDriver driver, String name) throws IOException {
		logger = extent.createTest("Test Case");
		String fileName = new SimpleDateFormat("MMddHHmm'.png'").format(new Date());
		//String Screenshots = "C:\\Users\\Admin\\eclipse-workspace\\SDETProject-master\\SDETProject-master\\Screenshots\\"+fileName;
		//String dest = System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";
		String dest = "C:\\Users\\Admin\\eclipse-workspace\\SDETProject-master\\SDETProject-master\\test-output\\Screenshots"+name+".png";
		TakesScreenshot scrcaptr = (TakesScreenshot)driver;
		File srcfile = scrcaptr.getScreenshotAs(OutputType.FILE);
		logger.log(Status.INFO, name);
		File destfile = new File(dest);
		Files.copy(srcfile, destfile);
		return	 dest;
	}
}


