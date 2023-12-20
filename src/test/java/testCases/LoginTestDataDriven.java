package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; 
import TCBaseBeforeAfter.TCBeforeAfterDataDriven;
import pageObject.POHome;
import pageObject.POLogin;

public class LoginTestDataDriven extends TCBeforeAfterDataDriven{
	
	POLogin login;
	POHome home; 
	
	@Test(dataProvider="loginData", priority=1) 
	public void loginTest(String username, String password) throws InterruptedException {
		
		home = new POHome(driver);
		driver.manage().window().maximize();
		String homeText = home.getHomeText();
		Assert.assertEquals(homeText, "AutomationExercise");
		home.clickLoginBtn();
		
		login = new POLogin(driver);
		login.inputEmail(username);
		login.inputPassword(password);
		login.clickLogin();
		Thread.sleep(3000);
		
		login = new POLogin(driver);
		login.clickLogout(); 
	} 
	
	@DataProvider(name="loginData")
	public Object[][] getData(){
		return new Object[][] {
			{"placeOrderTest@test.com", "placeOrderTest"},
            {"wrongEmail@test.com", "wrongPassword"}
		};
	}
}
