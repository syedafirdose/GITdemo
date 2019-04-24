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
	By orderconfirmation = By.xpath("//div[@id='bodyContent']/h1");
	By Changeaddress = By.xpath("//span[contains(text(),'Change Address')]");
	By gender = By.xpath("//input[@name='gender']");
	By firstname = By.xpath("//input[@name='firstname']");
	By lastname = By.xpath("//input[@name='lastname']");

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

	public WebElement OrderConfirmation() {

		return driver.findElement(orderconfirmation);
	}

	public WebElement ChangeAddress() {

		return driver.findElement(Changeaddress);
	}

	public WebElement Gender() {

		return driver.findElement(gender);
	}
	public WebElement FirstName() {

		return driver.findElement(firstname);
	}
	public WebElement LastName() {

		return driver.findElement(lastname);
	}
	public WebElement Company() {

		return driver.findElement(By.xpath("//input[@name='company']"));
	}
	public WebElement StreetAddress() {

		return driver.findElement(By.xpath("//input[@name='street_address']"));
	}
	public WebElement Suburb() {

		return driver.findElement(By.xpath("//input[@name='suburb']"));
	}
	public WebElement City() {

		return driver.findElement(By.xpath("//input[@name='city']"));
	}
	public WebElement State() {

		return driver.findElement(By.xpath("//input[@name='state']"));
	}
	public WebElement Country() {

		return driver.findElement(By.xpath("//select[@name='country']"));
	}
	public WebElement PayPal() {

		return driver.findElement(By.xpath("//input[@value='paypal_express']"));
	}
	public WebElement Postcode() {

		return driver.findElement(By.xpath("//input[@name='postcode']"));
	}
	public WebElement Newaddress() {

		return driver.findElement(By.xpath("//div[@class='ui-widget-content infoBoxContents']"));
	}
	public WebElement Errormsg() {

		return driver.findElement(By.xpath("//*[@id=\"bodyWrapper\"]/table/tbody/tr/td"));
	
	} 
	public WebElement DiffAddress() {

		return driver.findElement(By.xpath("//input[@value='12621']"));
	
	}
}
