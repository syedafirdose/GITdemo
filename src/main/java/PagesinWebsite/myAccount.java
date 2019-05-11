package PagesinWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myAccount {

	public WebDriver driver;

	public myAccount(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement title() {
		return driver.findElement(By.xpath("//div[@id='storeLogo']//a//img"));
	}
	public WebElement myaccntbutton() {
		return driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
	}

	public WebElement myaccountlink1() {
		return driver.findElement(By.xpath("//a[contains(text(),'View or change my account information.')]"));
	}

	public WebElement myaccountlink2() {
		return driver.findElement(By.xpath("//a[contains(text(),'View or change entries in my address book.')]"));
	}

	public WebElement myaccountlink3() {
		return driver.findElement(By.xpath("//a[contains(text(),'Change my account password.')]"));
	}

	public WebElement myorderlink1() {
		return driver.findElement(By.xpath("//a[contains(text(),'View the orders I have made.')]"));
	}

	public WebElement emailnotificationlink1() {
		return driver.findElement(By.xpath("//a[contains(text(),'Subscribe or unsubscribe from newsletters.')]"));
	}

	public WebElement emailnotificationlink2() {
		return driver.findElement(By.xpath("//a[contains(text(),'View or change my product notification list.')]"));
	}
	public WebElement nextlink() {
		return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[11]/p[1]/a[1]/u[1]"));
	}
	public WebElement backButton() {
		return driver.findElement(By.xpath("//span[contains(text(),'Back')]"));
	}
	public List<WebElement> ohistorylinks() {
		WebElement olinks=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]"));
		return olinks.findElements(By.tagName("a"));
	}
	public List<WebElement> ohistorylinks1() {
		WebElement olinks1=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div/table/tbody/tr/td/span/a"));
		return olinks1.findElements(By.tagName("a"));
}
	public WebElement newsubscription() {
		return driver.findElement(By.xpath("//input[@name='newsletter_general']"));
	}
	public WebElement ccontinue() {
		return driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
	}
	public WebElement subscriptionMessge() {
		return driver.findElement(By.xpath("//td[@class='messageStackSuccess']"));
	}
}