package com.global.hr.enitiy;

import java.lang.annotation.Repeatable;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.FieldResult;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SqlResultSetMapping;

@Entity

@NamedQuery(name="Employee.findBySalary",query = "SELECT emp FROM Employee emp WHERE "
		+ "emp.salary>=:empSalary and emp.name=:empName ")

//@SqlResultSetMapping(name="empMapping",
//  entities  = @EntityResult(
//		entityClass = Employee.class,
//		fields= {
//				@FieldResult(name="id",column="emp_id"),
//				@FieldResult(name="name",column="emp_name"),
//				@FieldResult(name="salary",column="salary")
//			}
//		)
//)
@NamedNativeQuery(name="findByByName",query="SELECT * FROM employee "
		+ "WHERE name like :empName",resultSetMapping = "empMapping")


public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long id;
	@Column(name="emp_name")
	private String name;
	
	public Employee() {
		super();
	} 
	
	public Employee(long id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	

	


	private double salary;

	@ManyToOne(cascade = { jakarta.persistence.CascadeType.PERSIST,
			jakarta.persistence.CascadeType.MERGE },fetch = FetchType.EAGER)
//	@JsonIgnore
//	@JoinColumn(name="department_id",referencedColumnName = "id")
	private Department department;

	@OneToOne(cascade = jakarta.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

//	@jakarta.persistence.Version
//	private Long version;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
