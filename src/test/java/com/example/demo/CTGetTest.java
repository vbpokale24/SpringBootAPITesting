
package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CTGetTest {
	
	@Test
	public void GetStudentDetails()
	{	
		RequestSpecification httpRequest = APITestingConnection.connection();
		Response resp = httpRequest.get("/createStudent");
		System.out.println("Name is ::"+resp.getBody());	
		Response response = httpRequest.get("/getStudent");	
		
		System.out.println("Response Body is =>  " + response.asString());
		
		response.then().body("name", Matchers.is("Vaibhav"));
		 assertEquals(response.getStatusCode(), 200);
	}
	
  }
 