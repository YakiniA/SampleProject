package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initialize() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\nselv\\workspace\\CP-SAT\\src\\main\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		// String url = prop.getProperty("url");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nselv\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nselv\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary("C:\\Users\\nselv\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

			driver = new FirefoxDriver(firefoxOptions);
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\nselv\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
