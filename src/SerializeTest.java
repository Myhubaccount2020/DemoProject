import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Location;
import pojo.SetPlace;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class SerializeTest {
	
	@Test
	public void serialize() {
	
        SetPlace p = new SetPlace();
        p.setAccuracy(50);
        p.setAddress("29, side layout, cohen 09");
        p.setLanguage("French-IN");
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        p.setName("Frontline house");
        p.setPhone_number( "(+91) 983 893 3937");
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add( "shop");
        p.setTypes(myList);
        p.setWebsite( "https://rahulshettyacademy.com");
        
        
        
        
        
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(p)
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		String respString = response.asString();
		System.out.println(respString);
		JsonPath js = new JsonPath(respString);
		String placeId = js.get("place_id");
		System.out.println("The Place ID is : "+placeId);
	
	
	}
	@Test
	public void deserialize() {
		
		// Deserialization 
		
		
		System.out.println("********** Desrialization of the JSON response ************");
		
		String placeId = " 4d0b70a566b3ba0c9cf8f04dc2e77e35";
		 RestAssured.baseURI = "https://rahulshettyacademy.com";
	       SetPlace getPlace = given().queryParam("key", "qa123").queryParam("place_id",placeId)
	    		             .expect().defaultParser(Parser.JSON)
	    		             .when().get("maps/api/place/get/json")
	    		             .then().assertThat().statusCode(200).extract().as(SetPlace.class);
	       
	       
	      int accuracy =  getPlace.getAccuracy();
	      System.out.println(accuracy);
		
	}

}
