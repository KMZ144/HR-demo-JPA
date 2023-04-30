package com.global.hr.enitiy;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	
	private String pass;

	@ManyToMany
	@JoinTable(name="user_sec_roles",
	joinColumns =@JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private Set<Role> roles=new HashSet<>();

	public void addToRoles(Role role) {
		roles.add(role);
	}
	
	public void removeFromRoles(Role role) {
		roles.remove(role);
	}
	
	
//	@OneToOne(mappedBy = "user")
//	@JsonIgnore
	
//	private Employee emp;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//	public Employee getEmp() {
//		return emp;
//	}
//
//	public void setEmp(Employee emp) {
//		this.emp = emp;
//	}

	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
