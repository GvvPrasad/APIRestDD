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

	//Get Variables
	public static String getBaseUrl = "https://api.thesmsworks.co.uk/";

	//Post Variables
	public static String postBaseUrl = "https://reqbin.com";

	//Put Variables
	public static String putBaseUrl = "https://reqres.in";

	//Patch Variables
	public static String patchBaseUrl = "https://reqres.in";

	//Delete Variables
	public static String deleteBaseUrl = "https://reqres.in";

	//Excel Utilizes Files variables
	protected static XSSFWorkbook wb;
	protected static XSSFSheet sh;
	protected static XSSFRow row;
	protected static XSSFCell cell;
	protected static FileInputStream dataFile;
	protected static FileOutputStream fileOut;

	//Test Data Files
	public static String testPath = projectPath+"//src//test//resources//PathData.xlsx";
	public static String testData = projectPath+"//src//test//resources//parameterData.xlsx";
}