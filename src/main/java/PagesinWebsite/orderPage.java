package PagesinWebsite;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class orderPage {

	public WebDriver driver;
	// Dont ever define the webelemnts outside the method

	// WebElement entirebooks =
	// driver.findElement(By.xpath("//div[@class='ui-widget-content ui-corner-bottom
	// productListTable']"));

	// List<WebElement> linksinbooks = entirebooks.findElements(By.tagName("a"));

	public orderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement Searchingbooks() {
	
		return driver.findElement(By.xpath("//div[@class='grid_4 pull_16']//div[1]//div[2]"));
		
	}

	public List<WebElement> clickonlink() {

		return driver.findElements(By.tagName("a"));
	}


	public List<WebElement> comixbook() {
		WebElement entirebooks = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-corner-bottom productListTable']"));
		List<WebElement> linksinbooks = entirebooks.findElements(By.tagName("a"));
	
		return linksinbooks;

	}

	
}
