package com.global.hr.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.enitiy.Role;
import com.global.hr.enitiy.User;
import com.global.hr.repos.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleService roleService;

	public List<User> finaAll() {
		return userRepo.findAll();
	}

	public User findById(long id) {
		return userRepo.findById(id).get();
	}

	public Iterable<User> findAll() {
		return userRepo.findAll();
	}

	public User insert(User user) {
		return userRepo.save(user);
	}

	public User update(User user) {
		return userRepo.save(user);
	}

//	@Transactional(rollbackOn = {SQLException.class})
	@Transactional
	public void addRoleForAllUsers(String name) {
		Role role = roleService.findByName(name);
		this.findAll().forEach((user) -> {
			user.addToRoles(role);
			userRepo.save(user);
		});
	}

}
