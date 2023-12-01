package com.automation.demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver chrome = new ChromeDriver();
		chrome.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states");
		WebDriverWait chromeWait = new WebDriverWait(chrome, Duration.ofSeconds(10));  
		WebElement dropdownElement = chromeWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='country-list']")));
		
		// 1) select an option from the dropdown
		Select dropdownElementToSelect = new Select(dropdownElement);
		dropdownElementToSelect.selectByVisibleText("USA");
		
		Thread.sleep(5000);

		// 2) read total options and select 
		List<WebElement> options = dropdownElementToSelect.getOptions();
		
		for(int i = 0; i<options.size(); i++) {
			if(options.get(i).getText().equals("India")) {
				options.get(i).click();
			}
		}
		
		
		
		
		
		
	}

}
