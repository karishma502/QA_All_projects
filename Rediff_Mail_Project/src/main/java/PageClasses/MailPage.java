package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;


public class MailPage extends PageBaseClass {

	
	public MailPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		
	}

	@FindBy(xpath = "//li[@class='rd_write']")
	public WebElement writemail;

	public MailWritePage clickwritemail() {
		logger.log(Status.INFO, "Clicking the  write mail link");
		writemail.click();
		logger.log(Status.PASS, "Clicked the Write Mail Link");
		MailWritePage mailwritepage = new MailWritePage(driver, logger);
		PageFactory.initElements(driver, mailwritepage);
		return mailwritepage;
		
	}

}
