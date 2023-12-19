package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select; 


public class POCreateAcctPageAutoPage extends POBasePage { 
	public POCreateAcctPageAutoPage(WebDriver chrome) { 
		super(chrome);
	}
	
	//locators
	 @FindBy(css="li a[href='/login']")
	 WebElement loginBtn;
	 
	 @FindBy(css=".col-sm-6 h1")
	 WebElement slideShowText;
	 
	 @FindBy(css="input[name='name']")
	 WebElement inputName;
	 
	 @FindBy(css="input[data-qa='signup-email']")
	 WebElement inputEmail;
	 
	 @FindBy(css="button[data-qa='signup-button']")
	 WebElement signupBtn; 
	 
	 @FindBy(css="#id_gender1")
	 WebElement mrRadioBtn;
	 
	 @FindBy(css="input[data-qa='name']")
	 WebElement inputNameInSignup;
	 
	 @FindBy(css="#password")
	 WebElement inputPassword;
	 
	 @FindBy(css="#days")
	 WebElement selectDays;
	 
	 @FindBy(css="#months")
	 WebElement selectMonths;
	 
	 @FindBy(css="#years")
	 WebElement selectYears;
	 
	 @FindBy(css="#newsletter")
	 WebElement checkBoxNewsLetter;
	 
	 @FindBy(css="#optin")
	 WebElement checkBoxOptin;
	 
	 @FindBy(css="input[data-qa='first_name']")
	 WebElement inputFirstName;
	 
	 @FindBy(css="input[data-qa='last_name']")
	 WebElement inputLastName;
	 
	 //fromHere
	 @FindBy(css="#address1")
	 WebElement inputAddress;
	 
	 @FindBy(css="#country")
	 WebElement selectCountry;
	 
	 @FindBy(css="#state")
	 WebElement inputState;
	 
	 @FindBy(css="#city")
	 WebElement inputCity;
	 
	 @FindBy(css="#zipcode")
	 WebElement inputZip;
	 
	 @FindBy(css="#mobile_number")
	 WebElement inputMobile;
	 
	 @FindBy(css="button[data-qa='create-account']")
	 WebElement createAcctBtn;
	 
	 @FindBy(css=".text-center b")
	 WebElement getAcctCreatedText;
	 
	 @FindBy(css="a[data-qa='continue-button']")
	 WebElement continueBtn;
	 
	 @FindBy(css=".navbar-nav a[href='/delete_account']")
	 WebElement deleteAccountBtn; 
	 
	 @FindBy(css=".text-center b")
	 WebElement deleteAcctText;
	 
	 //Action methods
	 public String getSlideShowText() {
		 return slideShowText.getText();
	 }
	 
	 public void clickLoginBtn() {
		 loginBtn.click();
	 }
	 
	 public void setName(String name) {
		 inputName.sendKeys(name);
	 }
	 
	 public void setEmail(String email) {
		 inputEmail.sendKeys(email);
	 }
	 
	 public void clickSignupBtn() {
		 signupBtn.click();
	 }
	 
	 public String getTabTitle() {
		 return chrome.getTitle();
	 }
	 
	 public void clickMrRadioBtn() {
		 mrRadioBtn.click();
	 }
	 
	 public String getInputNameValue() {
		 return inputNameInSignup.getAttribute("value");
	 }
	 
	 public void setPassword(String pass) {
		 inputPassword.sendKeys(pass);
	 }
	 
	 public void setDateOfBirth(String day, String month, String year) {
		 selectDays.click();
		 selectDays.sendKeys(day);
		 selectDays.click();
		 
		 selectMonths.click();
		 selectMonths.sendKeys(month);
		 selectMonths.click();
		 
		 selectYears.click();
		 selectYears.sendKeys(year);
		 selectYears.click();
	 }
	 
	 public void setCheckBoxNewsLetter() {
		 checkBoxNewsLetter.click();
	 }
	 
	 public void setCheckBoxOptin() {
		 checkBoxOptin.click();
	 }
	 
	 public void setAddressInformation(String firstName, String lastName, String address, String country, String state, String city, String zipCode, String mobilePhone) {
		 inputFirstName.sendKeys(firstName);
		 inputLastName.sendKeys(lastName);
		 inputAddress.sendKeys(address);
		 
		 Select countrySelect = new Select(selectCountry); 
		 List<WebElement> countryElements = countrySelect.getOptions();
		 for(WebElement c : countryElements) {
			 if(c.getText().equals(country)) {
				 c.click();
			 }
		 }
		 
		 inputState.sendKeys(state);
		 inputCity.sendKeys(city);
		 inputZip.sendKeys(zipCode);
		 inputMobile.sendKeys(mobilePhone);  
	 }
	 
	 public void clickCreateAccount() {
		 createAcctBtn.click();
	 } 
	 
	 public String getAcctCreatedText() {
		 return getAcctCreatedText.getText();
	 }
	 
	 public void clickContinueBtn() {
		 continueBtn.click();
	 }
	 
	 public void clickDeleteAcctBtn() {
		 deleteAccountBtn.click();
	 }
	 
	 public String getDeletedAcctText() {
		 return deleteAcctText.getText();
	 }
}
