package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search1 {
	
	public WebDriver driver;
	By search=By.id("search_query_top");
	By searchbutton=By.xpath("(//button[@type='submit'])[1]");
	
	

	
  public Search1(WebDriver driver) {
		this.driver=driver;
	}

  public WebElement getsearch()	{
	return driver.findElement(search);
	  
  }
	public WebElement getsearchbutton() {
		return driver.findElement(searchbutton);
		
	}

}
