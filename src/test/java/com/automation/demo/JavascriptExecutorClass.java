package com.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorClass {
	public static void main(String[] args) throws InterruptedException {
		//Element interceptable exception
		WebDriver chrome = new ChromeDriver();
		chrome.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(1000);
		
		WebElement inputUsername = chrome.findElement(By.cssSelector("input[name='username']")); 
		
		Thread.sleep(1000);
		
		WebElement inputPassword = chrome.findElement(By.cssSelector("input[name='password']")); 
		
		Thread.sleep(1000);
		
		WebElement buttonElement = chrome.findElement(By.cssSelector("button[type='submit']"));
		
		Thread.sleep(1000);
		
		//adding a new value input
		JavascriptExecutor js = (JavascriptExecutor) chrome;
		js.executeScript("arguments[0].setAttribute('value', 'Admin')", inputUsername); 
		
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].setAttribute('value', 'admin123')", inputPassword);
		
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].setAttribute('target', '_blank')", buttonElement);
		
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click()", buttonElement); 
		
		Thread.sleep(1000);    
	}
}
