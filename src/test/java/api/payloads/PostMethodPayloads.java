package api.payloads;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostMethodPayloads extends api.utilities.ExcelUtil{

	@Test(dataProvider = "postTestData")
	public static String postPayload(String id, String name, String quanity, String price)
	{
		return "{\r\n" + 
				"  \"Id\": "+id+",\r\n" + 
				"  \"Customer\": \""+name+"\",\r\n" + 
				"  \"Quantity\": "+quanity+",\r\n" + 
				"  \"Price\": "+price+"\r\n" + 
				"}";
	}

	@DataProvider
	public Object[][] postTestData() throws IOException{
		api.utilities.ExcelUtil.getExcel(api.init.ObjectRespo.testData);
		api.utilities.ExcelUtil.getSheet(0);		
		return api.utilities.ExcelUtil.getData();
	}
}
