package com.global.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.enitiy.Role;
import com.global.hr.service.UserService;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PutMapping("/add-role")
	public ResponseEntity<?> addRoleForAllUsers(@RequestBody Role role) {
		 userService.addRoleForAllUsers(role.getName());
		 return ResponseEntity.ok(null);
	}

}
