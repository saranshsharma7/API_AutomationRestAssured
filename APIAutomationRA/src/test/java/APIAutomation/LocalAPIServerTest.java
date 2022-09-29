package APIAutomation;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
//import static org.hamcrest.Matchers.*;

public class LocalAPIServerTest 

{

	//*******Pre_Steps *************
	//Node JS Required
	//JSON Server Required
	//Start JSON Server
	
	
	//@Test(priority =0)
	public void ServerAPIGETRequest()
	
	{
		
		given().
			get("/users").
				then().statusCode(200).log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority =1)
	public void ServerAPIPOSTRequest()
	
	{
		
		JSONObject postRequest=new JSONObject();
		
		postRequest.put("firstname","priya");
		postRequest.put("lastname","sharma");
		postRequest.put("subjectid",2);

		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
				accept(ContentType.JSON).
		body(postRequest.toJSONString()).
		
			when().
				post("/users").
					then().statusCode(201).log().all();
		
		
}
	
	@SuppressWarnings("unchecked")
	@Test(priority =2)
	public void ServerAPIPUTRequest()
	
	{
		
		JSONObject putRequest=new JSONObject();
		
		putRequest.put("firstname","neha");
		putRequest.put("lastname","sharma");
		putRequest.put("subjectid",2);

		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
				accept(ContentType.JSON).
		body(putRequest.toJSONString()).
		
			when().
				put("/users/5").
					then().statusCode(200).log().all();
		
		
}
	
	@SuppressWarnings("unchecked")
	@Test(priority =3)
	public void ServerAPIPATCHRequest()
	
	{
		
		JSONObject patchRequest=new JSONObject();
		
		patchRequest.put("firstname","ishita");
		patchRequest.put("lastname","kumar");
		patchRequest.put("subjectid",2);

		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
				accept(ContentType.JSON).
		body(patchRequest.toJSONString()).
		
			when().
				patch("/users/5").
					then().statusCode(200).log().all();
		
		
}
	
	@Test(priority =4)
	public void ServerAPIDELETERequest()
	
	{
		
		baseURI="http://localhost:3000";
		
			when().
				delete("/users/5").
					then().statusCode(200).log().all();
		
		
}
}