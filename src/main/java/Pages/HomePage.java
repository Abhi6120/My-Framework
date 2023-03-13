package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	StorePage storepage;
	By storelink = By.xpath("(//a[@class='menu-link'])[2]");

	public HomePage(WebDriver driver ) {
		super(driver);
	}

	public StorePage clickOnStoreLink() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		  wait.until(ExpectedConditions.presenceOfElementLocated(storelink)).click();
		  return new StorePage(driver);
	}
}
