package files;

public class payload {
	public static String addPlace() {
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Steeve house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 9093\",\r\n" + 
				"  \"address\": \"608, Iddermech, Elmers,tizi-gheniff\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"https://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
		
	}
	public static String updatePlace() {
		return "{\r\n" + 
				"    \"place_id\":\"0cc9b5e1fc67c7eb6fcfc21dc662f912\",\r\n" + 
				"    \"address\":\"608 croftdermech,tizi gheniff\",\r\n" + 
				"    \"key\":\"qaclick123\"\r\n" + 
				"}";
	}
	public static String coursePrice() {
		return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 910,\n" +
                "    \"website\": \"rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
	}
	public static String addBook() {
		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"bcd\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
	}

}
