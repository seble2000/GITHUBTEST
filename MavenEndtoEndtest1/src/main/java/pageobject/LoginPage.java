package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	By create=By.xpath("//input[@id='email_create']");
	By createbutton=By.xpath("//button[@id='SubmitCreate']");
	
	
   public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
  public void getcreate() {
	   driver.findElement(create).sendKeys("lgett@gmail.com");
   }
   public void getbutton() {
	   driver.findElement(createbutton).click();
   }
}
