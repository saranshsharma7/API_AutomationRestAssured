package APIAutomation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation 

{

	@Test
	public void xmlTestSchemaValidation() throws IOException
	
	{
		
		File file=new File("./SOAP_XML/TestSOAPRequest.xml");
		
		if(file.exists())
			{
				System.out.println("==>XML file exist.");
			}
				else
					{
					System.out.println("file not found(error).");
					}
	FileInputStream fis= new FileInputStream(file);
	
	String requestBody= org.apache.commons.io.IOUtils.toString(fis,"UTF-8");
	
	baseURI="https://www.dataaccess.com";
	
	given().
		contentType("text/xml").
			accept(ContentType.XML).
				body(requestBody).
					
						when().
							post("/webservicesserver/NumberConversion.wso").
							then().statusCode(200).log().all().and().
								//body("//*:NumberToWordsResult.text()",equalTo("five hundred ")).and().
									assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xml_xsdFile.xsd"));
		
	}
	
}
