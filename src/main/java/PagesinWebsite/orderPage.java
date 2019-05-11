package PagesinWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class orderPage {

	public WebDriver driver;

	public orderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement Searchingbooks() {

		return driver.findElement(By.xpath("//div[@class='ui-widget-content infoBoxContents']"));
	}

	public WebElement SearchingCloths() {

		return driver.findElement(By.xpath("//a[contains(text(),'Clothes->')]"));
	}

	public List<WebElement> clickonlink() {

		return driver.findElements(By.tagName("a"));
	}

	public List<WebElement> comixbook() {
		WebElement entirebooks = driver
				.findElement(By.xpath("//div[@class='ui-widget-content ui-corner-bottom productListTable']"));
		List<WebElement> linksinbooks = entirebooks.findElements(By.tagName("a"));
		return linksinbooks;
	}

	public WebElement clothsentertainer() {

		return driver.findElement(By.xpath("//td[@class='smallText']//a[contains(text(),'Entertainer')]"));
	}

	public WebElement BuyNow() {

		return driver.findElement(By.xpath("//span[contains(text(),'Buy Now')]"));
	}

}
