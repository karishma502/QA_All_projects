package mvn.mvnproject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Rediff_LogIn {

	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;//name you can define
	//Classes from extent reports
	//Above class is Responsible for look and feel of the report 
	
	public ExtentReports extent;
	//Used to create entries in the report - for every TC we need to make an entry
	
	public ExtentTest test;
	// Used to update status in the report  - PASS / fail / skip 
	

	@BeforeTest
	public void setExtent() {
		
		//Setup method for extent reports
		// specify location of the report
		//You can give before class - if only one testcase;
		//Else before test - before all tests
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Extend_Report/myReport.html");
		//"C:\\worksoft\\test"
		//Create an instance of the class
		//Where to create the HTML report
		
		//htmlReporter.
		htmlReporter.config().setDocumentTitle("Oct 7th "); // Tile of report - you can change
		htmlReporter.config().setReportName("Functional Testing"); // Name of the report - you can change
		htmlReporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
		
		//Add additional info - tested by / user name / browser used etc. 
		extent.attachReporter(htmlReporter);
		//Attached the htmlreporter to the extent object

		// Passing General information
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Karishma");
		extent.setSystemInfo("OS","Windows 10");
		extent.setSystemInfo("Demo", "Extent Reports");
		extent.setSystemInfo("My Fav movie", "Shershaha");
		
		//Pass key-value pairs for extent object in setSystemInfo 
		//Same method can be used multiple times SSI
		//The key-value pairs are user defined - we can add as much details as we want
		//Details are populated in the extent report
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\c# notes\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
	}
	
	@Test
	public void redifftitletest() {
		test = extent.createTest("TestTile");
		//Create this test object, so that ER knows that this is the test
		String title = driver.getTitle();
		System.out.println(title);
		//Logging here, so that debugging will be easier later on
		//in case of failure / issues 
		//also, logging will help in understanding flow for new users
		test.log(Status.INFO, "test.log - INFO - checking title in this test");
		Assert.assertEquals(title, "Extend Report -  Wrong");
		//above assert would fail since title is different		
		
	}

	@Test
	public void rediffmoneytest() {
		test = extent.createTest("MoneyTest");
		//Create this test object, so that ER knows that this is the test
		driver.findElement(By.cssSelector(".moneyicon ")).click();
	
	}
	
	@Test
	public void rediffmoneyLoginTest(){
		test = extent.createTest("LoginTest");
		boolean b = driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).isDisplayed();
		test.log(Status.INFO, "test.log - INFO  - Checking the demo store image");
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		//ITestResult - will have result of the test execution 
		//After completion of every method this method will run
		//Result variable will contain result of previous method executed
		//result.g
		//ITestResult.
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			//test.log - logs result in the Extent Report
			
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
			String screenshotPath = NopCommerceTest.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	

}
