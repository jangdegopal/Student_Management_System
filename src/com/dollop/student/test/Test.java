package com.dollop.student.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollop.student.bean.Student;
import com.dollop.student.doa.impl.StudentRepository;
import com.dollop.student.menu.Menu;

public class Test {

	static Scanner sc = new Scanner(System.in);
	static StudentRepository repo = new StudentRepository();

	public static void main(String[] args) {
//		StudentReposetory repo=new StudentReposetory();
//		Student std = new Student("piyush", "piyush123@gmail.com", "9876543243", 6000.0);
//		repo.save(std);
//		std=new Student(1, "ram", "piio", "67898765", 78789.0);
//		repo.save(std);
		
		Boolean cond = true;
		while(cond) {
			try {
			Menu.menu();
			Integer choice = Integer.parseInt(sc.nextLine());		
		
			switch (choice){
				case 1: 
					save();
					break;
				case 2:
					save();
					break;
				case 3:
					saveAll();
					break;
				case 4:
					findAll();
					break;
				case 5:
					findByName();
					break;
				case 6:
					findById();
					break;
				case 7:
					delete();
					break;
				case 8:
					deleteAll();
					break;
				case 9:
					existById();
					break;
				case 10:
					counts();
					break;
				case 11:
					exit();
					break;
					
					
					
					
					
	
				default:
					System.out.println("Please Enter Valid Input Between 1 to 9  Only.");
			}		
			}
			catch (NumberFormatException e) {
	            System.out.println("Please Enter Only Numbers");
			}
		}	
	}
	private static void save() {
		try {
		System.out.println("Enter Name ");
		String name = sc.nextLine();
		
		System.out.println("Enter Email ");
		String email = sc.nextLine();
		
		System.out.println("Enter Mobile No. ");
		String mobile = sc.nextLine();
		
		System.out.println("Enter Fees ");
		Double fee = Double.parseDouble(sc.nextLine());
		
		Student student = new Student(name, email, mobile, fee);
		repo.save(student);
		System.out.println("Student Saved Successfully");
		
	}
		catch(NumberFormatException e) {
			System.out.println("Please Enter Valid Fees In Number Format");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void saveAll() {
		List<Student> students = new ArrayList<>();
		
		System.out.println("You want to how many students add ");
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 1 ; i <= n ; i++) {
			
			System.out.println("Enter student "+i+" detail ");
			
			System.out.println("Enter name");
			String name = sc.nextLine();
			
			System.out.println("Enter Email");
			String email = sc.nextLine();
			
			System.out.println("Enter Mobile Number");
			String mobile = sc.nextLine();
			
			System.out.println("Enter Fees");
			Double fee = Double.parseDouble(sc.nextLine());
			
			students.add(new Student(name, email, mobile, fee));
			
		}
		
		repo.saveall(students);
		System.out.println("All Students Saved Successfully");	
	}
	
	
	private static void findAll() {
		
		List<Student> students = repo.findAll();
		
		for(Student student : students) {
			System.out.println(student);
		}
	}
	

	private static void findByName() {
		System.out.println("Enter student name");
		String name = sc.nextLine();
		
		List<Student> students = repo.findByName(name);
		
		for (Student student : students) {
			System.out.println(student);
		}
	}

	
	private static void findById() {
		System.out.println("Enter student Id");
		Integer id = Integer.parseInt(sc.nextLine());
		
		Student student = repo.findById(id);
		System.out.println(student);
	}



	private static void delete() {
		System.out.println("Enter student Id");
		Integer id = Integer.parseInt(sc.nextLine());
		repo.delete(id);
		
	}

	
	private static void deleteAll() {
		List<Integer> ids = new ArrayList<>();
		
		System.out.println("You want to delete how many ids");
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 1;i<=n;i++) {
			System.out.println("Enter id");
			int id = Integer.parseInt(sc.nextLine());
			ids.add(id);
		}
		repo.deleteAll(ids);
        System.out.println("Students Deleted Successfully");

	}


	private static void existById() {
		System.out.println("Enter Id");
		Integer id = Integer.parseInt(sc.nextLine());
		
		Boolean exist = repo.existById(id);
		
		System.out.println(exist);
	}
	
	
	private static void counts() {
		Integer count = repo.counts();
		
		System.out.println("Total Students "+count+" .");
		
	}
	
	
	private static void exit() {
	    System.out.println("************Exit************");
	    System.exit(0);
	}
}
