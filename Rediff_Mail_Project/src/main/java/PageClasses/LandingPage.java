package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;


public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//a[contains(text(),'Rediffmail')]")
	public WebElement rediffmail;
	
	

	public RediffEmailLogin clickrediffmail() {
		logger.log(Status.INFO, "Clicking the Money Link, Present in Header");
		rediffmail.click();
		logger.log(Status.PASS, "Clicked the Rediff mail");
		RediffEmailLogin redifflogin = new RediffEmailLogin(driver, logger);
		PageFactory.initElements(driver, redifflogin);
		return redifflogin;
	}

	
}
