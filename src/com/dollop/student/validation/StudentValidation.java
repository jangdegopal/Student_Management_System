package com.dollop.student.validation;

import com.dollop.student.bean.Student;
import com.dollop.student.exception.ValidationException;

public class StudentValidation {
	public static void validation(Student student) {
		 
	if (student.getStdname() == null || student.getStdname().trim().isEmpty())
			throw new ValidationException("Name cannot be empty");
	
	if(student.getStdname().length() < 2) 
			throw new ValidationException("Name must cotain minimum 2 characters");
		
	
	
	if (student.getStdEmail() == null || student.getStdEmail().trim().isEmpty())
			throw new ValidationException("Email cannot be empty");
	
	if(!(student.getStdEmail().matches("^[A-Za-z0-9+_.-]+@gmail\\.com$")))
		throw new ValidationException("Invalid email format");
	
	
	if (student.getStdmobileno() == null || student.getStdmobileno().trim().isEmpty())
		throw new ValidationException("Mobile number cannot be empty ");
	
	if(!(student.getStdmobileno().matches("[0-9]{10}")))
		throw new ValidationException("Mobile Number must be 10 digits ");
	
	
	
	if(student.getStdfees() == null )
		throw new ValidationException("Fees cannot be null");
	
	if(student.getStdfees() <=0)
		throw new ValidationException("Fees must be greater than 0");
	
	
	}
}
