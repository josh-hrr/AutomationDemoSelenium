package com.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {
	public static void main(String[] args) {
		WebDriver chrome = new ChromeDriver();
		
		chrome.get("https://www.worldometers.info/geography/flags-of-the-world/");
		
		
		WebElement flagGuate = chrome.findElement(By.cssSelector("a[href='/img/flags/gt-flag.gif']"));
		
		JavascriptExecutor js = (JavascriptExecutor) chrome; 
		js.executeScript("arguments[0].scrollIntoView();", flagGuate); 
	}
}
