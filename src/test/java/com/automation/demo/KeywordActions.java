package com.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeywordActions {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver chrome = new ChromeDriver();
		chrome.get("https://text-compare.com/"); 
		Thread.sleep(1000); 
		WebElement sourceElement = chrome.findElement(By.id("inputText1"));
		sourceElement.sendKeys("Welcome");
		
		Thread.sleep(1000); 
		
		WebElement targetElement = chrome.findElement(By.id("inputText2"));
		
		Actions actions = new Actions(chrome);
		actions.moveToElement(sourceElement)
			.keyDown(Keys.CONTROL)
			.sendKeys("a")
			.keyUp(Keys.CONTROL)
			.build()
			.perform();
		
		Thread.sleep(1000);
		
		actions.moveToElement(sourceElement) 
			.keyDown(Keys.CONTROL)
			.sendKeys("c")
			.keyUp(Keys.CONTROL)
			.build()
			.perform();
		
		Thread.sleep(1000);
		
		targetElement.click();
		
		actions.moveToElement(targetElement)
			.keyDown(Keys.CONTROL)
			.sendKeys("v")
			.keyUp(Keys.CONTROL)
			.build()
			.perform();  
	}
}
