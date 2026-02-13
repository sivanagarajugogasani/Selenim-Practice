import java.io.FileInputStream; // This is used to read a file from your computer.Here, we are reading an Excel file.
import java.io.IOException; // This is required because file reading may fail (file not found, file corrupted, etc.).So Java may throw an IOException.

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// XSSFWorkbook = Whole Excel file (.xlsx)
// XSSFSheet    = One sheet inside the Excel file

public class DataDriven {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\kk\\OneDrive\\Documents\\demodata.xlsx"); //  This opens the Excel file from your system.fis is like a pipe through which Java reads the Excel file.
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // This loads the Excel file into memory.Now workbook represents the entire Excel file.
		int sheets = workbook.getNumberOfSheets();  // This gives total number of sheets in the Excel file.
		for (int i = 0; i < sheets; i++)
		{
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i); // If sheet name matches "testdata", then it stores that sheet in a variable. Now sheet represents the TestData sheet.
			}
		}

	}
}
