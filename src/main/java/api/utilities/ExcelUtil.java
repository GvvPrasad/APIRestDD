package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import api.init.ObjectRespo;

public class ExcelUtil extends ObjectRespo{

	//Get Excel File
	public static void getExcel(String filePath) throws IOException {
		try {
			dataFile = new FileInputStream(filePath);
			wb = new XSSFWorkbook(dataFile);
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	//Get Excel Sheet
	public static void getSheet(int sheetno) throws IOException {
		try {
			sh = wb.getSheetAt(sheetno);
		} catch (Exception e) {
			System.out.println("Sheet not found");
			e.printStackTrace();
		}
	}

	//Row Count
	public static int getRowCount() {
		int rowCount = 0; 
		try {
			rowCount = sh.getLastRowNum()+1;
		}catch(Exception e) {
			System.out.println("Did not get Rows");
			e.printStackTrace();
		}
		return rowCount;
	}

	//Column Count
	public static int getColumnCount(){
		int colCount=0;
		try {
			colCount = sh.getRow(0).getLastCellNum();
		}catch(Exception e) {
			System.out.println("Did not get Columns");
			e.printStackTrace();
		}
		return colCount;
	}

	//Get Specific cell value RAW
	public static Object getRawValue(int rowNum, int colNum) {
		String cellValue = sh.getRow(rowNum).getCell(colNum).getRawValue();
		return cellValue;
	}

	//Get String Value
	public static String getStringValue(int rowNum, int colNum) {
		String cellValue = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellValue;
	}

	//Get Numeric Value
	public static double getNumericValue(int rowNum, int colNum) {
		double cellValue = sh.getRow(rowNum).getCell(colNum).getNumericCellValue();;
		return cellValue;
	}

	//Change cell values to String
	public static String setCellDataToString(int rowNum, int colNum) {
		XSSFCell cell = null;
		String cellValue = null;
		try {
			cell = sh.getRow(rowNum).getCell(colNum);
			cell.setCellType(CellType.STRING);
			cellValue = cell.getStringCellValue().trim();
		}catch(Exception e) {
			System.out.println("Data not found");
			e.printStackTrace();
		}
		return cellValue;
	}

	//DataProvider from Excel
	public static Object[][] getData() throws IOException{
		int rowCount = ExcelUtil.getRowCount();
		int colCount = ExcelUtil.getColumnCount();
		Object[][] data = new Object[rowCount-1][colCount];
		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				//Check cell is empty or not
				if (data[i-1][j] == null) {
					data[i-1][j] = "";
				}

				//Check if cell has DATE vale or not


				//change values to string
				data[i-1][j] = ExcelUtil.setCellDataToString(i, j);
			}
		}
		return data;
	}

	//Create a Excel File and new sheet
	public static String createExcelFile(String filename, String sheetName) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		String dest = projectPath+"//src//test//resources//"+filename+".xlsx";
		File destination = new File(dest);
		FileOutputStream fileout = new FileOutputStream(destination);
		wb.createSheet(sheetName); 
		wb.write(fileout);
		fileout.close(); 
		return dest;
	}

	//Add Sheet to existing excel
	public static void createSheet(String sheetName) {
		wb.createSheet(sheetName); 
	}
	
	//Create Row
	public static void createRow(int i, int j, String data) {
		sh.createRow(i).createCell(j).setCellValue(data);
	}
	
	//Close Excel
	public static void closeExcel(String filePath) throws IOException {
		FileOutputStream fileout = new FileOutputStream(filePath);
		wb.write(fileout);
		fileout.close();
	}


}