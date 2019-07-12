package com.example.controller.inter;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Student;

public interface ICreateStudent {
	
	public Student createStudent(@RequestBody final Student student);
}
