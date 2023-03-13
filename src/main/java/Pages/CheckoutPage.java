package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	By firstName = By.id("billing_first_name");
	By lastName = By.id("billing_last_name");
	By address = By.id("billing_address_1");
	By city = By.id("billing_city");
	By pin = By.id("billing_postcode");
	By email = By.id("billing_email");
	By clickOnPlace = By.id("place_order");
	By successNotice = By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
	
	public CheckoutPage enterFirstName(String fn) {
		driver.findElement(firstName).clear();
		 driver.findElement(firstName).sendKeys(fn);
		 return this;
	}
	public CheckoutPage enterLastName(String ln) {
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(ln);
		return this;
	}
	public CheckoutPage enterAddress(String add) {
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(add);
		return this;
	} 
	public CheckoutPage enterCity(String town) {
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(town);
		return this;
	}
	public CheckoutPage enterPin(String pinCode) {
		driver.findElement(pin).clear();
		driver.findElement(pin).sendKeys(pinCode);
		return this;
	}
	public CheckoutPage enterMail(String mail) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(mail);
		return this;
	}
	public CheckoutPage clickOnPalceOrder() {
		driver.findElement(clickOnPlace).click();
		return this;
	}
	public String getNotice() {
		return driver.findElement(successNotice).getText();
	}
	
}
