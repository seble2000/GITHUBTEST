package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	public WebDriver driver;
	By gender=By.id("id_gender2");
	By first=By.id("customer_firstname");
	By last=By.id("customer_lastname");
	By pass=By.id("passwd");
	By date=By.xpath("//select[contains(@id,'days')]");
	By month=By.xpath("//select[contains(@id,'months')]");
	By year=By.id("years");
	
	By company=By.id("company");
	By address=By.id("address1");
	By city=By.id("city");
	By state=By.id("id_state");
	By zip=By.id("postcode");
	By country=By.id("id_country");
	By phone=By.id("phone_mobile");
	By register=By.id("submitAccount");
	By proceed3=By.xpath("//button[@name='processAddress']");
  public RegistrationPage(WebDriver driver) {
	  this.driver=driver;
  }
  
  public void register() {
	  driver.findElement(gender).click();
	  driver.findElement(first).sendKeys("james");
	  driver.findElement(last).sendKeys("soresa");
	  driver.findElement(pass).sendKeys("123456");
	  driver.findElement(date).sendKeys("9");
	  driver.findElement(month).sendKeys("february");
	  driver.findElement(year).sendKeys("1990");
	  driver.findElement(company).sendKeys("craft");
	  driver.findElement(address).sendKeys("1029 w jefferson");
	  driver.findElement(city).sendKeys("chicago");
	  driver.findElement(state).sendKeys("Illinois");
	  driver.findElement(zip).sendKeys("34567");
	  //driver.findElement(country).click();
	  driver.findElement(phone).sendKeys("12345678");
	  driver.findElement(register).click();
	  driver.findElement(proceed3).click();
  }
  
  
}
