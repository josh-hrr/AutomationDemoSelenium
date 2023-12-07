package com.automation.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		WebDriver chrome = new ChromeDriver();
		
		chrome.get("https://www.globalsqa.com/demo-site/datepicker/");
		
		Thread.sleep(2000);  
		WebElement iframe = chrome.findElement(By.cssSelector(".demo-frame.lazyloaded"));
		chrome.switchTo().frame(iframe);
		
		//approach #1, use send keys
		//chrome.findElement(By.cssSelector("#datepicker")).sendKeys("10/15/2024");   		
		
		//aproach #2
		WebElement dateInput = chrome.findElement(By.cssSelector("#datepicker"));   		
		Thread.sleep(1000);   
		dateInput.click();  
		Thread.sleep(1000);  
		
		String month = "December";
		String year = "2024";
		String day = "24";
		
		while(true) {
			String mon = chrome.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.print(mon);
			String yr = chrome.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			System.out.print(yr);
			
			if(mon.equals(month) && yr.equals(year)) {
				break;
			}
			chrome.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> allDates = chrome.findElements(By.cssSelector(".ui-datepicker-calendar tbody tr td"));
		
		for(WebElement myDate : allDates) {
			if(myDate.getText().equals(day)) {
				myDate.click();
				break;
			}
		} 
	}
}
