package tng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Multple_Browser {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\HP\\Desktop\\c# notes\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\c# notes\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//enter website
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void login() throws InterruptedException{
		//click to gmail
		driver.findElement(By.linkText("Gmail")).click();
		//driver.findElement(By.xpath("//*[@id=\'gb\']/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void afterTest() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
	}
	

}
