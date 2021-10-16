package mvn.mvnproject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

// download and update JARs in java build path - https://poi.apache.org/download.html

// https://www.javatpoint.com/how-to-read-excel-file-in-java
// https://poi.apache.org/apidocs/dev/org/apache/poi/ss/usermodel/CellType.html
// https://stackoverflow.com/questions/39993683/alternative-to-deprecated-getcelltype

// https://stackoverflow.com/questions/1516144/how-to-read-and-write-excel-file
// for function to read excel 

public class ReadDataExcel {
	@Test
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\HP\\eclipse-workspace\\empdata.xlsx"); // creating a new file instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file  

			//File (Excel file) - -FInputStream --- XSSFWorkbook  (wb) --- XSSFSheet (sheet) --- Row -- Cell
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			
			// wb.getSheet("Sheet1"); // This is also ok - giving sheet name 

			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			//String sheetname="Emp";
			//XSSFSheet sheet = wb.getSheet(sheetname);
			//wb.getsheet
			//wb.getsheet
			//wb.getSheetIndex(null)
			//wb.getsheet


			Row row = sheet.getRow(0);
			Cell cell = row.getCell(1);
			System.out.println(cell);
			//System.out.println(row);
			System.out.println(sheet.getRow(1).getCell(1));
			System.out.println(sheet.getRow(3).getCell(2));
			
			for (int i=3; i<row.getRowNum(); i++ ) {
				
				for(int j=3; j<i; j++) {
					System.out.println(j);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
