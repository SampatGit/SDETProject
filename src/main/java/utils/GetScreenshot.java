package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.google.common.io.Files;

public class GetScreenshot {

	
	public static String capture(WebDriver driver, String name) throws IOException {
		String fileName = new SimpleDateFormat("MMddHHmm'.png'").format(new Date());
		String Screenshots = "C:\\Users\\Admin\\eclipse-workspace\\SDETProject-master\\SDETProject-master\\Screenshots\\"+fileName;
		String dest = System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";
		TakesScreenshot scrcaptr = (TakesScreenshot)driver;
		File srcfile = scrcaptr.getScreenshotAs(OutputType.FILE);
		File destfile = new File(dest);
		Files.copy(srcfile, destfile);
		return	 dest;
	}
}
