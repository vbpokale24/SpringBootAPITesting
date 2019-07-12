package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APITestingConnection {

	private static final String base_url="http://localhost:8080";
	
	public static RequestSpecification connection() {
		RestAssured.baseURI = base_url;
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest;
	}
	
}
