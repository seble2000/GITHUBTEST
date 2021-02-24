package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TshirtPage {
	
	public WebDriver driver;
	By search1=By.id("search_query_top");
	By searchbutton2=By.xpath("(//button[@type='submit'])[1]");
	//By Tshirt=By.xpath("(//a[@title='T-shirts'])[2]");
	By image2=By.xpath("(//img[@class='replace-2x img-responsive'])[2]");
	By quantity2=By.xpath("//i[contains(@class,'icon-plus')]");
	By size2=By.xpath("//select[contains(@id,'group_1')]");
	By color2=By.id("color_13");
	By addcart2=By.xpath("(//button[@type='submit'])[3]");
    By proceed=By.xpath("//a[@title='Proceed to checkout']");
	By Proceed2=By.xpath("(//a[@title='Proceed to checkout'])[2]");
	
	public TshirtPage(WebDriver driver) {
		this.driver=driver;
	}
    
	public void getsearch1() {
		driver.findElement(search1).sendKeys("T-SHIRTS");
	}
	public void getsearchbutton2() {
		driver.findElement(searchbutton2).click();
	}
	
	
	
	public WebElement getimage2()
	{
		return driver.findElement(image2);
		
	}
	
	public void getquantity() {
		
	int i=1;
	while(i<3) {
		driver.findElement(quantity2).click();
		i++;
	}
	}
	
	public void getsize()
	{
		Select s=new Select(driver.findElement(size2));
		s.selectByIndex(2);
		
	}
	public void getcolor() {
		driver.findElement(color2).click();
	}
	public void getaddcart2() {
		driver.findElement(addcart2).click();
	}
	public void getproceed() {
		driver.findElement(proceed).click();
	}
	public void getproceed2() {
		driver.findElement(Proceed2).click();
	}
}
