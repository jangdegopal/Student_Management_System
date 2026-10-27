package com.dollop.student.service.impl;

import java.util.List;

import com.dollop.student.bean.Student;
import com.dollop.student.doa.impl.StudentRepository;
import com.dollop.student.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	
	StudentRepository repo = new StudentRepository();

	@Override
	public Student save(Student student) {
		return repo.save(student);
	}

	@Override
	public List<Student> saveall(List<Student> student) {
		return repo.saveall(student);
	}

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Student> findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public Student findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void delete(Integer id) {
		repo.delete(id);
	}

	@Override
	public void deleteall(List<Integer> ids) {
		repo.deleteAll(ids);
	}

	@Override
	public Boolean existById(Integer id) {
		return repo.existById(id);
	}

	@Override
	public Integer counts() {
		return repo.counts();
	}

}
