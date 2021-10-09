import java.util.ArrayList;

import org.junit.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(payload.coursePrice());
		
		int numCourses = js.getInt("courses.size()");
		System.out.println("The number of courses is : "+numCourses);
		String titles = js.getString("courses.title");
		System.out.println("The titles of courses are : "+titles);
		int price = js.getInt("dashboard.purchaseAmount");
		System.out.println("The price is  : "+price);
		String firstCourseTitle = js.getString("courses[0].title");
		int firsrCoursePrice = js.getInt("courses[0].price");
		System.out.println("The title of the first course is : "+firstCourseTitle+" ,The price is : "+firsrCoursePrice);
		String secondStringCourseTitle = js.getString("courses[1].title");
		int secondCoursePrice = js.getInt("courses[1].price");
		System.out.println("The title of the first course is : "+secondStringCourseTitle+" ,The price is : "+secondCoursePrice);
		String thirdCourseTitle = js.getString("courses[2].title");
		int thirdCoursePrice = js.getInt("courses[2].price");
		System.out.println("The title of the first course is : "+thirdCourseTitle+" ,The price is : "+thirdCoursePrice);
		// using a for loop 
		for (int i = 0; i < numCourses; i++) {
			System.out.println("The title of the first course is : "+js.get("courses["+i+"].title"));
			System.out.println("The price of the first course is : "+js.getInt("courses["+i+"].price"));
			
			if (js.get("courses["+i+"].title").equals("RPA")) {
				System.out.println("The number of copies of the book RPA is : "+js.getInt("courses["+i+"].copies"));
				break;
				
			}
		}
		
		int totalAmount =0;
		for (int i = 0; i < numCourses; i++) {
			int courseAmount = js.getInt("courses["+i+"].price");
			int numCopies = js.getInt("courses["+i+"].copies");
			int partialAmount = courseAmount*numCopies;
			totalAmount=totalAmount+partialAmount;
		}
		System.out.println("the total amount calculated is : "+totalAmount);
		Assert.assertEquals(price, totalAmount);
		
		
		
		
	}
	
	

}
