package ActualTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesinWebsite.searchadvanced;
import Resourses.Initialization;
import junit.framework.Assert;

public class advancedsearch extends Initialization {
	public WebDriver driver;

	@BeforeTest
	public void driverStart() throws IOException {
		driver = initializeDriver();
	}

	@Test
	public void Advancedsearch() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		searchadvanced sa = new searchadvanced(driver);// POI
		Select s = new Select(sa.manufactureinfo());
		s.selectByValue("4199");
		sa.advansearch().click();
		Assert.assertTrue(sa.Categories().isDisplayed());
		Assert.assertTrue(sa.CheckBox().isEnabled());
		Assert.assertTrue(sa.ManufactureID().isDisplayed());
		Assert.assertTrue(sa.Datefrom().isDisplayed());
		Assert.assertTrue(sa.dateTo().isDisplayed());
		Select s1 = new Select(sa.ManufactureID());
		s1.selectByValue("4199");
		sa.PriceFrom().sendKeys("123647855");
		sa.PriceTo().sendKeys("5458454651");
		sa.Datefrom().click();
		Select mnt = new Select(sa.Month());
		mnt.selectByValue("2");
		Select yr = new Select(sa.Year());
		yr.selectByValue("2019");
		int dateCount = sa.Datecalender().size();
		for (int i = 0; i < dateCount; i++) {
			String dateText = sa.Datecalender().get(i).getText();
			if (dateText.equalsIgnoreCase("15")) {
				System.out.println(dateText);
				sa.Datecalender().get(i).click();
				break;
			}

		}
		Thread.sleep(2000L);
		sa.dateTo().click();
		Select mntTo = new Select(sa.Month());
		mntTo.selectByValue("11");
		Select yrTo = new Select(sa.Year());
		yrTo.selectByValue("2019");
		int dateCountTo = sa.Datecalender().size();
		for (int i = 0; i < dateCountTo; i++) {
			String dateText = sa.Datecalender().get(i).getText();
			if (dateText.equalsIgnoreCase("25")) {
				System.out.println(dateText);
				sa.Datecalender().get(i).click();
				break;
			}

		}
		sa.Search().click();
		Assert.assertTrue(sa.MsgDisplayed().isDisplayed());
		System.out.println(sa.MsgDisplayed().getText());
	}

	@Test
	public void helplink() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		searchadvanced sa = new searchadvanced(driver);// POI
		sa.advansearch().click();
		Assert.assertTrue(sa.HelpSearch().isDisplayed());
		sa.HelpSearch().click();
		Thread.sleep(5000L);
		sa.HelpOkbutton().click();

	}
	@AfterTest
	public void Exit() {
		driver.close();
		driver=null;
	}

}
