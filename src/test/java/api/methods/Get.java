package api.methods;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.init.ObjectRespo;
import io.restassured.path.json.JsonPath;

public class Get {

	@Test
	public void getMethod() {
		String response = 
				given()
				.when().get(ObjectRespo.getBaseUrl)
				.then()
				.statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(response);
		String status = js.getString("status");
		Assert.assertEquals(status, "success");

		System.out.println(response);
	}
}
