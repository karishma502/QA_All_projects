package TestCases;



import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import PageClasses.LandingPage;
import PageClasses.MailPage;
import PageClasses.MailWritePage;
import PageClasses.RediffEmailLogin;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import utilities.ConstantValue;


public class MailTest extends BaseTestClass{
	LandingPage landingPage;
	MailPage mailpage;
	MailWritePage mailwritepage;
	RediffEmailLogin redifflogin ;
	
	
	@Test
	public void mailsendRediff() throws InterruptedException{
		logger = report.createTest("Add Mail: ");
		
		invokeBrowser("chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		redifflogin = landingPage.clickrediffmail();
		//waitForPageLoad();
		Thread.sleep(20000);
		mailpage = redifflogin.doLogin(ConstantValue.userName, ConstantValue.password);
		Thread.sleep(10000);
		//waitForPageLoad();
	
		mailwritepage =	mailpage.clickwritemail();
		
		mailwritepage.to_text("karishmakate31@gmail.com");
		mailwritepage.subject_method("Regarding Something");
		//mailwritepage.msg_method("mail you karishma");
		pageBase.switchframe(driver,"//iframe[@class='cke_wysiwyg_frame cke_reset']");
		mailwritepage.msg_method("Welcome Back");
		pageBase.switchtodefualt();
		//driver.switchTo().defaultContent();
		mailwritepage = mailwritepage.submitMail();
		
		waitForPageLoad();
	
		
		
	}
	
	

}
