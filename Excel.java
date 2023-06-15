package project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excel {
	
	WebDriver driver=null;

	public Excel(WebDriver d)
	{
		driver=d;
	}
	public void putData(String s,List<String> a) throws IOException
	{
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet = workbook.createSheet(s);
	
		 int rownum = 0;
		 
		 for(int i=0;i<a.size();i++)
		 {
			 Row row = sheet.createRow(rownum++);
			 Cell cell = row.createCell(0);
			 cell.setCellValue(a.get(i));
		 }
		 FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"\\Excel_File\\Book1.xlsx"));
		 workbook.write(out);
		 out.close();

}
}