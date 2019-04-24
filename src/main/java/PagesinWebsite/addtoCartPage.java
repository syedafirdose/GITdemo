package PagesinWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addtoCartPage {
	public WebDriver driver;

	By Cart = By.xpath("//span[@class='ui-button-text']");
	By AddtoCartbutton = By.xpath("//span[contains(text(),'Add to Cart')]");
	By quantity = By.xpath("//input[@name='cart_quantity[]']");
	By checkout = By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[2]/span[1]/span[1]/a[1]/span[2]");
	By update=By.xpath("//span[contains(text(),'Update')]");
	
	// By Mycartlinks = By.xpath("//div[@class='contentText']");
	By remove = By.tagName("a");

	public addtoCartPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement addcart() {

		return driver.findElement(AddtoCartbutton);
	}

	public WebElement Quantity() {

		return driver.findElement(quantity);
	}

	public WebElement Checkout() {

		return driver.findElement(checkout);
	}

	public WebElement cart() {

		return driver.findElement(Cart);
	}

	public List<WebElement> mycartlinks() {
		WebElement Mycartlinks = driver.findElement(By.xpath("//div[@class='contentText']"));
		return Mycartlinks.findElements(By.tagName("a"));
	}
	public WebElement Updatebutton() {

		return driver.findElement(update);
	}

}
