package TCBaseBeforeAfter;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass; 

public class TCBaseBeforeAfter {
	
	public WebDriver chrome;
	
	@BeforeClass
	public void setup() { 
		chrome = new ChromeDriver();
 		chrome.get("https://automationexercise.com/"); 
	}
	 
	@AfterClass
	public void tearDown() {
		chrome.quit();
	}  
}
