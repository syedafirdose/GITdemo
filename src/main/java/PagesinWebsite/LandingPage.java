package PagesinWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By email = By.xpath("//input[@name='email_address']");
	By Password = By.xpath("//input[@name='password']");
	By signin = By.xpath("//span[contains(text(),'Sign In')]");
	By Logoff = By.xpath("//span[contains(text(),'Log Off')]");
	By error = By.xpath("//td[@class='messageStackError']");
	By forgotpw = By.xpath("//a[contains(text(),'Password forgotten? Click here.')]");
	By continu = By.xpath("//span[contains(text(),'Continue')]");
	By PWerror = By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]");

	By errormsg2 = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Emailcreds() {
		return driver.findElement(email);
	}

	public WebElement passwordcreds() {
		return driver.findElement(Password);
	}

	public WebElement Signin() {
		return driver.findElement(signin);
	}

	public WebElement LogOff() {
		return driver.findElement(Logoff);
	}

	public WebElement Errormsg() {
		return driver.findElement(error);
	}

	public WebElement forgotPW() {
		return driver.findElement(forgotpw);
	}

	public WebElement continuebutton() {
		return driver.findElement(continu);
	}

	public WebElement pwerrormsg() {
		return driver.findElement(PWerror);
	}

	public WebElement pwerrormsg2() {
		return driver.findElement(errormsg2);
	}

	public WebElement Clthsentirelink() {
		return driver.findElement(By.xpath("//div[@class='ui-widget-content infoBoxContents']"));
	}

	public WebElement buynow() {
		return driver.findElement(By.xpath("//span[contains(text(),'Buy Now')]"));
	}

}
