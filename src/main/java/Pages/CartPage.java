package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
	
	By productName = By.cssSelector("td[class='product-name']");
	By checkOutBtn = By.cssSelector("a[class='checkout-button button alt wc-forward']");
	
	public CartPage(WebDriver driver) {
		super(driver); 
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public CheckoutPage clickOnCheckOutBtn() {
		driver.findElement(checkOutBtn).click();
		return new CheckoutPage(driver);
	}
}
