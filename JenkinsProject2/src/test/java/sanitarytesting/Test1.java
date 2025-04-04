package sanitarytesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	@BeforeClass
	private void m1() {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		
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
