package abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.CartPage;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.OrderPage;


public class AbstractComponent {
	
	WebDriver driver;
	
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement we)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(we));

	}
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage op = new OrderPage(driver);
		return op;
	}
}
