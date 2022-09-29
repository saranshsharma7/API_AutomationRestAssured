package APIAutomation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class APITestDELETERequest 

{

	
	@Test
	public void testPATCHRequest()
	
	{
			
			baseURI="https://reqres.in/api";
			
				
					when().
						delete("/users/2").
							then().
								statusCode(204).log().all();
					
}
	
}
