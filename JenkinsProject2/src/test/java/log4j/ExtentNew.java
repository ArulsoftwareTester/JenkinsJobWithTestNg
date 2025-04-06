package log4j;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.BaseReportClass;

public class ExtentNew extends BaseReportClass {
	WebDriver driver;
	ExtentReports extent = new ExtentReports();
	public static ExtentTest test;

	@BeforeClass
	private void before() {
		String reportFolderPath = System.getProperty("user.dir") + "\\Reports\\";
		File directory = new File(reportFolderPath);

		if (!directory.exists()) {
			directory.mkdirs();
		}

		File file = new File(reportFolderPath + "\\arul.html");
		ExtentSparkReporter report = new ExtentSparkReporter(file);

		report.config().setReportName("AutomationResults");
		report.config().setDocumentTitle("TestResults");

		extent.attachReporter(report);
		extent.setSystemInfo("Automation", "Arulmani");

		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "OrangeHRM");
		extent.setSystemInfo("Tester", "Hitendra");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");

	}

	@Test
	private void reports() throws Throwable {
		test = extent.createTest("reports");

		driver = initilazeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		String pathString = BaseReportClass.takeScreenshot("PageIsloaded");

		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(pathString).build());

		driver.findElement(By.id("email")).sendKeys("Arul");
		Thread.sleep(3000);
		test.log(Status.INFO,
				MediaEntityBuilder.createScreenCaptureFromBase64String(pathString, "value enterd").build());

		driver.findElement(By.id("pass")).sendKeys("mani");
		// driver.findElement(By.name("login")).click();
		extent.flush();

	}

}
