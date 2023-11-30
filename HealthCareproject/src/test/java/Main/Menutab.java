package Main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menutab {
WebDriver driver;
	
	public void verifytheMenuList() {
		
	 List<WebElement> menuItems = driver.findElements(By.cssSelector("//*[@id=\"menu-toggle\"]"));
     // Iterate through each menu item and click it
     for (WebElement menuItem : menuItems) {
         String menuItemText = menuItem.getText();
         System.out.println("Clicking on menu item: " + menuItemText);
         menuItem.click();

         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         driver.navigate().back();
         menuItems = driver.findElements(By.cssSelector("//*[@id=\"menu-toggle\"]"));
     }
	}

}
