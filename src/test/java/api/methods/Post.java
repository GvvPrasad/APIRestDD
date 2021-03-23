package api.methods;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.init.ObjectRespo;
import api.payloads.PostMethodPayloads;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Post extends ObjectRespo{

	String empname = null;
	String empsalary = null;
	String empage = null;

	@Test
	public void postMethod() {
		RestAssured.baseURI = ObjectRespo.postBaseUrl;

		String response = given()
				.body(PostMethodPayloads.postPayload(empname, empsalary, empage))
				.when()
				.post(ObjectRespo.postParameters)
				.then().assertThat().statusCode(200)
				.extract().response().asString();

		Assert.assertEquals(response.contains("Successfully! Record has been added."), true);
		
		System.out.println(response);
	}
}
