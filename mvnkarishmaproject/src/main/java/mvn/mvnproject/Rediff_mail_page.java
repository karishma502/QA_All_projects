package mvn.mvnproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff_mail_page {
	
	public static void main(String args[]) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\c# notes\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Rediffmail')]")).click();
		
		WebElement username = driver.findElement(By.id("login1"));
		username.sendKeys("karishma_kate");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Admin@123");
		
		//Click to The Sign In Button
		
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		System.out.println("Click the sign In Button");
		
		//*********************** write mail click
		driver.findElement(By.xpath("//li[@class='rd_write']")).click();
		System.out.println("Click the Write Mail Button");
		
		//  ***********click The To Button
		WebElement to = driver.findElement(By.xpath("//input[starts-with(@id,'TO_ID')]"));
		//CSS selector - input.rd_inp_to.as-input
		//xpath - //input[@class='rd_inp_to as-input']
		to.sendKeys("karishmakate31@gmail.com");
		System.out.println("Add To ");
		//  ***********click The Subject Button
		
		WebElement subject = driver.findElement(By.xpath("//li[@class='fld_sub']/input[1]"));
		subject.sendKeys("Regarding Something");
		System.out.println("Write Subject Successfully");
		
		//  ***********click The Subject Button
 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		WebElement Message = driver.findElement(By.xpath("//body"));
		////iframe[@class='cke_wysiwyg_frame cke_reset']
		Message.sendKeys("Hello Karishma , Welcome To Zensar......");
		driver.switchTo().defaultContent();
		System.out.println("Messange Write...");
		
		//  ***********click The Subject Send
		driver.findElement(By.xpath("//a[@class='send_ng_compo rd_btn_cmp_send']")).click();
		System.out.println("Click the Send Button");
		
		
	}
}
