package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class QuantityPage {
	
	public WebDriver driver;
	
	
	By sort=By.xpath("//select[@id='selectProductSort']");
	By image=By.xpath("(//img[contains(@src,'default.jpg')])[1]");
	
	public QuantityPage(WebDriver driver) {
		this.driver=driver;
	}


	public void getsort() {
		
   Select s=new Select(driver.findElement(sort));
		   s.selectByValue("price:desc");
	}
	//public void getimage() {driver.findelement.click}
  public WebElement getimage()
  {
	return driver.findElement(image);
	  
  }
}
