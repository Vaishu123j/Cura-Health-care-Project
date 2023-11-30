package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	@FindBy(id = "btn-make-appointment")
	public WebElement makeappointment;
	@FindBy(xpath = "//input[@id='txt-username']")
	public WebElement username;
	@FindBy(xpath = "//input[@id='txt-password']")
	public WebElement password;
	@FindBy(id = "btn-login")
	public WebElement login;
	@FindBy(xpath = "//*[@id=\"login\"]/div/div/div[2]/form/div[2]/label")
	public WebElement usernametitle;
	@FindBy(xpath = "//*[@id=\"login\"]/div/div/div[2]/form/div[3]/label")
	public WebElement passwordtitle;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickmakeappointmentbtn() {
		if (makeappointment != null) {
			makeappointment.click();
		} else {
			System.out.println("Make Appointment button not found.");
		}

	}

	public void EnterUsername(String Username) {
		username.sendKeys(Username);
	}

	public void EnterPassword(String Password) {
		password.sendKeys(Password);
	}

	public void ClickLogin() {
		login.click();
	}

	public void verifyusername() {
		if (usernametitle.isDisplayed()) {
			System.out.println("subscription text is visible:" + usernametitle.getText());
		} else {
			System.out.println("subscription text is not visible");
		}
	}

	public void verifypassord() {
		if (passwordtitle.isDisplayed()) {
			System.out.println("subscription text is visible:" + passwordtitle.getText());
		} else {
			System.out.println("subscription text is not visible");
		}
	}

}
