package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPHomePage {

	WebDriver driver;

	public PHPHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]")
	public WebElement myAccount;
	
	@FindBy(linkText = "Login")
	public WebElement login;

	@FindBy(xpath = "//*[@type='email']")
	public WebElement email;

	@FindBy(xpath = "//*[@type='password']")
	public WebElement password;

	@FindBy(css = "[type='submit']")
	public WebElement submit;

	public WebElement myAccount() {
		return myAccount;
	}

	public WebElement LoginPage() {
		return login;
	}

	public WebElement Email() {
		return email;
	}

	public WebElement Password() {
		// TODO Auto-generated method stub
		return password;
	}

	public WebElement Login() {
		// TODO Auto-generated method stub
		return submit;
	}
}