package PagesinWebsite;

import java.util.List;

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

	public List<WebElement> shoppingcart() {
		WebElement cart = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/table[1]"));
		return cart.findElements(By.tagName("a"));
	}

	public List<WebElement> orderHistory() {
		WebElement cart1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/table[1]"));
		return cart1.findElements(By.tagName("a"));
	}
	public WebElement Reviews() {
		return driver.findElement(By.xpath("//span[contains(text(),'Reviews')]"));
	}
	public WebElement Textmsg() {
		return driver.findElement(By.xpath("//span[contains(text(),'Reviews')]"));
	}
	public WebElement writeReview() {
		return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[2]/span[1]/span[1]/a[1]/span[2]"));
	}
	public WebElement reviewArea() {
		return driver.findElement(By.xpath("//textarea[@name='review']"));
	}
	public WebElement ratingtheproduct() {
		return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/input[5]"));
	}
	public WebElement reviewMsg() {
		return driver.findElement(By.xpath("//td[@class='messageStackSuccess']"));
	}

}
