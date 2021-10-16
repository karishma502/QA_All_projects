package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;


public class MailWritePage extends PageBaseClass {

	public MailWritePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		
	}

	@FindBy(xpath = "//input[starts-with(@id,'TO_ID')]")
	//input[starts-with(@id,'TO_ID')]
	public WebElement to;

	@FindBy(xpath = "//li[@class='fld_sub']/input[1]")
	//li[@class='fld_sub']/input[1]
	public WebElement subject;

	@FindBy(xpath = "//body")
	public WebElement msgbody;

	@FindBy(xpath = "//a[@class='send_ng_compo rd_btn_cmp_send']")
	////a[@class='send_ng_compo rd_btn_cmp_send']
	public WebElement send;


	
	public void to_text(String tobtn){
		to.sendKeys(tobtn);
		logger.log(Status.PASS, "Entered the To : " + tobtn);
	}
	
	public void subject_method(String subbtn){
		subject.sendKeys(subbtn);
		logger.log(Status.PASS, "Entered the Subject" + subbtn);
	}
	
	public void msg_method(String msg){
		msgbody.sendKeys(msg);
		logger.log(Status.PASS, "Entered the Password : " + msg);
	}
	
	public MailWritePage submitMail(){
		send.click();
		logger.log(Status.PASS, "Cliecked the Send Button");
		MailWritePage mailwritepage = new MailWritePage(driver, logger);
		PageFactory.initElements(driver, mailwritepage);
		return mailwritepage;
	}
	
	

}
