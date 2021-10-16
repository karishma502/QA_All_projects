package tng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testing_Check {
	
	//create 2 java file with 2 functions each
	
		//update testng.xml - and execute all the 3 java files
	@Test(groups="smoke")
	public void add_cust() {
		System.out.println("Test Done");
	}
	
	//create 2 more function 
	@Test
	public void add_cust2() {
		System.out.println("Add Second Function Successfully...");
	}
	
	@Test
	public void add_cust3() {
		System.out.println("Add Third Function Successfully...");
	}
	
	@Test(enabled=false)
	public void add_cust4() {
		System.out.println("Igonre This method");
	}
	
	
	//Adding before method and after method
	
	@BeforeMethod
	public void bm() {
		System.out.println("Before method called..");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("After method called..");
	}
	
	//Adding before class and after class
	
	@BeforeClass
	public void bc() {
		System.out.println("Before Class called..");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("After Class called..");
	}
	
	//Adding before suite and after suite
	
	@BeforeSuite
		public void bs() {
			System.out.println("Before suite called..");
		}
		
	@AfterSuite
		public void as() {
			System.out.println("After suite called..");
		}

}
