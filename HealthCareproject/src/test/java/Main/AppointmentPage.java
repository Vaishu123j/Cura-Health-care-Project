package Main;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
	WebDriver driver;
	
    @FindBy(id="combo_facility") public WebElement facilityDropdownList;
    @FindBy(id="chk_hospotal_readmission")public WebElement applyCheckbox;
    @FindBy(id="radio_program_medicaid")public WebElement medicareRadioButton;
    @FindBy(id="radio_program_none")public WebElement noneRadioButton;
    @FindBy(id="txt_visit_date")public WebElement visitDateCalendar;
    @FindBy(id="txt_comment")public WebElement commentField;
    @FindBy(id="radio_program_medicaid")public WebElement medicaidRadioButton;
    @FindBy(id="btn-book-appointment")public WebElement bookAppointmentButton;
    


    public AppointmentPage(WebDriver driver) {
        this.driver =driver;
    }
    public void selectFacilityList(){

        Select objSelect = new Select(facilityDropdownList);
        objSelect.selectByVisibleText("Seoul CURA Healthcare Center");
    }

    public void clickApplyCheckbox(){
        applyCheckbox.click();
    }

    public void selectMedicareRadioButton(){
       medicareRadioButton.click();
    }

    public void selectMedicaidRadioButton(){
        medicaidRadioButton.click();
    }

    public void selectNoneRadioButton(){
        noneRadioButton.click();
    }

    public void selectVisitDate() throws ParseException {

        By nextArrow = By.cssSelector(".datepicker-days .next");
        By monthPicker = By.cssSelector(".datepicker-days .datepicker-switch");

        visitDateCalendar.click();
       
        String mOnth = "December 2023";
        String dAy = "15";

        visitDateCalendar.click();

        while (true){
            String text = driver.findElement(monthPicker).getText();
            if (text.equals(mOnth)){
                break;
            }
            else {
                driver.findElement(nextArrow).click();
            }
        }
        driver.findElement(By.xpath("//tbody/tr/td[contains(text(), " + dAy + ")]")).click();
    }

    public void fillCommentField(String Comment){
    	commentField.sendKeys(Comment);
    }

    public void clickBookAppointmentButton() {
        (bookAppointmentButton).click();
    }
}





