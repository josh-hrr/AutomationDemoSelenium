package TCBaseBeforeAfter;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters; 

public class TCBaseBeforeAfter {
	
	public WebDriver driver;
	public Logger logger;
	public ResourceBundle resource;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) { 
		
		resource = ResourceBundle.getBundle("config");
		
		logger = LogManager.getLogger(this.getClass()); 
		
		ChromeOptions options = new ChromeOptions();
		String downloadDir = System.getProperty("user.dir") + "\\downloads";
		options.addArguments("download.default_directory=" + downloadDir);
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver(options);
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} 
		driver.manage().deleteAllCookies();
		driver.get(resource.getString("appUrl"));  
	}
	 
	@AfterClass
	public void tearDown() {
		driver.quit();
	}  
	  
	/*
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination; 
	}  
	*/ 
}
