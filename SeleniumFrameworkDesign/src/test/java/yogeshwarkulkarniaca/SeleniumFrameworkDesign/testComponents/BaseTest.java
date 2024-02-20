package yogeshwarkulkarniaca.SeleniumFrameworkDesign.testComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import yogeshwarkulkarniaca.SeleniumFrameworkDesign.pageObject.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage lp;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src/main//java//yogeshwarkulkarnica//resourses//gloablConfig.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

		} else if (browser.equalsIgnoreCase("IE")) {

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	@BeforeTest
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
