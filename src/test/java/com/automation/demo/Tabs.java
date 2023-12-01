package com.automation.demo;

import java.time.Duration; 
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tabs {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver chrome = new ChromeDriver();
		WebDriverWait myWait = new WebDriverWait(chrome, Duration.ofSeconds(10));
		String originalTabHandle = chrome.getWindowHandle();	
		chrome.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		WebElement newTabLink = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-text a[href='http://www.orangehrm.com']")));
		newTabLink.click();  
		Thread.sleep(1000); 
		Set<String> windowHandles = chrome.getWindowHandles();    
		int index = 0; 
		for(String handle : windowHandles) {  
			index++;  
			chrome.switchTo().window(handle);
			Thread.sleep(1000);
		}  
		Thread.sleep(1000); 
		chrome.switchTo().window(originalTabHandle);  
	}
}
