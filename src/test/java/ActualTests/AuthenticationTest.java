package ActualTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesinWebsite.LandingPage;
import Resourses.Initialization;
import junit.framework.Assert;

public class AuthenticationTest extends Initialization {
	public WebDriver driver;

	@BeforeTest(groups= {"Regression"})
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test(groups= {"Regression"})
	public void Postivelogin() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		lp.Signin().click();
		System.out.println("Login passed for positivelogin");
		Assert.assertTrue(lp.LogOff().isDisplayed());
		{
			lp.LogOff().click();
			System.out.println("logged off");
			System.out.println("logged off again");
		}
	}

	@Test(groups= {"Regression"})
	public void InvalidLogin() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.passwordcreds().sendKeys(prop.getProperty("password"));
		lp.Signin().click();
		String Text = lp.Errormsg().getText();
		if (Text.equals(" Error: No match for E-Mail Address and/or Password.")) {
			System.out.println("Login Failed for InavalidLoginmethod");
		} else {
			System.out.println("Login passed for InavalidLoginmethod");
		}

	}

	@Test(groups= {"Regression"})
	public void Invalidlogin2() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.Emailcreds().isDisplayed());
		{
			lp.Emailcreds().sendKeys(prop.getProperty("UserName"));
		}
		Assert.assertTrue(lp.passwordcreds().isDisplayed());
		{
			lp.passwordcreds().sendKeys(prop.getProperty("pass"));
		}
		Assert.assertTrue(lp.Signin().isDisplayed());
		{
			lp.Signin().click();
		}
		String Text = lp.Errormsg().getText();
		if (Text.equals(" Error: No match for E-Mail Address and/or Password.")) {
			System.out.println("Login failed for Invalidlogin2");
		} else {
			System.out.println("Login passed for Invalidlogin2");
		}
	}

	@Test(groups= {"Regression"})
	public void Invalidlogin3() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Emailcreds().sendKeys(prop.getProperty("UserName"));
		lp.passwordcreds().sendKeys(prop.getProperty("password"));
		lp.Signin().click();
		String Text = lp.Errormsg().getText();
		if (Text.equals(" Error: No match for E-Mail Address and/or Password.")) {
			System.out.println("Login failed for Invalidlogin3");
		} else {
			System.out.println("Login passed for Invalidlogin3");
		}

	}

	@Test(groups= {"Regression"})
	public void Invaliglogin4() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.Signin().click();
		String Text = lp.Errormsg().getText();
		if (Text.equals(" Error: No match for E-Mail Address and/or Password.")) {
			System.out.println("Login Failed for InavalidLogin4");
		} else {
			System.out.println("Login passed for InavalidLogin4");
			System.out.println("Login passed for InavalidLogin4");
		}

	}

	@AfterTest
	public void Exitbrowser() {
		driver.close();
		driver = null;
	}

	@Test(groups= {"Regression"})
	public void forgotpasswordtest1() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.forgotPW().click();
		lp.Emailcreds().sendKeys(prop.getProperty("username"));
		lp.continuebutton().click();
		if (lp.pwerrormsg2().isDisplayed()) {
			System.out.println(
					"Test passed for forgotpasswordtest1, Reset password link has been send to registered mail ID");

		} else if (lp.pwerrormsg().isDisplayed()) {

			System.out.println("Test passed, reset link has sent please check after 5minutes.");
		}
	}

	@Test(groups= {"Regression"})
	public void forgotpasswordtest2() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		LandingPage lp = new LandingPage(driver);
		lp.forgotPW().click();
		lp.Emailcreds().sendKeys(prop.getProperty("UserName"));
		lp.continuebutton().click();
		String displayedText = lp.pwerrormsg().getText();
		System.out.println(displayedText);
		String expectedText = " Error: The E-Mail Address was not found in our records, please try again.";
		Assert.assertTrue("Error message", displayedText.contains(expectedText));

	}

}
