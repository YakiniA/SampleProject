package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PHPFlightBookingPage {

	WebDriver driver;

	public PHPFlightBookingPage(WebDriver driver) {
		this.driver = driver;
	}

	By fromInput = By.xpath("/html[1]/body[1]/div[16]/div[1]/input[1]");
	By fromCity = By.xpath("//div[@id='s2id_location_from']//a//span[1]");
	By toCity = By.xpath("//div[@id='s2id_location_to']//a//span[1]");
	By departure = By.xpath("//input[@name='departure']");
	By arrival = By.name("arrival");
	By month = By.xpath("/html[1]/body[1]/div[14]/div[1]/table[1]/thead[1]/tr[1]/th[2]");
	By next = By.xpath("/html[1]/body[1]/div[14]/div[1]/table[1]/thead[1]/tr[1]/th[3]");
	By date = By.className("day");
	By travelGuests = By.name("totalManualPassenger");
	By madult = By.name("madult");
	By mchildren = By.name("mchildren");
	By clickDone = By.id("sumManualPassenger");
	By search = By.xpath("//form[@name='fCustomHotelSearch']//div[5]//button");

	public WebElement Search() {
		return driver.findElement(search);
	}

	public WebElement Done() {
		return driver.findElement(clickDone);
	}

	public WebElement Adult() {
		return driver.findElement(madult);
	}

	public WebElement Children() {
		return driver.findElement(mchildren);
	}

	public WebElement Guests() {
		return driver.findElement(travelGuests);
	}

	public WebElement FromInput() {
		return driver.findElement(fromInput);
	}

	public WebElement FromCity() {
		return driver.findElement(fromCity);
	}

	public WebElement ToCity() {
		return driver.findElement(toCity);
	}

	public WebElement Departure() {
		return driver.findElement(departure);
	}

	public WebElement Arrival() {
		return driver.findElement(arrival);
	}

	public WebElement Month() {
		return driver.findElement(month);
	}

	public WebElement Next() {
		return driver.findElement(next);
	}

	public List<WebElement> Date() {
		return driver.findElements(date);
	}
}
