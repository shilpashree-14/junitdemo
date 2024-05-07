package Requers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class practise {
	//given() - write all the preconditions - starting steps - write all the 
		// quey parameters, authorization. request body in given()
		
		//when() - we provide http method - get/post/delete/put and URL
		
		//then() Validate the reponse - status code, response body, log all the response
		
		
		// this is for get method, here no body.
		//running two test cases
		
		@Test(priority = 2)
		public void getlistofusers() {
			given()
			
			.when().get("https://reqres.in/api/users?page=2")
			
			.then().statusCode(200).log().all();	
			
			
		}
		@Test(priority = 1)

		public void getlistusers1() {
		given()
			
			.when().get("https://reqres.in/api/users?page=2")
			
			.then().statusCode(200).body("total", equalTo(12)).log().all(); //use to validate response body
			
				
	}
		
		
		@Test(priority = 3)
		public void create_user() {
			
			HashMap hm = new HashMap();
			hm.put("name", "shilpashree");
					hm.put("job", "tester");
			given().body(hm)
			.when().post("https://reqres.in/api/users")
		
		.then().statusCode(201).log().all();
		}
		
		
		
		@Test(priority = 4, dependsOnMethods = {"create_user"} )
		public void update_user() {
			HashMap hm = new HashMap();
			hm.put("name", "shilpashree");
					hm.put("job", "tester");
			given().body(hm)
			.when().put("https://reqres.in/api/users/2")
			.then().statusCode(200).log().all();
		}
		@Test(priority = 0)
		public void delete_user() {
			given()
			.when().delete("https://reqres.in/api/users/2")
			.then().statusCode(204).log().all();
		}

}
