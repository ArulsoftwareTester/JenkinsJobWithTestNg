package org.tcs.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
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
}
