package PagesinWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testVerification {

	private WebDriver driver;

	public testVerification(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement radionutton() {
		return driver.findElement(By.xpath("//input[@name='gender']"));
	}

	public WebElement frstNam() {
		return driver.findElement(By.xpath("//input[@name='firstname']"));
	}

	public WebElement scndNam() {
		return driver.findElement(By.xpath("//input[@name='lastname']"));
	}
	public WebElement stackmsg() {
		return driver.findElement(By.xpath("//td[@class='messageStackSuccess']"));
	}

	public WebElement dateofBirth() {
		return driver.findElement(By.xpath("//input[@id='dob']"));
	}

	public WebElement emailAddress() {
		return driver.findElement(By.xpath("//input[@name='email_address']"));
	}

	public WebElement Telpnnumber() {
		return driver.findElement(By.xpath("//input[@name='telephone']"));
	}

	public WebElement continuee() {
		return driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
	}

}
