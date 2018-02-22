package LearningSection;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {

	public static void main(String[] args) throws Exception {

		File src = new File("\n" + 
				"			File Src = new File(\"/Users/user/Downloads/Office/EclipseRD/Logins.xlsx\");");
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);

		int rowcount = sheet1.getLastRowNum();
		System.out.print("Data from Row" + "is" + rowcount + 1);

		for (int i = 0; i < rowcount; i++) {
			String Cellgetcontent = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.print("Data from Row" + "is" + Cellgetcontent);
		}

		wb.close();
	}
}