package tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.PHPFlightBookingPage;
import objectRepository.PHPHomePage;
import objectRepository.PHPmyAccountPage;
import resources.base;

public class LoginApplication {

	WebDriver driver1;
	base b = new base();

	@BeforeTest
	public void preRequiste() throws IOException {

		driver1 = b.initialize();

	}

	@Test(dataProvider = "getData")
	public void loginAppln(String userName, String password) throws IOException, InterruptedException {

		driver1.get(b.prop.getProperty("url"));
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		PHPHomePage php = new PHPHomePage(driver1);

		php.myAccount().click();
		php.LoginPage().click();
		php.Email().sendKeys(userName);
		php.Password().sendKeys(password);
		php.Login().click();
		PHPmyAccountPage accApp = new PHPmyAccountPage(driver1);
		Thread.sleep(1000);
		accApp.flightTab().click();

	}

	@Test(dependsOnMethods = { "loginAppln" })
	public void flightBooking() throws InterruptedException {
		PHPFlightBookingPage bookingPage = new PHPFlightBookingPage(driver1);

		Actions a = new Actions(driver1);
		WebElement from = bookingPage.FromCity();
		WebElement to = bookingPage.ToCity();
		WebElement departure = bookingPage.Departure();
		a.moveToElement(from).click().sendKeys("salt lake city").build().perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.TAB);
		a.moveToElement(to).click().sendKeys("san francisco").build().perform();
		a.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		a.moveToElement(departure).click().perform();

		while (!bookingPage.Month().getText().contains("May")) {

			WebElement nextButton = bookingPage.Next();

			a.moveToElement(nextButton).click().perform();

		}

		List<WebElement> dates = bookingPage.Date();
		int count = bookingPage.Date().size();
		for (int i = 0; i < count; i++) {
			String text = dates.get(i).getText();

			if (text.equalsIgnoreCase("4")) {
				dates.get(i).click();
				break;
			}
		}
	}

	@Test(dependsOnMethods = { "flightBooking" })
	public void selectPassengers() throws InterruptedException {

		PHPFlightBookingPage passSelection = new PHPFlightBookingPage(driver1);

		passSelection.Guests().click();
		WebDriverWait wait = new WebDriverWait(driver1, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("madult")));

		Select AdultDropdown = new Select(passSelection.Adult());

		AdultDropdown.selectByValue("2");

		Select ChildrenDropdown = new Select(passSelection.Children());

		ChildrenDropdown.selectByValue("2");

		passSelection.Done().click();

		Thread.sleep(1000);

		Actions a = new Actions(driver1);
		a.sendKeys(Keys.TAB);
		a.sendKeys(Keys.ENTER).build().perform();

	}
	
	@AfterTest
	public void close() throws IOException {

		driver1.close();

	}


	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "user@phptravels.com", "demouser" }, };

	}
}