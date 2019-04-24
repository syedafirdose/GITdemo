
package ActualTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesinWebsite.Deliveryinfo;
import PagesinWebsite.LandingPage;
import PagesinWebsite.addtoCartPage;
import PagesinWebsite.orderPage;
import Resourses.Initialization;

public class BookingTest extends Initialization {

	public WebDriver driver;

	@BeforeTest
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test
	public void BookingStart() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		System.out.println("driver is" + driver);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		lp.LogOff().click();

	}

	@Test
	public void Ordering() throws IOException {
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

		
		/*  ap.cart().click(); List<WebElement> linksinmycart = ap.mycartlinks();
		  System.out.println(linksinmycart.size()); for (int i = 0; i <
		  linksinmycart.size(); i++) { if
		  (linksinmycart.get(i).getText().contains("remove")) {
		  linksinmycart.get(i).click(); } }*/
		 

		orderPage op = new orderPage(driver);
		WebElement SearchProducts = op.Searchingbooks();// entire table link
		System.out.println(SearchProducts.findElements(By.tagName("a")).size());
		for (int i = 0; i < SearchProducts.findElements(By.tagName("a")).size(); i++) {
			if (SearchProducts.findElements(By.tagName("a")).get(i).getText().contains("Books")) {

				SearchProducts.findElements(By.tagName("a")).get(i).click();
				break;
			}

		}

		List<WebElement> ComixBooks = op.comixbook();
		for (int i = 0; i < ComixBooks.size(); i++) {
			if (ComixBooks.get(i).getAttribute("href").contains("id=1937")) {

				ComixBooks.get(i).click();
				break;
			}

		}
		// addtoCartPage ap = new addtoCartPage(driver);
		ap.addcart().click();
		// System.out.println(ap.Quantity().getText());
		// ap.Quantity().sendKeys("2");
		// Assert.assertEquals(ap.Quantity().getText(), "2");
		ap.Checkout().click();
		Deliveryinfo di = new Deliveryinfo(driver);
		System.out.println(di.Address().getText());
		di.COD().click();
		di.continuebutton().click();
		System.out.println(di.BilligInfo().getText());
		di.ConfirmOrder().click();
	}

	
/*	 @Test public void AddingItems() {
	 * 
	 * Properties prop = new Properties(); FileInputStream fis = new
	 * FileInputStream("C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties"
	 * ); prop.load(fis); driver.get(prop.getProperty("URL"));
	
	
	 

	
	/* @AfterTest public void exitBrowser() {
	 driver.close(); }*/
	 

}
