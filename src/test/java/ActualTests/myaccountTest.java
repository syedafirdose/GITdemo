package ActualTests;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesinWebsite.LandingPage;
import PagesinWebsite.myAccount;
import Resourses.Initialization;

public class myaccountTest extends Initialization {

	public WebDriver driver;

	@BeforeTest(groups= {"Regression"})
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test(groups= {"Regression"})
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

}
