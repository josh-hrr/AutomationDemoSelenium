package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POHome extends POBasePage{
	public POHome(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='col-sm-6']/h1")
	WebElement homePageText;
	
	@FindBy(css="li a[href='/login']")
	WebElement homeLoginBtn;
	
	@FindBy(css="li a[href='/product_details/1']")
	WebElement viewProduct;
	
	public String getHomeText() {
		return homePageText.getText();
	} 
	public void clickLoginBtn() {
		homeLoginBtn.click();
	}
	
	public void clickViewProduct() {
		viewProduct.click();
	}
}
