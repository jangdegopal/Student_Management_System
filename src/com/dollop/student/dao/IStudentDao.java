package com.dollop.student.dao;

import java.util.List;

import com.dollop.student.bean.Student;

public interface IStudentDao {
	public Student save(Student student);
	public List<Student> saveall(List<Student> students);
	public List<Student> findAll();
	public List<Student> findByName(String name);
	public Student findById(Integer id);
	public void delete(Integer id);
	public void deleteAll(List<Integer> idS);
	public Boolean existById(Integer id);
	public Integer counts();
	

}
