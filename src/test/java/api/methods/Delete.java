package api.methods;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.init.ObjectRespo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Delete {

	@Test
	public void deleteMethod() {
		RestAssured.baseURI= ObjectRespo.deleteBaseUrl;

		String response = given()
				.when().delete(ObjectRespo.deleteParameters)
				.then().assertThat().statusCode(200)
				.extract().response().asString();

		JsonPath js = new JsonPath(response);
		String status = js.getString("status");
		Assert.assertEquals(status, "success");

		System.out.println(response);
	}
}
