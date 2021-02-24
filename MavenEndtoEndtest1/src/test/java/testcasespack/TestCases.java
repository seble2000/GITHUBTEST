package testcasespack;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageobject.CheckoutPage;
import pageobject.Dresspage;
import pageobject.LoginPage;
import pageobject.QuantityPage;
import pageobject.RegistrationPage;
import pageobject.Search1;
import pageobject.TshirtPage;
import resourcepack.Base1;

public class TestCases extends Base1 {
	    ExtentReports extent;
	    ExtentTest extentTest;
	   
	    
		@BeforeMethod
		 public void setup() throws IOException
		 {
			  driver =initializeDriver();
			 //driver=new ChromeDriver();
			 driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		     driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		     driver.get("http://automationpractice.com/index.php");
		     
		 }  
		 @BeforeTest
	     public void setExtent()
	     {
	    	 extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);//location for extentrepo
	    	 extent.addSystemInfo("Host Name", "Seble Mac");
	    	 extent.addSystemInfo("User Name", "Seble");
	    	 extent.addSystemInfo("Environment", "QA");
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
		
	  
		     @AfterMethod
		     public void teardown(ITestResult result) throws IOException
		    {
		     if(result.getStatus()==ITestResult.FAILURE)	{
		     	extentTest.log(LogStatus.FAIL, "test case failed is "+result.getName());//to add name in extent report
		     	extentTest.log(LogStatus.FAIL, "test case failed is "+result.getThrowable());//to add error and exception in report
		     	String screenshotpath=TestCases.getScreenshot(driver,result.getName());
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
		     @AfterTest
		     public void endReport()
		     {
		     	extent.flush();
		     	extent.close();
		     }
		     
	    
	    
	@Test
	public void navigate() throws IOException, InterruptedException {
	  extentTest=extent.startTest("navigate");
	
	  Search1 s=new Search1(driver);
	  s.getsearch().sendKeys("dresses");
	  s.getsearchbutton().click();
	  
	  QuantityPage q=new QuantityPage(driver);
	  q.getsort();
	  q.getimage().click();
	  Thread.sleep(3000);
	  Dresspage c=new Dresspage(driver);
      //c.getquantity();
	  c.getquantityclear().clear();
	  c.getquantity1().click();
	  c.getquantity1().sendKeys("3");
	  c.getsize();
	  c.getcolor();
	  c.getaddcart();
	  c.getcontinueshop();
	  
	  TshirtPage t=new TshirtPage(driver);
	  t.getsearch1();
	  t.getsearchbutton2();
	  t.getimage2().click();
	  Thread.sleep(3000);
	  t.getquantity();
	  Thread.sleep(3000);
	  t.getcolor();
	  t.getsize();
	  t.getaddcart2();
	  t.getproceed();
	  t.getproceed2();
	  LoginPage log=new LoginPage(driver);
	  log.getcreate();
	  log.getbutton();
	  RegistrationPage reg=new RegistrationPage(driver);
	  reg.register();
	  CheckoutPage ck=new CheckoutPage(driver);
	  ck.getcheckout();
	}
	


}
