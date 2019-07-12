package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Score;
import com.example.model.Student;
import com.example.service.inter.IGetStudentService;

@Service
public class GetStudentService implements IGetStudentService{

	@Override
	public Student getStudentByID(String id) {
		Student student = new Student();
		student.setName("Ashish");
		student.setAge("39");
		student.setAddress("Maharashtra");
		Score score = new Score();
		score.setMarks(78);
		score.setSubject("Physics");
		student.setScore(score);
		return student;
	}

}
