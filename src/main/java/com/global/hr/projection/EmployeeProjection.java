package com.global.hr.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
	
	long getId();
	
	@Value("#{target.name}")
	String getName();
	double getSalary();
	DepartmentProjection getDepartment();
	

}
