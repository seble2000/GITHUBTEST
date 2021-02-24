package craftsoftware;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Screenshot {

	public static void main(String[] args) throws IOException {
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https:www.ethiopianairlines.com");
	
	Date currentdate =new Date();
    System.out.println(currentdate);
  String screenshotfilename=currentdate.toString().replace(" ", "-").replace(":", "-");
    System.out.println( screenshotfilename);
	
	File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	  FileUtils.copyFile(screenshotFile, new File(".//screenshot/screen.png"));
	  FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+ screenshotfilename+".png"));
	
	}
}
