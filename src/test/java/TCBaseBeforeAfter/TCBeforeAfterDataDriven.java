package TCBaseBeforeAfter;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TCBeforeAfterDataDriven {
	public WebDriver driver;
	public Logger logger;
	public ResourceBundle resource;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) { 
		
		resource = ResourceBundle.getBundle("config");    
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}  
		driver.get(resource.getString("appUrl"));  
	}
	 
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}  
}
