package craftsoftware;

import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentRepo {
	
   public WebDriver driver;
   //EXtentHtmlReporter Html;
   ExtentReports extent;//specify the location of the object
   ExtentTest test;//what detais should be populated on the report
   
   
   
   @BeforeTest
   
   public void startReport() {
	  extent =new ExtentReports(System.getProperty("user.dir")+ "test-output/MyOwnReport.html", true);
	  extent.addSystemInfo("Host Name" , "LocalHost");
	   extent.addSystemInfo("Environment", "QA");
	   extent.addSystemInfo("User Name", "sebli");
	   
	  // extent.loadConfig(new File(System.getProperty("user.dir"+"\\extent.config.xml")));
 }
   
   @Test
   public void demoReportpass()
   {
	   test=extent.startTest("demoReportpass");
	   Assert.assertTrue(true);
	   test.log(LogStatus.PASS, "Assert pass as condition is true");
   }
   @Test
   public void demoReportfail()
   {
	   test=extent.startTest("demoReportpass");
	   Assert.assertTrue(false);
	   test.log(LogStatus.FAIL, "Assert fail as condition is false");
	   
   }
  @AfterMethod
  public void getResult(ITestResult result)
  {
	  if(result.getStatus()==ITestResult.FAILURE) {
		  test.log(LogStatus.FAIL, result.getThrowable());
	  }
	  //extent.endTest(test);
	  extent.endTest(test);
	  
  }
  @AfterTest
  public void endreport()
  {
	  extent.flush();
  }
 
  }


