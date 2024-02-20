package yogeshwarkulkarniaca.SeleniumFrameworkDesign.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.CartPage;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.CheckOutPage;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.ConfirmationPage;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.LandingPage;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.OrderPage;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.ProductCatelog;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";
	
	@Test
	public void submitOrder() throws IOException {
		

		ProductCatelog pc = lp.loginApplication("yp.*****1**3@gmail.com", "Y*******arn****");

		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productName);
		CartPage cp = pc.goToCartPage();

		Boolean match = cp.verifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckOutPage cop = cp.checkOut();
		cop.selectCountry("India");
		ConfirmationPage conf = cop.submitOrder();
		String confirmMessage = conf.getConfirmationMessage();

		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistory()
	{
		ProductCatelog pc = lp.loginApplication("yp.kulkarni123@gmail.com", "Ypkulkarni123");
		OrderPage op = pc.goToOrderPage();
		Assert.assertTrue(op.verifyOrderDisplay(productName));
	}

}
