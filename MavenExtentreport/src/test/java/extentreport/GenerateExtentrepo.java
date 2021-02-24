package extentreport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class GenerateExtentrepo {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest extentTest;
    
    @BeforeTest
     public void setExtent()
     {
    	 extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);//location for extentrepo
    	 extent.addSystemInfo("Host Name", "Seble Mac");
    	 extent.addSystemInfo("User Name", "Seble");
    	 extent.addSystemInfo("Environment", "QA");
     }
    @AfterTest
    public void endReport()
    {
    	extent.flush();
    	extent.close();
    }
    
    public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
    	String dateName=new SimpleDateFormat("yyyyMMddmmss").format(new Date());
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source =ts.getScreenshotAs(OutputType.FILE);
    	//after execution, you could see a folder "failedtestsscreenshots" under src folder
    	String destination =System.getProperty("user.dir")+"/Failedtestsscreenshots"+ screenshotName+dateName+",png";//location for screenshot
    	File finalDestination=new File(destination);
    	FileUtils.copyFile(source,finalDestination);
    	return destination;
    	
    }
    @BeforeMethod
    public void setup()
    {
    	//systemfor you guys
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	driver.get("https://www.freecrm.com/");
    }
    @Test
    public void freeCrmtitletest()
    {
    	extentTest=extent.startTest("freeCrmtitletest");
    	String title= driver.getTitle();
    	System.out.println(title);
    	Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud111");//failed
    }
    @Test
    public void freeCrmlogotest()
    {
    	extentTest=extent.startTest("freeCrmlogotest");
    	boolean b=driver.findElement(By.xpath("(//a[@class='brand-name'])[2]")).isDisplayed();
    	Assert.assertTrue(b);
    
    }
    @AfterMethod
    public void teardown(ITestResult result) throws IOException
   {
    if(result.getStatus()==ITestResult.FAILURE)	{
    	extentTest.log(LogStatus.FAIL, "test case failed is "+result.getName());//to add name in extent report
    	extentTest.log(LogStatus.FAIL, "test case failed is "+result.getThrowable());//to add error and exception in report
    	String screenshotpath=GenerateExtentrepo.getScreenshot(driver,result.getName());
    	extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screenshotpath));//to add screenshotin extent report or addscreencast for video
    	//extentTest.log(LogStatus.FAIL,extentTest.addScreencast(screenshotpath));
    }
    else if(result.getStatus()==ITestResult.SKIP) {
    	extentTest.log(LogStatus.SKIP, "test case skipped is "+result.getName());
    }
    else if(result.getStatus()==ITestResult.SUCCESS)
    {
    	extentTest.log(LogStatus.PASS, "test case passed is "+result.getName());
    }
    extent.endTest(extentTest);//ending test and ends the current test and prepare to create html report
    driver.quit();
    }
    
    
    }

