package com.global.hr.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.hr.enitiy.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	   Role findByName (String name); 
	
}
