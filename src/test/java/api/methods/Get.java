package api.methods;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.init.ObjectRespo;

public class Get {

	@Test(dataProvider = "getTestData")
	public void getMethod(String getPathUrl) {
		String response = 
				given()
				.when().get(ObjectRespo.getBaseUrl+getPathUrl)
				.then().extract().response().asString();
		
		System.out.println(response);
	}

	@DataProvider
	public Object[][] getTestData() throws IOException{
		api.utilities.ExcelUtil.getExcel(api.init.ObjectRespo.testPath);
		api.utilities.ExcelUtil.getSheet(0);		
		return api.utilities.ExcelUtil.getData();
	}
}
