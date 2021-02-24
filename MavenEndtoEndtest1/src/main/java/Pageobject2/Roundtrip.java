package Pageobject2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Roundtrip {

	public WebDriver driver;
	
	By round=By.xpath("(//span[contains(@class,'checkmark--2DHJD')])[1]");
	By departure=By.id("bookFlightOriginInput");
	By arrival=By.id("bookFlightDestinationInput");
	By departDate=By.id("DepartDate");
	By returnd=By.id("ReturnDate");
	
	
	
	public Roundtrip(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement getround() {
		return driver.findElement(round);
		
	}
	public WebElement depart() {
		return driver.findElement(departure);
		
}
//	public void depart() {
//		WebElement box =driver.findElement(departure);
//		box.clear();
//		box.sendKeys("DCA");
//		box.sendKeys(Keys.ENTER);
//	}
	public WebElement arrive() {
		return driver.findElement(arrival);
		
	}
	public void DepartDate() {
//		WebElement date=driver.findElement(departDate);
//		date.clear();
//		date.sendKeys("Mar 02");
//		date.sendKeys(Keys.TAB);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("document.getElementById('DepartDate').value='Mar 02'");	
		
		
	}
	public void returndate() {
           JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("document.getElementById('ReturnDate').value='Mar 30'");
	}
	
}