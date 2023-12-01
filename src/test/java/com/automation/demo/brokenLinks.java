package com.automation.demo; 
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException { 
		WebDriver chrome = new ChromeDriver();	
		chrome.get("http://www.deadlinkcity.com/");
		
		Thread.sleep(1000);
		
		List<WebElement> anchorTags = chrome.findElements(By.cssSelector("a"));
		int brokenCounter = 0;
		for(WebElement link: anchorTags) {
			String hrefValue = link.getAttribute("href"); 
			URL linkUrl = new URL(hrefValue); 
			HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
			connection.connect(); 
			if(connection.getResponseCode() > 400) {
				System.out.println(link.getText() + "    " + " BROKEN LINK ");
				brokenCounter++;
			}else {
				System.out.println(link.getText() + "    " + " NOT BROKEN LINK ");
			} 
		}
		
	}
}

