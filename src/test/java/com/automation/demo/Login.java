package com.automation.demo; 
import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 public class Login {

	public static void main(String[] args) throws InterruptedException { 
		WebDriver chrome = new ChromeDriver(); 
		chrome.manage().window().maximize();
		WebDriverWait myWait = new WebDriverWait(chrome, Duration.ofSeconds(10));

		chrome.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement usernameElement = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameElement.sendKeys("Admin");
		
		chrome.findElement(By.name("password")).sendKeys("admin123");
		chrome.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		
		String tabTitle = chrome.getTitle();
		if(tabTitle.equals("OrangeHRM")) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		
		chrome.close();
	}  
}
