package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POProduct extends POBasePage{
	public POProduct(WebDriver driver) {
		super(driver);
	} 
	
	@FindBy(css=".cart")
	WebElement addToCart;
	
	@FindBy(css=".product-information span:nth-child(1)")
	WebElement getPrice;
	
	@FindBy(css=".modal-content p a[href='/view_cart']")
	WebElement viewCart;
	
	public void addItemToCart() {
		addToCart.click();
	}
	
	public String getItemPrice() {
		return getPrice.getText();
	} 
	
	public void clickViewCart() {
		viewCart.click();
	}
}
