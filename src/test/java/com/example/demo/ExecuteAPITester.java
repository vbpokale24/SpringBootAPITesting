package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.configuration.ReadDataFromFile;
import com.example.model.Student;
import com.example.report.CreateReport;
import com.example.report.ReportModel;
import com.example.validator.ValidateAPI;
import com.google.gson.Gson;

import io.restassured.response.Response;

public class ExecuteAPITester {

	Gson gson = new Gson();
	
	ValidateAPI validateAPI = new ValidateAPI();
	
	public static void main(String[] args) throws IOException {
		ExecuteAPITester executeAPITester = new ExecuteAPITester();
		List<ReportModel> reportModelList = new ArrayList<>();	
		reportModelList.add(executeAPITester.getCallAPI());
		reportModelList.add(executeAPITester.postCallAPI());
		CreateReport.createReport(reportModelList);
	}
	
	public ReportModel getCallAPI() {
		ReportModel reportModel = new ReportModel();
		Response response = CallAPI.getCall();
		Gson gson = new Gson();
		Student student = gson.fromJson(response.getBody().asString(), Student.class);		
		Boolean isValid = validateAPI.validateTest("VaibhavPokale", student.getName());	
		reportModel.setResult(String.valueOf(isValid));
		reportModel.setTestName("GetStudent");
		return reportModel;
	}
	
	public ReportModel postCallAPI() {
		ReportModel reportModel = new ReportModel();
		Student studentData = ReadDataFromFile.getObjectFromJson("student.json", Student.class);
		Response responsePost = CallAPI.createStudent(studentData);
		Student student = gson.fromJson(responsePost.getBody().asString(), Student.class);
		Boolean isValid = validateAPI.validateTestForPostCall(student);
		reportModel.setResult(String.valueOf(isValid));
		reportModel.setTestName("CreateStudent");
		return reportModel;
	}
}
