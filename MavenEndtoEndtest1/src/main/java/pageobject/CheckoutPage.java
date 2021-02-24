package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;
	
	  By checkoutBox=By.id("cgv");
	  By proceed4=By.xpath("(//button[@type='submit'])[2]");
	  By check=By.xpath("(//p[contains(@class,'module')])[2]");
      By confirm=By.xpath("(//button[@type='submit'])[2]");
   public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}


public void getcheckout() {
	 driver.findElement(checkoutBox).click();
	 driver.findElement(proceed4).click();
	 driver.findElement(check).click();
	 driver.findElement(confirm).click();
}
}