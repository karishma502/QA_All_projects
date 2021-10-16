package mvn.mvnproject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame_Actions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\HP\\\\Desktop\\\\c# notes\\\\selenium\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/droppable/");
		
		
		//driver.findElement(By.id("draggable")).click();
		
		//We can either use # of frame or string (id, if known) or webelement - using webelement here
		
		
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		driver.findElement(By.id("draggable")).click();
		//driver.switchTo().frame
		

		//For interactions, actions class is used - D & D etc.
		Actions act = new Actions(driver);
		
		WebElement source1 = driver.findElement(By.id("draggable"));
		WebElement target1= driver.findElement(By.id("droppable"));
		
		//for Drag and drop - source and target are parameters
		act.dragAndDrop(source1, target1).build().perform();
		Thread.sleep(10000);
		//act.
		
		// driver.findElement(By.id("draggable")).click();
		
		//act.contextClick(source1).build().perform();
		

				
		//To get focus back to main area, need to give switch to default content
		//else, focus will remain in frame and any command would go to the frame
		driver.switchTo().defaultContent();
		
		Actions act2 = new Actions(driver);
		
		WebElement target2= driver.findElement(By.xpath("//h2[contains(text(),'Examples')]"));
		//WebElement target2= driver.findElement(By.xpath("//p[contains(text(),'Enable any DOM element to be droppable, a target f')]"));
		act2.doubleClick(target2).build().perform();	
		//act2.
		//act2.contextClick().build().perform();
		
		
	
		System.out.println("End of Code");

		/*
		System.out.println("Number of frames is :");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
			*/

		
		
	}
/*
	public void switchframe(WebDriver driver, String identifier) {
		driver.switchTo().frame(driver.findElement(By.className(identifier)));
	}
	*/
}

