package PagesinWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchadvanced {
	public WebDriver driver;

	By manufacture = By.xpath("//select[@name='manufacturers_id']");
	By adsearch = By.xpath("//strong[contains(text(),'Advanced Search')]");
	By categories = By.xpath("//select[@name='categories_id']");
	By checkbox = By.xpath("//td[@class='smallText']//input[@value='1']");
	By manufactureid = By.xpath("//select[@name='manufacturers_id']");
	By pricefrom = By.xpath("//input[@name='pfrom']");
	By priceto = By.xpath("//input[@name='pto']");
	By datefrom = By
			.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[6]/td[2]/input[1]");
	By dateto = By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[2]/input[1]");
	By month = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/select[1]");
	By year = By.xpath("//select[@class='ui-datepicker-year']");
	By date = By.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr/td");
	By search = By.xpath("//span[@class='ui-button-text'][contains(text(),'Search')]");
	By msg=By.xpath("//div[@class='contentText']/p");
	By help = By.xpath("//*[@id=\"bodyContent\"]/form/div/div/div[2]/span[1]/a");
	By Okhelp = By.xpath("//span[contains(text(),'Ok')]");

	public searchadvanced(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement manufactureinfo() {

		return driver.findElement(manufacture);
	}

	public WebElement advansearch() {

		return driver.findElement(adsearch);

	}

	public WebElement Categories() {

		return driver.findElement(categories);

	}

	public WebElement CheckBox() {

		return driver.findElement(checkbox);

	}

	public WebElement ManufactureID() {

		return driver.findElement(manufactureid);

	}

	public WebElement PriceFrom() {

		return driver.findElement(pricefrom);

	}

	public WebElement PriceTo() {

		return driver.findElement(priceto);

	}

	public WebElement dateTo() {
		return driver.findElement(dateto);

	}

	public WebElement Datefrom() {

		return driver.findElement(datefrom);
	}

	public WebElement Month() {
		return driver.findElement(month);

	}

	public WebElement Year() {
		return driver.findElement(year);

	}

	public List<WebElement> Datecalender() {
		return driver.findElements(date);

	}

	public WebElement Search() {
		return driver.findElement(search);

	}

	public WebElement HelpSearch() {
		return driver.findElement(help);

	}

	public WebElement HelpOkbutton() {
		return driver.findElement(Okhelp);

	}
	public WebElement MsgDisplayed() {
		return driver.findElement(msg);

	}

}
