package Resourses;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Initialization {

	public WebDriver driver;
	public static Properties prop;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\my lap\\Desktop\\PhpTravelsAutomation\\src\\main\\java\\Resourses\\data.properties");
		prop.load(fis);

		String BrowserName = prop.getProperty("Browser");
		if (BrowserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://work//geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", "C://work//internerexplorerdriver.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

}
