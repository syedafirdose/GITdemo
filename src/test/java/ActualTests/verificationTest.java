package ActualTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PagesinWebsite.LandingPage;
import PagesinWebsite.myAccount;
import PagesinWebsite.testVerification;
import Resourses.Initialization;

public class verificationTest extends Initialization {

	public WebDriver driver;

	@BeforeTest
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test
	public void FirstLinkVerification() throws IOException, InterruptedException {
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
		testVerification tv = new testVerification(driver);
		Assert.assertTrue(tv.radionutton().isEnabled());
		Assert.assertTrue(tv.frstNam().getAttribute("value").equals(prop.getProperty("firstNam")));
		Assert.assertEquals(tv.scndNam().getAttribute("value"), prop.getProperty("lastNam"));
		Assert.assertTrue(tv.dateofBirth().getAttribute("value").equals(prop.getProperty("DOB")));
		Assert.assertEquals(tv.emailAddress().getAttribute("value"), prop.getProperty("username"));
		Assert.assertTrue(tv.Telpnnumber().getAttribute("value").equals(prop.getProperty("Telephone")));
		tv.continuee().click();
		System.out.println(tv.stackmsg().getText());

	}
	
	@Test
	public void topLinksVerification() {
		
	}

	@AfterTest
	public void exitBrowser() {
		driver.close();
	}

}
