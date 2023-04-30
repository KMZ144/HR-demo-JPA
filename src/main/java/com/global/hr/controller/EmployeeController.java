package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.global.hr.enitiy.Employee;
import com.global.hr.projection.EmployeeProjection;
import com.global.hr.projection.HrStatisticProjection;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/{id}")
	public Employee findById(@PathVariable long id) {
		return empService.findById(id);
	}

	@GetMapping("")
	public Iterable<Employee> getAll(
			@RequestParam(name="col") String sortCol,
			@RequestParam boolean isAsc,
			@RequestParam(name="no") int pageNo,
			@RequestParam(name="size") int pageSize) {
		return empService.findAll( sortCol,isAsc,pageNo,pageSize);
	}

	@GetMapping("/filter-count")
	public ResponseEntity<Long> countByDepartmentAndName(@RequestParam String deptName, @RequestParam String empName) {
		return ResponseEntity.status(300).body(empService.countByDepartmentAndName(deptName, empName));
	};

	@DeleteMapping("/filter-delete")
	public ResponseEntity<Long> deleteByDepartmentAndName(@RequestParam String deptName, @RequestParam String empName) {
		return ResponseEntity.status(301).body(empService.deleteByDepartmentAndName(deptName, empName));
	}
	
	@GetMapping("/salary")
	public List<Employee> findBySalary (@RequestParam(name="name")String empName,@RequestParam("salary")  double empSalary){
		  return empService.findBySalary(empName, empSalary); 
	  };
	  
	  @GetMapping("/name")
	  public List<EmployeeProjection> findByName (@RequestParam(name="name") String empName){
		  return empService.findByName( empName); 
	  };

	@GetMapping("/filter")
	public List<Employee> filter(@RequestParam String name) {
		return empService.filter(name);
	}
	
	@GetMapping("/statistic")
	public HrStatisticProjection getHrStatistic() {
		  return empService.getHrStatistic();
	  }

	@PostMapping("")
	public Employee insert(@RequestBody Employee emp) {
		return empService.insert(emp);
	}

	@PutMapping("")
	public Employee update(@RequestBody Employee emp) {
		return empService.update(emp);
	}

	@GetMapping("/department/{deptId}")
	public Iterable<Employee> findByDepartmentId(@PathVariable long deptId) {
		return empService.findByDepartmentId(deptId);
	}

	@GetMapping("/custom/department/{deptId}")
	List<Employee> findByDepartment(@PathVariable long deptId) {
		return empService.findByDepartment(deptId);
	};
}
