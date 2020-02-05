package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.util.Date;

import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import resources.DriverSource;

public class Listener extends DriverSource {

	// Report will generate in Project Directory only.
	// After execution, refresh project directory.
	ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("extent.html");
	ExtentReports reports = new ExtentReports();

	// This is the object of extentTest class, by which log is generate.
	ExtentTest testlog;
	WebDriver driver;
	public static final String imagePath = "C:\\Users\\m1032509\\Documents\\Sampat\\SDET\\Test Results";

	@BeforeTest
	public void logWithScreenshot() throws IOException {

		System.out.println("Start");

		reports.attachReporter(htmlreport);

		// Customize Report property
		htmlreport.config().setReportName("Test Report");
		reports.setSystemInfo("Host Name", "Test Host");
		reports.setSystemInfo("Environment", "Automation Testing");
		reports.setSystemInfo("User Name", "QA Automation");
		htmlreport.config().setDocumentTitle("Automation Report");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);

		// Two default theme of report
		htmlreport.config().setTheme(Theme.STANDARD);
		// htmlreport.config().setTheme(Theme.DARK);

		testlog = reports.createTest("AutomationTest");

	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			testlog.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			testlog.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			File screen = ((TakesScreenshot) getDriverInstance()).getScreenshotAs(OutputType.FILE);
			BufferedImage img = ImageIO.read(screen);
			File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
			ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" + "Test01.png"));
			testlog.info("Details of " + "Test screenshot", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + "Test01.png")
					.build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			// testlog.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			testlog.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			testlog.log(Status.PASS, "snapshot"+testlog.addScreenCaptureFromPath(imagePath));
		}
	}

	@AfterTest
	public void quit() {
		// If flush method did not call, Report will not generate.
		reports.flush();
		//	getDriverInstance().quit();
		System.out.println("End");
	}
}
