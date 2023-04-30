package com.global.hr.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.hr.enitiy.Department;
import com.global.hr.enitiy.Employee;
import com.global.hr.enitiy.Role;
import com.global.hr.enitiy.User;
import com.global.hr.service.DepartmentService;
import com.global.hr.service.EmployeeService;
import com.global.hr.service.RoleService;
import com.global.hr.service.UserService;

@Component
public class StartupConfig implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Role role1 = new Role();
		role1.setName("admin");
		
		Role role2 = new Role();
		role2.setName("user");
		
		roleService.insert(role1);
		roleService.insert(role2);
		
		
		Set<Role> adminRole=new HashSet<>();
		adminRole.add(role1);
		
		Set<Role> userRole=new HashSet<>();
		userRole.add(role2);
		
		///////////////////////
		
		
		User user1 = new User();
		user1.setEmail("user1@gmail");
		user1.setPass("123");
		user1.setRoles(adminRole);
		
		User user2 = new User();
		user2.setEmail("user2@gmail");
		user2.setPass("123");
		user2.setRoles(userRole);
		
		userService.insert(user1);
		userService.insert(user2);
		
		///////////////////////////////////
		
//		Department dept1=new Department();
//		dept1.setName("java");
//		
//		Department dept2=new Department();
//		dept2.setName("php");
//		
//		deptService.insert(dept1);
//		deptService.insert(dept2);
//		
//		//////////////////
//		
//		Employee emp1=new Employee();
//		emp1.setName("kareem");
//		emp1.setSalary(35000);
//		emp1.setUser(user1);
//		emp1.setDepartment(dept1);
//		
//		Employee emp2=new Employee();
//		emp2.setName("fayez");
//		emp2.setSalary(50000);
//		emp2.setUser(user2);
//		emp2.setDepartment(dept2);
//		
//		empService.insert(emp1);
//		empService.insert(emp2);
	}

}
