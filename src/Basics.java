import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.testng.annotations.Test;

import files.payload;

public class Basics {

@org.junit.Test
	public  void addPlace() {
		// TODO Auto-generated method stub
         //validate if add API is working as expected
		//Given ****  All inputs of API
		//When ****   Submit the API --resource and HTTP method
		//Then ****   Validate the response
		
	// add a place 	
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.addPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println("This is the response : "+response);
		JsonPath jspath = new JsonPath(response);// for parsing json
		String scope = jspath.get("scope");
		String status = jspath.getString("status");
		System.out.println("The scope is : "+scope);
		System.out.println("The status is : "+status);
		String placeId = jspath.get("place_id");
		System.out.println("The place-id is : "+placeId);
	
//update the place 
  String newAddress = "608 windidermech,tizi gheniff";
	String response2 =  given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
	  .body("{\r\n" + 
	  		"    \"place_id\":\""+placeId+"\",\r\n" + 
	  		"    \"address\":\""+newAddress+"\",\r\n" + 
	  		"    \"key\":\"qaclick123\"\r\n" + 
	  		"}")
	  .when().put("maps/api/place/update/json")
	  .then().extract().asString();
	JsonPath js = new JsonPath(response2);
	String msg = js.get("msg");
	System.out.println(msg);
	
	//get the place
	String response3 = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
	.when().get("maps/api/place/get/json")
	.then().assertThat().statusCode(200).extract().asString();
	JsonPath js2 = new JsonPath(response3);
	String address = js2.get("address");
	System.out.println(address);
	Assert.assertTrue(address.equals(newAddress));
  }

}
