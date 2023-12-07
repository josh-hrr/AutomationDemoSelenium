package pageObject;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver chrome;
	
	public LoginPage(WebDriver chrome){
		this.chrome = chrome;
		PageFactory.initElements(chrome, this);
	}
	
	//locators
	
	@FindBy(css="img[alt='company-branding']") 
	WebElement img_logo;
	
	@FindBy(css="input[name='username']") 
	WebElement txt_username;
	
	@FindBy(css="input[name='password']") 
	WebElement txt_password;
	
	@FindBy(css="button[type='submit'") 
	WebElement btn_submit; 
	
	//Action methods
	public void setUserName(String username) {
		txt_username.sendKeys(username);
	}
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	public void clickSubmit() {
		btn_submit.click();
	}
	public boolean checkLogoPresence() {
		boolean status = img_logo.isDisplayed();
		return status;
	} 
}
