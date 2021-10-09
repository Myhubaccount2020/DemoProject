

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import files.payload;

public class DynamicJson {
	@org.junit.Test
	public  void addBook() {
	  RestAssured.baseURI = "https://rahulshettyacademy.com/";
	  
	given().log().all().header("Content-Type","application/json").body(payload.addBook())
	.when().post("Library/Addbook.php")
	.then().assertThat().statusCode(200);
	  
	}

}
