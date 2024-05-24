package marathon.week2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {


	public  String[][] readData(String ExcelName) throws IOException {
	//Create WorkBook
	XSSFWorkbook book = new XSSFWorkbook("./data/"+ExcelName+".xlsx");
	//get first Sheet in excel
	XSSFSheet sheet = book.getSheet("Sheet1");
	//get row count
	int row = sheet.getLastRowNum();
	System.out.println(row);
	//get last col count starting from 0th row
	short col = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=stringCellValue;
				System.out.println(stringCellValue);
			}
		}
		
		book.close();
		return data;
		
	}

}

	
	


	
	


