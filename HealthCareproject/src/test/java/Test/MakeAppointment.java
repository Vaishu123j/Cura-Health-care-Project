package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Main.AppointmentPage;
import Main.BaseTest;
import Main.LoginPage;


public class MakeAppointment extends BaseTest{
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
	 driver = intialization();
	}
	
	@Test
	public void MakeAppointmentTest() throws Exception {
	
	LoginPage loginPage = new LoginPage(driver);
	 loginPage.clickmakeappointmentbtn();
     loginPage.EnterUsername("John Doe");
     loginPage.EnterPassword("ThisIsNotAPassword");
     loginPage.ClickLogin();

     AppointmentPage makeAppointmentPage = new AppointmentPage(driver);
     makeAppointmentPage.selectFacilityList();
     makeAppointmentPage.clickApplyCheckbox();
     makeAppointmentPage.selectMedicaidRadioButton();
     makeAppointmentPage.selectVisitDate();
     makeAppointmentPage.fillCommentField("I want make appointment of dr sarojini");
     makeAppointmentPage.clickBookAppointmentButton();

	}
	
	@Test
	public void verifyAppointmentmsg() {
	
		boolean msg = driver.findElement(By.xpath("*[@id=\"summary\"]/div/div/div[1]/h2")).isDisplayed();
		if (msg = true) {
			System.out.println(
					msg + ": " + driver.findElement(By.xpath("*[@id=\"summary\"]/div/div/div[1]/h2")).getText());
		} else {
			System.out.println("Not displayed");
		}

	}
	
	@Test(dependsOnMethods = "MakeAppointment")
	public void verifyAppointmentConfirmation() {
		
		WebElement goToHomePageButton = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
		Assert.assertEquals(true, goToHomePageButton.isDisplayed(), "Go to HomepageButton is not present");

	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	


}
