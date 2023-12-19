package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TCBaseBeforeAfter.TCBaseBeforeAfter;
import pageObject.POHome;
import pageObject.POLogin;
import pageObject.POProduct;

public class PlaceOrderE2E extends TCBaseBeforeAfter{
	POHome home;
	POLogin login;
	POProduct product;
	String email = "placeOrderTest@test.com";
	String pass = "placeOrderTest";
	
	@Test(priority=1)
	void homeShouldBeLoaded() {
		home = new POHome(driver);
		String homeText = home.getHomeText();
		Assert.assertEquals(homeText, "AutomationExercise");
	}
	
	@Test(priority=2)
	void loginBtnShouldBeClicked() {
		home.clickLoginBtn(); 
	}
	
	@Test(priority=3)
	void loginShouldBeSuccessful() throws InterruptedException {
		login = new POLogin(driver);
		login.inputEmail(email);
		login.inputPassword(pass);
		login.clickLogin(); 
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	void addProductToCart() throws InterruptedException {
		product = new POProduct(driver);
		home = new POHome(driver);
		home.clickViewProduct();
		product.addItemToCart();
		Assert.assertEquals(product.getItemPrice(), "Rs. 500");
		Thread.sleep(2000);
		product.clickViewCart();
		Thread.sleep(2000);
	}   
}
