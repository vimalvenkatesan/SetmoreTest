package LearningSection;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Datadriven {

		public static void main(String[]args)throws Exception{
		
		
		File src =new File("/Users/user/Documents/Excel.xls");
		FileInputStream fis = new FileInputStream(src);	
		
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet1 =wb.getSheetAt(0);
		
		int rowcount=sheet1.getLastRowNum();
		System.out.print("Data from Row"+ "is"+rowcount+1);
		
		for(int i=0;i<rowcount;i++)
		{
		String Cellgetcontent=sheet1.getRow(i).getCell(0).getStringCellValue();
		System.out.print("Data from Row"+ "is"+Cellgetcontent);
		}
			
		wb.close();
		}
		}