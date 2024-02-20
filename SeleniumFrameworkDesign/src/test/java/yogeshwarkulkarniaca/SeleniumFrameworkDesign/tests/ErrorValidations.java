package yogeshwarkulkarniaca.SeleniumFrameworkDesign.tests;

import org.testng.annotations.Test;
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
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.ProductCatelog;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.testComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws IOException {
		String productName = "ZARA COAT 3";

		ProductCatelog pc = lp.loginApplication("yp.kulkarni12q3@gmail.com", "Ypkuqqlkarni123");
		AssertJUnit.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		
		

	}

}
