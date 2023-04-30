package com.global.hr.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.global.hr.enitiy.Employee;
import com.global.hr.projection.EmployeeProjection;
import com.global.hr.projection.HrStatisticProjection;
import com.global.hr.repos.EmployeeRepo;

import jakarta.persistence.criteria.Order;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	
	public Employee findById(long id) {
		return	empRepo.findById(id).get();
	}
	
//	public Iterable<Employee> findAll(String sortCol,boolean isAsc) {
//		
//		return	empRepo.findAll(Sort.by(isAsc? Direction.DESC:Direction.DESC ,sortCol));
//	}
	
public Iterable<Employee> findAll(String sortCol,boolean isAsc,int pageNo,int pageSize) {
		
//	List<Order> orders=new ArrayList<>();
//	Order order1=new Order(isAsc? Direction.DESC:Direction.DESC,sortCol);
//	orders.add(order1);
	
	Pageable page=PageRequest.of(pageNo, pageSize,Sort.by(isAsc? Direction.DESC:Direction.DESC ,sortCol));
		return	empRepo.findAll(page);
	}

	
	public Iterable<Employee> findByDepartmentId(long deptId) {
		return	empRepo.findByDepartmentId(deptId);
	}
	
	public List <Employee> findByDepartment(long deptId){
		return empRepo.findByDepartment(deptId);
	};

  public Long countByDepartmentAndName(String deptName,String empName) {
	  return empRepo.countByDepartmentNameContainingAndNameContaining(deptName, empName);
  };
  
  public List<Employee> findBySalary (String empName,double empSalary){
	  return empRepo.findBySalary(empName, empSalary); 
  };
  
  public List<EmployeeProjection> findByName (String empName){
	  return empRepo.findByName(empName,Sort.by("name").descending()); 
  };

  public HrStatisticProjection getHrStatistic() {
	  return empRepo.getHrStatistic();
  }
  public Long deleteByDepartmentAndName(String deptName,String empName) {
		return empRepo.deleteByDepartmentNameContainingAndNameContaining(deptName, empName);

	};


	
	public List<Employee> filter(String name){
		return empRepo.filter(name);
	}
	
	public Employee insert (Employee emp) {
		 return  empRepo.save(emp);
	}
	
	public Employee update (Employee emp) {
		 return  empRepo.save(emp);
	}
	
}
