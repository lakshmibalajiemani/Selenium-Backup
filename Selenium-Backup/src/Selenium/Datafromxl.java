package Selenium;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Datafromxl {
    public static void main(String args[]) throws BiffException, IOException
    {
	   FileInputStream fs= new FileInputStream("C:\\Users\\system-45\\Desktop\\Book1.xls");
	   Workbook wb =Workbook.getWorkbook(fs);
	   Sheet sh1 =wb.getSheet("Sheet3");
	   int rows =sh1.getRows();
	   System.out.println(rows);
	   int cols =sh1.getColumns();
	   System.out.println(cols);
	   for (int row = 1; row < rows; row++) {
		   for (int col = 0; col < cols; col++) {
				String content= sh1.getCell(col, row).getContents();
				System.out.print(content+"\t");
						}
		   System.out.println();
	}
  }
}
