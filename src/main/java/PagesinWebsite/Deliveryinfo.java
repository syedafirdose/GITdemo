package PagesinWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Deliveryinfo {
	public WebDriver driver;

	By address = By.xpath("//*[@id=\"bodyContent\"]/form/div/div[1]/div/div[2]");
	By continueButton = By.xpath("//span[contains(text(),'Continue')]");
	By payment = By.xpath("//input[@name='payment']");
	By billinginfo = By.xpath("//*[@id=\"bodyContent\"]/form/div/div[2]/table");
	By confirm = By.xpath("//span[contains(text(),'Confirm Order')]");

	public Deliveryinfo(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Address() {

		return driver.findElement(address);
	}

	public WebElement continuebutton() {

		return driver.findElement(continueButton);
	}

	public WebElement COD() {

		return driver.findElement(payment);
	}

	public WebElement BilligInfo() {

		return driver.findElement(billinginfo);
	}

	public WebElement ConfirmOrder() {

		return driver.findElement(confirm);
	}
}
