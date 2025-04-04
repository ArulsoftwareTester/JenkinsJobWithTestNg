package sanitarytesting;

import java.util.logging.Level;

import org.junit.Assert;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;

	@BeforeClass
	private void m1() {
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		chromeOptions.setCapability(ChromeOptions.LOGGING_PREFS, logPrefs);
		chromeOptions.addArguments("--start-maximized,--headless=new");


		driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.selenium.dev");

		LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		
		System.out.println("Selenium");
		Assert.assertFalse(logEntries.getAll().isEmpty());
		driver.close();

	}

	@Test
	private void m2() {

		driver.get("https://www.facebook.com/");

	}

	@Test
	private void m3() {
		System.out.println("Arulmani");
	}

}
