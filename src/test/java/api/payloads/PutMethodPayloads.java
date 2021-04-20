package api.payloads;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PutMethodPayloads extends api.utilities.ExcelUtil{

	@Test(dataProvider = "putTestData")
	public static String putPayload(String name, String job)
	{
		return "{\r\n" + 
				"    \"name\": \""+name+"\",\r\n" + 
				"    \"job\": \""+job+"\"\r\n" + 
				"}}";
	}

	@DataProvider
	public Object[][] putTestData() throws IOException{
		api.utilities.ExcelUtil.getExcel(api.init.ObjectRespo.testData);
		api.utilities.ExcelUtil.getSheet(1);		
		return api.utilities.ExcelUtil.getData();
	}
}
