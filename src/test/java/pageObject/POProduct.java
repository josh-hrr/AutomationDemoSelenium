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
	
	@FindBy(css=".col-sm-6 .btn-default")
	WebElement proceedToCheckout;
	
	@FindBy(css=".check_out")
	WebElement placeOrder;
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement nameOnCard;
	
	@FindBy(css="input[data-qa='card-number']")
	WebElement cardNumber;
	
	@FindBy(css="input[data-qa='cvc']")
	WebElement cvc;
	
	@FindBy(css="input[data-qa='expiry-month']")
	WebElement expirationMonth;
	
	@FindBy(css="input[data-qa='expiry-year']")
	WebElement expirationYear;
	
	@FindBy(css="#submit")
	WebElement payBtn;
	
	public void addItemToCart() {
		addToCart.click();
	}
	
	public String getItemPrice() {
		return getPrice.getText();
	} 
	
	public void clickViewCart() {
		viewCart.click();
	}
	
	public void proceedToCheckoutBtn() {
		proceedToCheckout.click();
	}
	
	public void placeOrder() {
		placeOrder.click();
	}
	
	public void fillOutPayment(String cardName, String cardNumberInput, String cvcNumber, String expMonth, String expYear) {
		nameOnCard.sendKeys(cardName);
		cardNumber.sendKeys(cardNumberInput);
		cvc.sendKeys(cvcNumber);
		expirationMonth.sendKeys(expMonth);
		expirationYear.sendKeys(expYear);
	}
	
	public void clickPayAndConfirmOrder() {
		payBtn.click();
	}
	
	public void downloadInvoice() { 
		placeOrder.click();
		
	}
}
