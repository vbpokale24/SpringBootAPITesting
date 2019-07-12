package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.inter.IGetStudent;
import com.example.model.Student;
import com.example.service.inter.IGetStudentService;

@RestController
public class GetStudent implements IGetStudent{

	@Autowired
	private IGetStudentService getStudentService;

	@Override
	@RequestMapping(value = "/getStudent/{studentID}", method=RequestMethod.GET)
	public Student getStudentByID(@PathVariable String studentID) {
		return getStudentService.getStudentByID(studentID);
	}	
}
