package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.service.inter.ICreateStudentService;

@Service
public class CreateStudentService implements ICreateStudentService{

	@Override
	public Student createStudent(Student student) {		
		return student;
	}

	
}
