package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseReportClass {

	static WebDriver driver = null;

	public WebDriver initilazeDriver() {
		driver = new ChromeDriver();
		return driver;

	}

	public static String takeScreenshot(String screenShotName) {

		String screenShotFolderPath = System.getProperty("user.dir") + "\\ScreenShot\\";
		File directory = new File(screenShotFolderPath);

		if (!directory.exists()) {
			directory.mkdirs();
		}

		String destination = screenShotFolderPath + screenShotName + ".png";

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(destination);

		try {
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		    return base64Screenshot;

	}
}
