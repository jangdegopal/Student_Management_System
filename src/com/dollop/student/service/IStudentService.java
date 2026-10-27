package com.dollop.student.service;

import java.util.List;

import com.dollop.student.bean.Student;

public interface IStudentService {
	public Student save(Student student);
	public List<Student> saveall(List<Student> student);
	public List<Student> findAll();
	public List<Student> findByName(String name);
	
	public Student findById(Integer id);
	
	public void delete(Integer id);
	public void deleteall(List<Integer> ids);
	public Boolean existById(Integer id);
	public Integer counts();
}
