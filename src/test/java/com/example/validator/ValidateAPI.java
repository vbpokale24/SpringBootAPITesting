package com.example.validator;

import com.example.model.Student;

public class ValidateAPI {

	public Boolean validateTest(String expected, String actual) {
		if(expected.equals(actual)) {
		return true;
		}
		else {
			return false;
		}			
	}
	
	public Boolean validateTestForPostCall(Student  actual) {
		if(actual.getName().equals("Ashish")&& actual.getScore().getMarks()==78) {
		return true;
		}
		else {
			return false;
		}			
	}
}
