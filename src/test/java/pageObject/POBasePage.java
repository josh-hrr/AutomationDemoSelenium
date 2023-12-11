package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class POBasePage {
	WebDriver chrome; 
	public POBasePage(WebDriver chrome) {
		this.chrome = chrome;
		PageFactory.initElements(chrome, this);
	}
}
