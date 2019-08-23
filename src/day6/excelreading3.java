package day6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelreading3 {

	public static void main(String[] args) {
		
		
		File file=new File("G:\\JAVA and SELENIUM\\prg11.xls");
		
		try {
			FileInputStream fileInputstream=new FileInputStream(file);
			
				HSSFWorkbook workbook=new HSSFWorkbook(fileInputstream);
				HSSFSheet sheet=workbook.getSheet("Sheet1");
				for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
				{
					HSSFRow row=sheet.getRow(i);
					for(int j=0;j<row.getPhysicalNumberOfCells();j++)
					{
						HSSFCell cell=row.getCell(j);
					/*if(	cell.CELL_TYPE_BLANK==1)
					{
						j++;
					}*/
				
						System.out.print(cell.getStringCellValue()+" ");
					}
					System.out.println(" ");
					
				}
				
				
			
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

