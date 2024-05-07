package Bookstore;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class bookstore1 {
	@Test
	public void bookstore1() {
		given().queryParam("ISBN", "9781449325862")
.when().get("https://bookstore.toolsqa.com/BookStore/v1/Books")
		.then().statusCode(200).log().all();
	}
}
