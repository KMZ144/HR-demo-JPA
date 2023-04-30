package com.global.hr.enitiy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;

@Entity
public class Department {
	
	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_gen")
//	@SequenceGenerator(name="department_gen",sequenceName = "department_seq",initialValue = 100 )
	
	
	@GeneratedValue (strategy = GenerationType.TABLE ,generator = "department_gen")
	@TableGenerator(name = "department_gen",table = "department_seq",allocationSize = 20,initialValue = 200)
	private long id;

	private String name;
	
//	@OneToMany(mappedBy = "department")
//	@JsonIgnore	
//	private List<Employee> emps;
//	
//	public List<Employee> getEmps() {
//		return emps;
//	}
//
//	public void setEmps(List<Employee> emps) {
//		this.emps = emps;
//	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
