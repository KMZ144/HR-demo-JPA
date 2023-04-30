package com.global.hr.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.enitiy.Employee;
import com.global.hr.projection.EmployeeProjection;
import com.global.hr.projection.HrStatisticProjection;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	List<Employee> findBySalary (String empName,double empSalary);

	List<EmployeeProjection> findByName (String empName,Sort sort);
	
	
	
	//JPql
	@Query(value = "SELECT new Employee(emp.id,emp.name,emp.salary)  From #{#entityName} emp WHERE emp.name like :empName ")
	 List <Employee> filter (@Param("empName") String name ); 
	
	List <Employee> findByDepartmentId(long deptId);
	
	Long countByDepartmentNameContainingAndNameContaining(String deptName,String empName);
	
	
	@Query(value = "select ("
			+ "select count(*) empCount from employee) empCount,"
			+ "(Select count(*) deptCount from department) deptCount,"
			+ "(Select count(*) userCount from user) userCount" ,nativeQuery=true)
	HrStatisticProjection getHrStatistic ();
	
	@Transactional
	Long deleteByDepartmentNameContainingAndNameContaining(String deptName,String empName);
	
	
//	@Query (value = "SELECT emp FROM Employee emp Join Department dept ON emp.department.id=dept.id WHERE dept.id=:deptId")
	@Query (value = "SELECT emp FROM Employee emp Join emp.department dept WHERE dept.id=:deptId ")
	List <Employee> findByDepartment(@Param("deptId") long deptId);

}
