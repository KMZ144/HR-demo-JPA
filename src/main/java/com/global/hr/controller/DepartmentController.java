package com.global.hr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.enitiy.Department;
import com.global.hr.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("")
	public Iterable<Department> getAll(){
		return departmentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable long id) {
		return departmentService.findById(id);
	}
	

	
	@PostMapping("")
	public Department insert(@RequestBody Department dept) {
		return departmentService.insert(dept);
	}
	
	@PutMapping("")
	public Department update(@RequestBody Department dept) {
		return departmentService.update(dept);
	}
	
	
}
