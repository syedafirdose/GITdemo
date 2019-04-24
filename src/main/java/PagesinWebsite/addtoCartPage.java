package PagesinWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addtoCartPage {
	public WebDriver driver;

	By Cart = By.xpath("//span[@class='ui-button-text']");
	By AddtoCartbutton = By.xpath("//span[contains(text(),'Add to Cart')]");
	By quantity = By.xpath("cart_quantity[]");
	By checkout = By.xpath("//a[@href='http://www.gcrit.com/build3/shopping_cart.php']");
	
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
		WebElement Mycartlinks = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]"));
		return Mycartlinks.findElements(By.xpath("//a[contains(@href,'remove_product')]"));
	}

}
