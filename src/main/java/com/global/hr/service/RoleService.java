package com.global.hr.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.enitiy.Role;
import com.global.hr.repos.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	
	public Role findById(long id) {
		return	roleRepo.findById(id).get();
	}
	
	public Iterable<Role> findAll() {
		return	roleRepo.findAll();
	}
	
	public Role insert (Role role) {
		 return  roleRepo.save(role);
	}
	
	
	
	public Role update (Role role) {
		 return  roleRepo.save(role);
	}
	
  public Role findByName (String name) {
		 return  roleRepo.findByName(name);
	}
	
}
