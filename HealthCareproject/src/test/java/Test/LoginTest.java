package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Main.BaseTest;
import Main.LoginPage;


public class LoginTest extends BaseTest{
	WebDriver driver;
	LoginPage p;

	@BeforeMethod
	public void setup() {
		driver = intialization();
	}
	

	@Test(priority = 1)
	public void loginTest() {
		LoginPage p = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		p.clickmakeappointmentbtn();
		p.verifyusername();
		p.verifypassord();
	}

	@Test(priority =2)
	public void LoginwithvalidCredential() {
		LoginPage p = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		p.EnterUsername("John Doe");
		p.EnterPassword("ThisIsNotAPassword");
		boolean msg = driver.findElement(By.xpath("[@id=\"appointment\"]/div/div/div/h2")).isDisplayed();
		if (msg = true) {
			System.out.println(
					msg + ": " + driver.findElement(By.xpath("[@id=\"appointment\"]/div/div/div/h2")).getText());
		} else {
			System.out.println("Not displayed");
		}
		driver.close();

	}

	@Test(priority=3)
	public void InavalidCredential() {
		LoginPage p = new LoginPage(driver);
		p.clickmakeappointmentbtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		p.EnterUsername("Doe");
		p.EnterUsername("12345");
		boolean msg = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).isDisplayed();
		if (msg = true) {
			System.out.println(
					msg + ": " + driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText());
		} else {
			System.out.println("Not displayed");
		}
		driver.close();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}



