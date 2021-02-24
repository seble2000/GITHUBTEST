package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dresspage{

	public WebDriver driver;
	

	By quantity=By.xpath("//i[contains(@class,'icon-plus')]");
	By quantityclear=By.xpath("//input[@name='qty']");
	By quantity1=By.xpath("//input[@name='qty']");
	By size=By.xpath("//select[contains(@id,'group_1')]");
	By color=By.id("color_15");
    By addcart=By.xpath("(//button[@type='submit'])[3]");
	By continueshop=By.xpath("(//span[contains(.,'Continue shopping')])[1]");

public Dresspage(WebDriver driver) {
	
		this.driver=driver;	
		}

//		public void getquantity()
//	{
//	int i=1;
//	while(i<3) {
//		driver.findElement(quantity).click();
//		i++;
//	}
  public WebElement getquantityclear() {
	return driver.findElement(quantityclear);
	
}
	public WebElement getquantity1() {
		return driver.findElement(quantity1);
		
	}
		
	public void getsize() {
		Select s=new Select(driver.findElement(size));
		s.selectByIndex(2);
	}
	public void getcolor()
	{
//		JavascriptExecutor j=(JavascriptExecutor)driver;
//		j.executeScript("document.getElementBy('color').value='#A0D468'");
		driver.findElement(color).click();
	}

	public void getaddcart() {
		driver.findElement(addcart).click();
	}
	
	public void getcontinueshop()
	{
		driver.findElement(continueshop).click();
	}
	
	
	
	
	}
	

