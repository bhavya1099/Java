// ********RoostGPT********
/*
Test generated by RoostGPT for test integration-scenarioTab-test using AI Type  and AI Model 

Test generated for /configuration_post for http method type POST in rest-assured framework

RoostTestHash=5d6dcbea91


*/

// ********RoostGPT********
package com.thealgorithms.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Arrays;

public class configurationPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {"oiuopi_BASE_URL"};
      envList = dataloader.load("src/test/java/com/thealgorithms/RoostTest/configurationPostTest.csv", envVarsList);
    }

  
    @Test  
    public void configurationPost_Test() throws JSONException {
        this.setUp();
        Integer testNumber = 1;
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("oiuopi_BASE_URL") != null && !testData.get("oiuopi_BASE_URL").isEmpty()) ? testData.get("oiuopi_BASE_URL"): testData.get("oiuopi_BASE_URL");  
          JSONObject requestBodyObject = new JSONObject();
          if(testData.get("RequestBody") != null){
              requestBodyObject = new JSONObject(testData.get("RequestBody"));
          }
                Response responseObj = given()
				.contentType(ContentType.JSON)
				.body(requestBodyObject.toString())
                .when()
                .post("/configuration")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();

              System.out.printf("Test Case %d: configurationPost_Test \n", testNumber++);
              System.out.println("Request: POST /configuration");
              System.out.println("Status Code: " + responseObj.statusCode());
              if (testData.get("statusCode") != null) {
                String statusCodeFromCSV = testData.get("statusCode");
                if (statusCodeFromCSV.contains("X")) {
                  MatcherAssert.assertThat(
                      "Expected a status code of category " + statusCodeFromCSV + ", but got "
                          + Integer.toString(responseObj.statusCode()) + " instead",
                      Integer.toString(responseObj.statusCode()).charAt(0), equalTo(statusCodeFromCSV.charAt(0)));
                } else {
                  MatcherAssert.assertThat(
                      Integer.toString(responseObj.statusCode()), equalTo(statusCodeFromCSV));
                }
              } 
              				else {  
      List<Integer> expectedStatusCodes = Arrays.asList(200,400,401,403,404,429,500,503,504);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
          }
				String stringifiedStatusCode = Integer.toString(responseObj.statusCode());
        switch(responseObj.statusCode()){
        
          case 200:
            stringifiedStatusCode = "200";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 400:
            stringifiedStatusCode = "400";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 401:
            stringifiedStatusCode = "401";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 403:
            stringifiedStatusCode = "403";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 404:
            stringifiedStatusCode = "404";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 429:
            stringifiedStatusCode = "429";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 500:
            stringifiedStatusCode = "500";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 503:
            stringifiedStatusCode = "503";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
          case 504:
            stringifiedStatusCode = "504";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
    }

      switch(Integer.toString(responseObj.statusCode()).charAt(0)){
      
    }

      
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else if(contentType.contains("application/json")){  
                response = responseObj.jsonPath(); 
              } else {
                System.out.println("Response content type found: "+contentType+", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
                continue;
              }
         
                if(stringifiedStatusCode.equals("200")){					System.out.println("Description: Success");
      
              if (response.get("control") != null) {
                      
              if (response.get("control.type") != null) {
                  
                MatcherAssert.assertThat(response.get("control.type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("control.type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("control.message") != null) {
                  
                MatcherAssert.assertThat(response.get("control.message"), instanceOf(String.class));
              }
      
              if (response.get("control.code") != null) {
                  
                MatcherAssert.assertThat(response.get("control.code"), instanceOf(String.class));
              }

              }
				}
if(stringifiedStatusCode.equals("400")){					System.out.println("Description: Bad Request");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("401")){					System.out.println("Description: Unauthorized");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("403")){					System.out.println("Description: Forbidden - Scope Not Permitted");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("404")){					System.out.println("Description: Not Found");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("429")){					System.out.println("Description: Too Many Requests - Exceeded Quota");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("500")){					System.out.println("Description: Internal Server Error");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("503")){					System.out.println("Description: Service Unavailable");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}
if(stringifiedStatusCode.equals("504")){					System.out.println("Description: Gateway Timeout");
      
              if (response.get("type") != null) {
                  
                MatcherAssert.assertThat(response.get("type"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("type"), anyOf(equalTo("S"), equalTo("T"), equalTo("E")));

              }
      
              if (response.get("message") != null) {
                  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
              }
      
              if (response.get("code") != null) {
                  
                MatcherAssert.assertThat(response.get("code"), instanceOf(String.class));
              }
				}


            }  
    }
}
