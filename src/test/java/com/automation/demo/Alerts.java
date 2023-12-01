package com.automation.demo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) throws InterruptedException { 

		WebDriver chrome = new ChromeDriver(); 
		WebDriverWait myWait = new WebDriverWait(chrome, Duration.ofSeconds(10));
		chrome.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1) alert accept
		WebElement alertAccept = chrome.findElement(By.xpath("//*[text()='Click for JS Alert']"));
		alertAccept.click();
		Alert alertWindow = myWait.until(ExpectedConditions.alertIsPresent());
		
		Thread.sleep(5000); 
		alertWindow.accept();  
		Thread.sleep(5000);
		
		//2) alert accept and cancel
		WebElement alertAcceptAndCancel = chrome.findElement(By.xpath("//*[contains(text(), 'Click for JS Confirm')]"));
		alertAcceptAndCancel.click();
		Alert alertWindowTwo = myWait.until(ExpectedConditions.alertIsPresent());
		
		Thread.sleep(5000);
		alertWindowTwo.dismiss();
		Thread.sleep(5000);
		
		//3) alert accept and cancel with input
		WebElement alertAcceptAndCancelWithInput = chrome.findElement(By.xpath("//*[contains(text(), 'Click for JS Prompt')]"));
		alertAcceptAndCancelWithInput.click();
 		Alert alertThree = chrome.switchTo().alert();
 		Thread.sleep(5000);
 		alertThree.sendKeys("Welcome test");  
 		Thread.sleep(5000); 
 		alertThree.accept();
 		Thread.sleep(5000); 
 		
 		//4) alert - login
 		chrome.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
