package APIAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class APITestGETRequest 


{
	
	@Test
	public void testGetRequest()
	
	{
		
		baseURI="https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
				get("/users?page=2").
					then().
						statusCode(200).
							body("data[1].id",equalTo(8)).
							body("data[1].email",equalTo("lindsay.ferguson@reqres.in")).
							body("data.id",hasItems(10,11)).log().all();
							
				
				

		
		
	}

}
