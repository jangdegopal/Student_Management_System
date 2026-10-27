package com.dollop.student.doa.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dollop.student.bean.Student;
import com.dollop.student.dao.IStudentDao;
import com.dollop.student.util.DbConnection;
import com.dollop.student.validation.StudentValidation;

public class StudentRepository implements IStudentDao {
	private String sql = null;
	private Statement stmt = null;
	private Connection con = null;
	@Override
	public Student save(Student student) {
	    StudentValidation.validation(student);

		if(isNew(student)) {
			insert(student);
			return student;
		}
		else {
			return update(student);
		}
	}

	private Student update(Student student) {
		 sql = "UPDATE student SET "
			        + "std_name='" + student.getStdname() + "', "
			        + "std_email='" + student.getStdEmail() + "', "
			        + "std_mob='" + student.getStdmobileno() + "', "
			        + "std_fee=" + student.getStdfees() + " "
			        + "WHERE std_id=" + student.getStdid();
		try {
			con=DbConnection.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return student;
	}

	private void insert(Student student) {
		sql="INSERT INTO student("
				+"`std_name`,`std_email`,`std_mob`,`std_fee`"
				+")"
				+"VALUES("
				+"'"+student.getStdname()+"',"
				+"'"+student.getStdEmail()+"',"
				+"'"+student.getStdmobileno()+"',"
				+student.getStdfees()+")"
				;
		try {
			con=DbConnection.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			}
	}

	private boolean isNew(Student student) {
		return student.getStdid()==null?true:false;
	}

	@Override
	public List<Student> saveall(List<Student> students) {
		List<Student> newStudents = new ArrayList<>();
		for (Student student : students) {
			newStudents.add(save(student));
		}
		return newStudents;
	}

	@Override
	public List<Student> findAll() {
		sql="SELECT * FROM student ";
		List<Student> student = new ArrayList<>();
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
				student.add(
						new Student(
								rs.getInt("std_id"), 
								rs.getString("std_name"), 
								rs.getString("std_email"), 
								rs.getString("std_mob"), 
								rs.getDouble("std_fee")));
			
		}catch (SQLException e) {
			e.printStackTrace();
			}		
		return student;
	}

	@Override
	public List<Student> findByName(String name) {
		sql="SELECT * FROM student where std_name like '%"+name+"%'";
		List<Student> student = new ArrayList<>();
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
				student.add(new Student(rs.getInt("std_id"), rs.getString("std_name"), rs.getString("std_email"), rs.getString("std_mob"), rs.getDouble("std_fee")));
			
		}catch (SQLException e) {
			e.printStackTrace();
			}		
		return student;		
	}

	@Override
	public Student findById(Integer id) {
		sql="SELECT * FROM student WHERE std_id="+id;
		Student student = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				student = new Student(id, rs.getString("std_name"), rs.getString("std_email"), rs.getString("std_mob"), rs.getDouble("std_fee"));
			
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return student;
	}

	@Override
	public void delete(Integer id) {
		sql="DELETE FROM student WHERE std_id="+id;
		try {
			con=DbConnection.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			}
	}

	@Override
	public void deleteAll(List<Integer> ids) {
		for (Integer id : ids) {
			delete(id);
			}

	}

	@Override
	public Boolean existById(Integer id) {
		if(findById(id)!= null)
			return true;
		return false;
	}

	@Override
	public Integer counts() {
		sql="SELECT COUNT(*) as COUNT FROM student ";
		Integer count = null;
		try {
			con = DbConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				count=rs.getInt("count");
			con.close();			
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return count;
	}

}
