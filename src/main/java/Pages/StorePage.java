package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

	public StorePage(WebDriver driver) {
		super(driver);
	}

	 By searchFld = By.xpath("//input[@type='search']");
	 By searchBtn = By.xpath("(//button[@type='submit'])[1]");
	 By title = By.xpath("//h1[@class='woocommerce-products-header__title page-title']");
//	 By addtocartbtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
	 By viewCartLink = By.cssSelector("a[title='View cart']"); 
	 
	private StorePage enterTextInSearchFld(String txt) {
		driver.findElement(searchFld).sendKeys(txt);
		return this;
	}
	private StorePage clickOnSearchBtn() {
		driver.findElement(searchBtn).click();
		return this;
	}
	public StorePage search(String txt) {
		enterTextInSearchFld(txt).clickOnSearchBtn();
		return this;
	}
	

	
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	
	private By getAddToCartBtnElement(String prodName) {
	  return  By.cssSelector("a[aria-label='Add “"+ prodName +"” to your cart']");
	}
	
	public StorePage clickOnAddToCartBtn(String prodName) {
		By addtocartbtn =  getAddToCartBtnElement(prodName);
		driver.findElement(addtocartbtn).click();;
		return this;

	}
    public CartPage clickViewCartLink() {
    	driver.findElement(viewCartLink).click();
    	return new CartPage(driver);
    }
}
