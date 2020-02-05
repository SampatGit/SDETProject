package utils;

import java.io.File;


import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.CopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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


public class Reporting extends DriverSource {

	private static ExtentReports extent;
	private static ThreadLocal parentTest = new ThreadLocal();
	private static ThreadLocal test1 = new ThreadLocal();
	String Screenshots = "C:\\Users\\Admin\\eclipse-workspace\\SDETProject-master\\SDETProject-master\\test-output\\Screenshots";

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}

	@BeforeClass
	public synchronized void beforeClass() {
		ExtentTest parent = extent.createTest(getClass().getName());
		parentTest.set(parent);
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());
		test1.set(child);
	}

	@Test
	public void testExtent() throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot)getDriverInstance();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+".png";
		File finalDestination = new File(destination);
		Files.copy(source, finalDestination);
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
			((ExtentTest) test1.get()).fail(result.getThrowable());
		else if (result.getStatus() == ITestResult.SKIP)
			((ExtentTest) test1.get()).skip(result.getThrowable());
		else
			((ExtentTest) test1.get()).pass("Test passed");

		extent.flush();

	}
	public void screenCapture(WebDriver driver) throws IOException {
        TakesScreenshot scrcaptr = (TakesScreenshot)driver;
        File srcfile = scrcaptr.getScreenshotAs(OutputType.FILE);
        File destfile = new File(Screenshots);
        Files.copy(srcfile, destfile);
	}
}


