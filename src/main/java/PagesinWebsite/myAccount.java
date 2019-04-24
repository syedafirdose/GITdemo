package PagesinWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myAccount {

	public WebDriver driver;

	public myAccount(WebDriver driver) {
		this.driver = driver;
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

}
