package mvn.mvnproject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcelPractice {
	
	public static void Main(String args) {
		try {
			File file = new File("C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\empdata.xlsx");
			FileInputStream fis = new FileInputStream(file);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);		//open workbook
			XSSFSheet sheet = wb.getSheetAt(0);
			
			Row row;
			//Iterator itr = row.iterator();
			//row.hasNext(itr);
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	
	}

	private static void ForEach(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
