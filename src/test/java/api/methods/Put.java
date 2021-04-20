package api.methods;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.init.ObjectRespo;
import api.payloads.PostMethodPayloads;
import io.restassured.RestAssured;

public class Put {
	String name = null;
	String job = null;

	@Test(dataProvider = "putPathData")
	public void putMethod (String putpath){
		RestAssured.baseURI = ObjectRespo.putBaseUrl;

		String response = given()
				.body(PostMethodPayloads.postPayload(name, job))
				.when()
				.post(putpath)
				.then().assertThat().statusCode(201)
				.extract().response().asString();
		System.out.println(name + job);
		System.out.println(response);
	}

	@DataProvider
	public Object[][] putPathData() throws IOException{
		api.utilities.ExcelUtil.getExcel(api.init.ObjectRespo.testPath);
		api.utilities.ExcelUtil.getSheet(2);		
		return api.utilities.ExcelUtil.getData();
	}
}
