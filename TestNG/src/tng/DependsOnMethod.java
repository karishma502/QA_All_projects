package tng;
import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test(dependsOnMethods= {"cmethod","bmethod"})
	public void amethod() {
		System.out.println("a method");
	}
	
	//create 2 more function 
	@Test
	public void bmethod() {
		System.out.println("b method");
	}
	
	@Test
	public void cmethod() {
		System.out.println("c method");
	}
}
