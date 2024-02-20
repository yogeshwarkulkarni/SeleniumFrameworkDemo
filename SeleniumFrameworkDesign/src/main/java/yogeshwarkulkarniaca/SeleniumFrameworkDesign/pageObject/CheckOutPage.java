package yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement sCountry;

	By result = By.cssSelector(".ta-results");

	@FindBy(css = ".action__submit")
	WebElement submitButton;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	public void selectCountry(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(sCountry, country).build().perform();

		waitElementToAppear(By.cssSelector(".ta-results"));

		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		submitButton.click();
		return new ConfirmationPage(driver);

	}

}
