package tng;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class parameterXML {
	
	@Parameters({"URL"})
	@Test
	public void check_para(String prm) {
		System.out.println("Test - Run");
		System.out.println(prm);
	}
	
	
}
