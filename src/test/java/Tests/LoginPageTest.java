package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.StorePage;

public class LoginPageTest extends BasePage{
	LoginPage  loginPage;
	CheckoutPage checkoutPage ;
		
	@BeforeMethod
	public void setup() {
		init();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		checkoutPage = loginPage.loginToApp("CyberSuccess", "Abc@12345");
//		String expUrl = "https://askomdch.com/account/";
//		Assert.assertEquals(checkoutPage.getUrl(), expUrl);
		System.out.println(checkoutPage.getUrl());
		
		HomePage homepage = new HomePage(driver);
		StorePage storePage = homepage.clickOnStoreLink();
		storePage.search("Blue");
		System.out.println(storePage.getTitle());
		
		//Assert.assertEquals(storePage.getTitle(),"Search results: “blue”");
		storePage.clickOnAddToCartBtn("Blue Shoes");
		Thread.sleep(3000l);
		CartPage cartPage = storePage.clickViewCartLink();
		Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
		
		CheckoutPage checkoutPage = cartPage.clickOnCheckOutBtn();
		checkoutPage.enterFirstName("demo")
		            .enterLastName("user")
		            .enterAddress("San Francisco")
		            .enterCity("San Francisco")
		            .enterPin("413802")
		            .enterMail("askomdch@gmail.com")
		            .clickOnPalceOrder();
		Thread.sleep(5000l);
		
		Assert.assertEquals(checkoutPage.getNotice(),
				 "Thank you. Your order has been received.");
		
		
		
	}
	
	
}
