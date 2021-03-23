package api.init;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ObjectRespo{

	//Project default Variable and Methods
	public static String projectPath = System.getProperty("user.dir");
	
	//Post Variables
	public static String postBaseUrl = "http://dummy.restapiexample.com";
	public static String postParameters ="/api/v1/create";

	//Get Variables
	public static String getBaseUrl = "http://dummy.restapiexample.com/api/v1/employees";

	//Delete Variables
	public static String deleteBaseUrl = "http://dummy.restapiexample.com";
	public static String deleteParameters = "/api/v1/delete/ID";

	//Excel Utilizes Files variables
	protected static XSSFWorkbook wb;
	protected static XSSFSheet sh;
	protected static XSSFRow row;
	protected static XSSFCell cell;
	protected static FileInputStream dataFile;
	protected static FileOutputStream fileOut;

	//Test Data Files
	public static String testData = projectPath+"//src//test//resources//TestData.xlsx";
}