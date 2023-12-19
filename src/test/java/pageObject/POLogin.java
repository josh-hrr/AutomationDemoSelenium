package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POLogin extends POBasePage {  
	public POLogin(WebDriver driver){
		super(driver);
	}
	
	@FindBy(css="input[data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy(css="input[data-qa='login-password']")
	WebElement loginPassword;
	
	@FindBy(css="button[data-qa='login-button']")
	WebElement loginButton;
	
	public void inputEmail(String email) {
		loginEmail.sendKeys(email);
	} 
	public void inputPassword(String password) {
		loginPassword.sendKeys(password);
	} 
	public void clickLogin() {
		loginButton.click();
	}
	
	
}
