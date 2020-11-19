package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.EmployeeModel;
@Component("validate")
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(EmployeeModel.class);
	}
    
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		EmployeeModel emp=(EmployeeModel)target;
		//perform form validation
		if(emp.geteName()=="" ||emp.geteName().isEmpty())
		
			errors.rejectValue("eName", "emp.ename.required");
		
		else if(emp.geteName().length()<4||emp.geteName().length()>10)
		errors.rejectValue("eName","emp.ename.length");
				
		
		
		if(emp.getSalary()<10000||emp.getSalary()>100000)
		errors.rejectValue("salary","emp.sal.range");
		
		
		
			
		
	}

}
