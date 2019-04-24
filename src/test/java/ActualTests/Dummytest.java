package ActualTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesinWebsite.LandingPage;
import PagesinWebsite.addtoCartPage;
import Resourses.Initialization;

public class Dummytest extends Initialization {
	public WebDriver driver;

	@BeforeTest
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test
	public void dummyTest() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		addtoCartPage ap = new addtoCartPage(driver);
		ap.cart().click();
		List<WebElement> linksinmycart = ap.mycartlinks();
		System.out.println(linksinmycart.size());
		for (int i = 0; i < linksinmycart.size(); i++) {
			if (linksinmycart.get(i).getAttribute("href").contains("remove_product")) {

				linksinmycart.get(i).click();

			}
		}
		
	}

}
