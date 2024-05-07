package Requerss;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class post_put_get_json {
	 @Test (priority = 0)
	    public void post_users() {
	    JSONObject jsp =new JSONObject();
	    jsp.put("name", "Archisman");
	    jsp.put("job","Editor");
	    given()
	    .body(jsp)
	    .when().post("https://reqres.in/api/users")
	    .then().statusCode(201).log().all();
	    }
	    @Test (priority = 2)
	    public void get_users() {
	        given()
	        .when().get("https://reqres.in/api/users")
	        .then().statusCode(200).log().all();
	    }
	    @Test (priority = 1)
	    public void update_user() {
	        JSONObject jsp =new JSONObject();
	        jsp.put("name", "Archisman");
	        jsp.put("job","Editor");
	        given()
	        .body(jsp)
	        .when().put("https://reqres.in/api/users/2")
	        .then().statusCode(200).log().all();
	    }
	}

