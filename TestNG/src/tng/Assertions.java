package tng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	@Test
	public void failassert(){
		String actual = "Gooogle";
		System.out.println("Below assert would faild");
		//Assert.assertEquals(actual,"Google");
		Assert.assertEquals(actual,"Google");
}

	
}
