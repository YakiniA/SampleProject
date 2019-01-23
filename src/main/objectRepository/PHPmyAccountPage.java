package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PHPmyAccountPage {

	WebDriver driver;
	
	   public PHPmyAccountPage(WebDriver driver){
			this.driver = driver;
		}
	  By flightTab = By.xpath("//span[contains(text(),'Flights')]");
	  
	  public WebElement flightTab() {
			return driver.findElement(flightTab);
		}

}
