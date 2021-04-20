package api.methods;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.init.ObjectRespo;
import api.payloads.PostMethodPayloads;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;

public class Post extends ObjectRespo{

	String name = null;
	String job = null;
	String id = null;
	String quanity = null;
	String price = null;

	@Test(dataProvider = "postPathData")
	public void postMethod (String postpath){
		RestAssured.baseURI = ObjectRespo.postBaseUrl;

		
		String response = given()
				.body(PostMethodPayloads.postPayload(id, name, quanity, price))
				.when()
				.post(postpath)
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		System.out.println(response);
	}

	@DataProvider
	public Object[][] postPathData() throws IOException{
		api.utilities.ExcelUtil.getExcel(api.init.ObjectRespo.testPath);
		api.utilities.ExcelUtil.getSheet(1);		
		return api.utilities.ExcelUtil.getData();
	}
}
