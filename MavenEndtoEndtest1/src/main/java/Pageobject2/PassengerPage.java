package Pageobject2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PassengerPage {

	public WebDriver driver;
	By passenger=By.xpath("(//button[contains(@type,'button')])[12]");
	By adultbutton=By.xpath("(//button[@type='button'])[14]");
	By senior=By.xpath("(//button[@type='button'])[16]");
	By economy=By.xpath("//button[contains(@id,'cabinType')]");
	By search=By.xpath("(//button[@type='submit'])[1]");
	public PassengerPage(WebDriver driver2) {
		this.driver=driver2;
	}

   public void getpass() {
		driver.findElement(passenger).click();
	}
	
	public void gettotalnumber() {
		int i=1;
		while(i<2) {
			driver.findElement(adultbutton).click();
			i++;
		}
		int j=0;
		while(j<2) {
			driver.findElement(senior).click();
			j++;
		}

			
}
			
		public void geteconomy() {
			driver.findElement(economy).click();;
			driver.findElement(economy).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(economy).sendKeys(Keys.ENTER);
		}
			
		public void getsearch() {
			driver.findElement(search).click();
		}
			
			
		}
		
	

