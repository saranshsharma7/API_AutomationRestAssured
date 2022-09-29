package APIAutomation;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class APITestPOSTRequest 

{

	@SuppressWarnings("unchecked")
	@Test
	public void testPOSTRequest()
	
	{
		
		JSONObject request=new JSONObject();
		
			request.put("name", "John");
			request.put("job", "Engineer");
			request.put("email", "john@gmail.com");
			request.put("age", "26");
			
			System.out.println(request.toJSONString());
			
			baseURI="https://reqres.in/api";
			
			
			given().
			
				header("Content-Type","application/json").
				contentType(ContentType.JSON).accept(ContentType.JSON).
				
				body(request.toJSONString()).
					when().
						post("/users").
							then().
								statusCode(201).log().all();
								
	}
	
}
