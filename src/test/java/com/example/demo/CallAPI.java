package com.example.demo;

import com.example.model.Student;

import io.restassured.response.Response;

public class CallAPI {

	public static Response getCall() {
        Response response = APITestingConnection.connection().get("/getStudent");			
		return response;
	}
	
	public static Response createStudent(final Student student) {
        Response response = APITestingConnection.connection().contentType("application/json").body(student).post("/createStudent");		
		return response;
	}
}
