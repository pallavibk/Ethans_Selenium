package day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelreading {

	



		public static void main(String[] args) {
			
			
			File file=new File("G:\\JAVA and SELENIUM\\prg11.xls");
			
			try {
				FileInputStream fileInputstream=new FileInputStream(file);
				
					HSSFWorkbook workbook=new HSSFWorkbook(fileInputstream);
					HSSFSheet sheet=workbook.getSheet("Sheet1");
					HSSFRow row=sheet.getRow(0);
					HSSFCell cell=row.getCell(0);
					HSSFCell cell1=row.getCell(1);
					System.out.println(cell.getStringCellValue());
					
				
			} 
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	 
	}


