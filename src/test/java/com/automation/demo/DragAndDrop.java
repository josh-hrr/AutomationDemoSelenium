package com.automation.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver chrome = new ChromeDriver();
		
		chrome.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		Thread.sleep(1000);  
		
		WebElement rome = chrome.findElement(By.id("box6"));
		WebElement italy = chrome.findElement(By.id("box106"));
		
		
		Actions act = new Actions(chrome);
		act.dragAndDrop(rome, italy).build().perform();
		
		
		
		// getLocation to see how much to move the slider
		//  acti.dragAndDropBy(sliderElement, x, y)
		
		
	}
}
