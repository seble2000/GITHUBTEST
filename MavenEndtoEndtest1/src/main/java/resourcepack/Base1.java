package resourcepack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base1 {
	
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		
		FileInputStream f=new FileInputStream("/Users/seblegetu/eclipse-workspace/MavenEndtoEndtest1/src/main/java/resourcepack/data.properties");
		 
		prop.load(f);
		 
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			 
			 driver=new ChromeDriver();
			 
		 }
		 else if(browsername.equals("FireFox")){
			 driver=new FirefoxDriver();
			 
		 }
		 else if(browsername.equals("IE")) {
			 //IE
		 }
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   return driver;
	
	}
	
	
	
	
	
	

}
