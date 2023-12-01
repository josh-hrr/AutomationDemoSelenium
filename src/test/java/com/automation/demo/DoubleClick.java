package com.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver chrome = new ChromeDriver();
		
		chrome.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		
		Thread.sleep(1000);
		 
		chrome.switchTo().frame("iframeResult"); 

		WebElement btn = chrome.findElement(By.tagName("button"));
		
		Actions act = new Actions(chrome);
		act.doubleClick(btn).build().perform();
	}
}
