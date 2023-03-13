package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	By txtusername = By.name("username");
	By txtpassword = By.name("password");
	By btnlogin = By.xpath("(//button[@type='submit'])[1]");

	public void enterUserName(String username) {
		driver.findElement(txtusername).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(txtpassword).sendKeys(password);
	}

	public void clickOnLoginBtn() {
		driver.findElement(btnlogin).click();
	}

	public CheckoutPage loginToApp(String un, String pass) {
		enterUserName(un);
		enterPassword(pass);
		clickOnLoginBtn();
		return new CheckoutPage(driver);
	}
}
