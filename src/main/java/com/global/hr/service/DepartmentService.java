package com.global.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.enitiy.Department;
import com.global.hr.repos.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	
	public Department findById(long id) {
		return	departmentRepo.findById(id).get();
	}
	
	public Department insert (Department emp) {
		 return  departmentRepo.save(emp);
	}
	
	public Department update (Department emp) {
		 return  departmentRepo.save(emp);
	}
	
	public Iterable<Department> findAll() {
		return	departmentRepo.findAll();
	}
	
	


}
