package testCases; 
  
import org.testng.Assert; 
import org.testng.annotations.Test;

import TCBaseBeforeAfter.TCBaseBeforeAfter;
import pageObject.POLoginPageAutoPage;

public class LoginTestAutoPage extends TCBaseBeforeAfter { 
	 
	POLoginPageAutoPage loginPage; 
	String name = "Joshua";
	String email = "test@12345678910.com";
	
	@Test(priority=1)
	void homePageShouldBeLoaded() {
		logger.debug("Application logs...");
		logger.info("Starting Test Case 01");
		loginPage = new POLoginPageAutoPage(driver);
		Assert.assertEquals(loginPage.getSlideShowText(), "AutomationExercise");
	}
	
	@Test(priority=2, dependsOnMethods={"homePageShouldBeLoaded"})
	void signupFormShouldBeFilledOut() throws InterruptedException {
		Thread.sleep(2000);
		loginPage.clickLoginBtn();
		logger.info("Clicked on Login button");
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getTabTitle(), "Automation Exercise - Signup / Login");
		loginPage.setName(name);
		loginPage.setEmail(email);
	}
	
	@Test(priority=3)
	void signupBtnShouldBeClicked() {
		loginPage.clickSignupBtn();
		Assert.assertEquals(loginPage.getTabTitle(), "Automation Exercise - Signup");
	}  
	
	@Test(priority=4)
	void radioButtonShouldBeClicked() {
		loginPage.clickMrRadioBtn();
	}
	
	@Test(priority=5)
	void signUpShouldBeFilledOut() throws InterruptedException {
		loginPage.clickMrRadioBtn();
		String test = loginPage.getInputNameValue();
		Assert.assertEquals(test, name);
		loginPage.setPassword(email);
		loginPage.setDateOfBirth("9", "December", "1996");
		loginPage.setCheckBoxNewsLetter();
		loginPage.setCheckBoxOptin();
		Thread.sleep(2000);
		loginPage.setAddressInformation("Joshua", "TestingLastName", "testingAddress", "Australia", "testingState", "testingCity", "0101010", "44448888");
		Thread.sleep(2000);
	}
	
	@Test(priority=6)
	void signUpShouldBeSubmitted() {
		loginPage.clickCreateAccount();
	}
	
	@Test(priority=7)
	void accountShouldBeCreated() {
		String acctCreated = loginPage.getAcctCreatedText();
		Assert.assertEquals(acctCreated.toLowerCase(), "account created!");
	}
	
	@Test(priority=8)
	void continueBtnShouldBeClicked() { 
		loginPage.clickContinueBtn();
	}
	
	@Test(priority=9)
	void accountShouldBeDeleted() throws InterruptedException {
		loginPage.clickDeleteAcctBtn();
		String deletedAcctText = loginPage.getDeletedAcctText();
		Assert.assertEquals(deletedAcctText.toLowerCase(), "account deleted!");
		loginPage.clickContinueBtn(); 
		Thread.sleep(2000);
	}
	
	
	
	
	
	
}
