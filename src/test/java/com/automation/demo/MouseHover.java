package com.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {


		WebDriver chrome = new ChromeDriver(); 
		chrome.get("https://demo.opencart.com/"); 
		chrome.manage().window().maximize();
		
		Thread.sleep(1000);
		
		WebElement desktopOption = chrome.findElement(By.cssSelector("ul li a[href=\"https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=20\"]:nth-child(1)"));
		WebElement macOption = chrome.findElement(By.cssSelector("ul li a[href=\"https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=20_27\"]"));
		
		Actions act = new Actions(chrome); 
		act.moveToElement(desktopOption).moveToElement(macOption).click().build().perform();
	}

}
