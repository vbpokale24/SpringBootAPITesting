package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.inter.ICreateStudent;
import com.example.model.Student;
import com.example.service.inter.ICreateStudentService;

@RestController
public class CreateStudent implements ICreateStudent{

	@Autowired
	ICreateStudentService createStudentService;
	
	@Override
	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public Student createStudent(@RequestBody final Student student) {		
		return createStudentService.createStudent(student);
	}
}
