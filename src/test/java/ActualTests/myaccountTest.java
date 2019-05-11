package ActualTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesinWebsite.LandingPage;
import PagesinWebsite.myAccount;
import Resourses.Initialization;
import junit.framework.Assert;

public class myaccountTest extends Initialization {

	public WebDriver driver;

	@BeforeTest(groups = { "Regression" })
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test(enabled = false)
	public void verifiyingTitle() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		myAccount ma = new myAccount(driver);
		String Actual = ma.title().getAttribute("title");
		Assert.assertEquals(" GCR Shop ", Actual);

	}

	@Test(groups = { "Regression" }, enabled = false)
	public void MyaccountAlllinksverification() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		myAccount ma = new myAccount(driver);
		ma.myaccntbutton().click();
		ma.myaccountlink1().click();
		driver.navigate().back();
		ma.myaccountlink2().click();
		driver.navigate().back();
		ma.myaccountlink3().click();
		driver.navigate().back();
		ma.myorderlink1().click();
		driver.navigate().back();
		ma.emailnotificationlink1().click();
		driver.navigate().back();
		ma.emailnotificationlink2().click();
		driver.navigate().back();
	}

	@Test(enabled = false)
	public void MyorderHistory() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		myAccount ma = new myAccount(driver);
		ma.myaccntbutton().click();
		ma.myorderlink1().click();
		Thread.sleep(2000L);
		if (ma.nextlink().isDisplayed()) {
			ma.nextlink().click();
		} else {
			System.out.println("No help link found");
		}
		ma.backButton().click();
	}

	@Test(enabled=false)
	public void orderhistoryLinks() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		myAccount ma = new myAccount(driver);
		ma.myaccntbutton().click();
		ma.myorderlink1().click();
		System.out.println(ma.ohistorylinks().size());
		for (int i = 0; i < ma.ohistorylinks().size(); i++) {
			String clickoneachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			WebElement olinks = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]"));
			if (olinks.findElements(By.tagName("a")).get(i).getText().contains("View")) {
				olinks.findElements(By.tagName("a")).get(i).sendKeys(clickoneachlink);
			}
		}
		Thread.sleep(2000L);
		Assert.assertTrue(ma.nextlink().isDisplayed());
		ma.nextlink().click();
		for (int i = 0; i < ma.ohistorylinks().size(); i++) {
			String clickoneachlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			WebElement olinks = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]"));
			olinks.findElements(By.tagName("a")).get(i).sendKeys(clickoneachlink);
		}
	}
	
	@Test
	public void newsSubscription() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		myAccount ma = new myAccount(driver);
		ma.myaccntbutton().click();
		ma.emailnotificationlink1().click();
		if(ma.newsubscription().isSelected()) {
			ma.ccontinue().click();
		}else {
		ma.newsubscription().click();
		ma.ccontinue().click();
		}
		System.out.println(ma.subscriptionMessge().getText());
	}
}
