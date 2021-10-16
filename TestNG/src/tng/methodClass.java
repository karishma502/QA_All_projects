package tng;

import org.testng.annotations.Test;

public class methodClass {
	@Test
	public void add_cust() {
		System.out.println("Customer Added");
	}
	
	//create 2 more function 
	@Test
	public void EditCust() {
		System.out.println("Customer edited");
	}
	
	@Test
	public void DeletCust() {
		System.out.println("Cust Deleted Successfully...");
	}

}
