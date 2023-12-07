package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class LoginTest {
	
	WebDriver chrome;
	LoginPage login;
	
	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		chrome = new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		chrome.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=1)
	void testLogo() {
		login = new LoginPage(chrome);
		login.checkLogoPresence();
		Assert.assertEquals(login.checkLogoPresence(), true);
	}
	
	@Test(priority=2)
	void testLogin() {
		login.setUserName("Admin");
		login.setPassword("admin123");
		login.clickSubmit();
		Assert.assertEquals(chrome.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		chrome.quit();
	}
}
