
package ActualTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public orderPage op = new orderPage(driver);

	@BeforeTest(groups = { "Regression" })
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test(groups = { "Regression" }, enabled = false)
	public void Ordering() throws IOException, InterruptedException {
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
			if (linksinmycart.get(i).getAttribute("href").contains("remove")) {
				linksinmycart.get(i).click();
			}
		}
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
		ap.addcart().click();
		ap.Checkout().click();
		Deliveryinfo di = new Deliveryinfo(driver);
		System.out.println(di.Address().getText());
		di.continuebutton().click();
		di.COD().click();
		di.continuebutton().click();
		System.out.println(di.BilligInfo().getText());
		di.ConfirmOrder().click();
		System.out.println(di.OrderConfirmation().getText());
		lp.LogOff().click();
	}

	@Test(dependsOnMethods = { "Ordering" }, alwaysRun = true, enabled = false)
	public void modifyingOrder() throws IOException {
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
			if (linksinmycart.get(i).getAttribute("href").contains("remove")) {
				linksinmycart.get(i).click();
			}
		}
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
		ap.addcart().click();
		System.out.println(ap.Quantity().getText());
		ap.Quantity().clear();
		ap.Quantity().sendKeys("2");
		ap.Updatebutton().click();
		// Assert.assertEquals(ap.Quantity().getText(), "2");
		ap.Checkout().click();
		Deliveryinfo di = new Deliveryinfo(driver);
		System.out.println(di.Address().getText());
		di.ChangeAddress().click();
		di.DiffAddress().click();
		di.continuebutton().click();
		System.out.println(di.Newaddress().getText());
		di.continuebutton().click();
		di.PayPal().click();
		di.continuebutton().click();
		System.out.println(di.Errormsg().getText());
		lp.LogOff().click();
	}

	@Test(enabled = false)
	public void OrderinNewadress() throws IOException, InterruptedException {
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
			if (linksinmycart.get(i).getText().contains("remove")) {
				String clickoneachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
				linksinmycart.get(i).sendKeys(clickoneachlink);
			} else {
				System.out.println("Shopping cart is empty");
			}
		}
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
			if (ComixBooks.get(i).getText().contains("Comix Book")) {

				ComixBooks.get(i).click();
				break;
			}
		}
		ap.addcart().click();
		op.SearchingCloths().click();
		op.clothsentertainer().click();
		lp.buynow().click();
		ap.Checkout().click();
		Deliveryinfo di = new Deliveryinfo(driver);
		System.out.println(di.Address().getText());
		di.ChangeAddress().click();
		di.DiffAddress().click();
		/*
		 * di.Gender().click(); di.FirstName().sendKeys(prop.getProperty("firstname"));
		 * di.LastName().sendKeys(prop.getProperty("lastname"));
		 * di.Company().sendKeys(prop.getProperty("company"));
		 * di.StreetAddress().sendKeys(prop.getProperty("streetaddress"));
		 * di.Suburb().sendKeys(prop.getProperty("suburb"));
		 * di.Postcode().sendKeys(prop.getProperty("postcode"));
		 * di.City().sendKeys(prop.getProperty("city"));
		 * di.State().sendKeys(prop.getProperty("state")); Select s = new
		 * Select(di.Country()); s.selectByVisibleText("India");
		 */
		di.continuebutton().click();
		System.out.println(di.Newaddress().getText());
		di.continuebutton().click();
		di.COD().click();
		di.continuebutton().click();
		System.out.println(di.BilligInfo().getText());
		di.ConfirmOrder().click();
		System.out.println(di.OrderConfirmation().getText());
		lp.LogOff().click();
	}

	@Test(enabled = false)
	public void orderHistory() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		for (int i = 0; i < lp.orderHistory().size(); i++) {
			String clickoneachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			lp.orderHistory().get(i).sendKeys(clickoneachlink);
		}
		WebElement cart1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/table[1]"));
		System.out.println(cart1.getText());

	}

	@Test(enabled = false)
	public void shoppingCartverification() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		for (int i = 0; i < lp.shoppingcart().size(); i++) {
			String clickoneachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			lp.shoppingcart().get(i).sendKeys(clickoneachlink);
		}
		WebElement cart = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/table[1]"));
		System.out.println(cart.getText());

	}

	@Test(enabled = false)
	public void removeProducts() throws IOException, InterruptedException {
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
			if (linksinmycart.get(i).getText().contains("remove")) {
				String clickoneachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
				linksinmycart.get(i).sendKeys(clickoneachlink);
			} else {
				System.out.println("Shopping cart is empty");
			}
		}
	}

	@Test(enabled = false)
	public void Productreview() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		for (int i = 0; i < lp.orderHistory().size(); i++) {
			if (lp.orderHistory().get(i).getText().contains("1Story Book")) {
				lp.orderHistory().get(i).click();
			}
		}
		lp.Reviews().click();
		lp.writeReview().click();
		lp.reviewArea().sendKeys(prop.getProperty("Review"));
		lp.ratingtheproduct().click();
		lp.continuebutton().click();
		System.out.println(lp.reviewMsg().getText());
	}

	@Test(enabled=false)
	public void productReviewTest2() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		for (int i = 0; i < lp.orderHistory().size(); i++) {
			if (lp.orderHistory().get(i).getText().contains("1Story Book")) {
				lp.orderHistory().get(i).click();
			}
		}
		lp.Reviews().click();
		lp.writeReview().click();
		lp.reviewArea().sendKeys("Product was good");
		lp.ratingtheproduct().click();
		lp.continuebutton().click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test(enabled=false)
	public void productReviewTest3() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		for (int i = 0; i < lp.orderHistory().size(); i++) {
			if (lp.orderHistory().get(i).getText().contains("1Story Book")) {
				lp.orderHistory().get(i).click();
			}
		}
		lp.Reviews().click();
		lp.writeReview().click();
		lp.reviewArea().sendKeys("Product was good");
		lp.continuebutton().click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void withoutPaymenterror() throws IOException {
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
			if (linksinmycart.get(i).getText().contains("remove")) {
				String clickoneachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
				linksinmycart.get(i).sendKeys(clickoneachlink);
			}
		}
		orderPage op = new orderPage(driver);
		WebElement SearchProducts = op.Searchingbooks();// entire table link
		System.out.println(SearchProducts.findElements(By.tagName("a")).size());
		for (int i = 0; i < SearchProducts.findElements(By.tagName("a")).size(); i++) {
			if (SearchProducts.findElements(By.tagName("a")).get(i).getText().contains("Chacofame->")) {

				SearchProducts.findElements(By.tagName("a")).get(i).click();
				break;
			}

		}
		op.BuyNow().click();
		ap.Checkout().click();
		Deliveryinfo di = new Deliveryinfo(driver);
		System.out.println(di.Address().getText());
		di.continuebutton().click();
		di.continuebutton().click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

	@AfterTest
	public void Exit() {
		driver.close();
		driver = null;
	}
}
