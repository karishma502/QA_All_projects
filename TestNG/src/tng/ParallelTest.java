package tng;

import org.testng.annotations.Test;

public class ParallelTest {
	@Test
	public void A_TestMethod() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println("A_TestMethod. Thread id is: " + id);
		Thread.sleep(1000);
	}
	
	@Test
	public void B_TestMethod() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println("B_TestMethod. Thread id is: " + id);
		Thread.sleep(1000);
	}
	
	@Test
	public void C_TestMethod() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println("C_TestMethod. Thread id is: " + id);
		Thread.sleep(1000);
	}
	
	@Test
	public void D_TestMethod() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println("D_TestMethod. Thread id is: " + id);
		Thread.sleep(1000);
	}
}
