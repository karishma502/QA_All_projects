package tng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameter_DP {
	@Test(dataProvider = "SearchProvider")
	public void testMethod(String name,String state)throws InterruptedException{
		System.out.println("Welcome ->"+name+";He is from ->"+state);
		Thread.sleep(1000);
	}


	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataProvider(){
	return new Object[][]
			{
				{"Rohit","Maharashtra"},
				{"Shubham","Karnataka"},
				{"Hrishi","UtaraKhand"},
			};
	}
}
