package api.methods;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.init.ObjectRespo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Delete {

	@Test(dataProvider = "deleteTestData")
	public void deleteMethod(String deletePathUrl) {
		RestAssured.baseURI= ObjectRespo.deleteBaseUrl;

		String response = given()
				.when().delete(deletePathUrl)
				.then().assertThat().statusCode(204)
				.extract().response().asString();

		System.out.println(ObjectRespo.deleteBaseUrl + deletePathUrl);
		
		//JsonPath js = new JsonPath(response);
		//String status = js.getString("status");
		//Assert.assertEquals(status, "success");

		System.out.println(response);
	}
	
	@DataProvider
	public Object[][] deleteTestData() throws IOException{
		api.utilities.ExcelUtil.getExcel(api.init.ObjectRespo.testPath);
		api.utilities.ExcelUtil.getSheet(4);		
		return api.utilities.ExcelUtil.getData();
	}
}
