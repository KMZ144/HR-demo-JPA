package com.global.hr.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.hr.enitiy.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
