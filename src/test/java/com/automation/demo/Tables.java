package com.automation.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 


public class Tables {

	public static void main(String[] args) throws InterruptedException {

		WebDriver chrome = new ChromeDriver();
		chrome.get("https://testautomationpractice.blogspot.com/");
		
		Thread.sleep(1000);
		
		int sum = 0;
		List<WebElement> rows = chrome.findElements(By.xpath("//table[@name='BookTable']//tr")); 
		for(int i = 2; i<=rows.size(); i++) {  
			String bookName = chrome.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
			String price = chrome.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			sum = sum + (Integer.parseInt(price));

			   

			if(bookName.equals("Master In Selenium")) {
				String author = chrome.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
				System.out.println("Master In Selenium author is: " + author); 
			}
		}
		
		System.out.println("Total price of this table is: " + sum);
		
		
		Thread.sleep(1000); 
		
	}

}
