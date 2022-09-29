package APIAutomation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
//import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator 

{

	@Test
	public void testGetRequest()
	
	{
		
		baseURI="https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
				get("/users?page=2").
					then().
					assertThat().body(matchesJsonSchemaInClasspath("schemaValidator.json")).
						statusCode(200);
						
				
				

		
		
	}
	
}
