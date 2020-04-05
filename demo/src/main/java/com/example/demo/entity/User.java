package com.example.demo.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.enums.Role;


@Entity
@Table(name = "users")
public class User extends BaseEntity<Long>{

	private static final long serialVersionUID = -3628469724795296287L;
	
	@Column(name="login", unique=true)
	private String login;
	
	@Column(name="password")
	private String password;
	
	@Transient
	private List<Role> roles;

	public User(String login2, String encode) {
		this.login = login2;
		this.password = encode;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		List<Role> somethingList = Arrays.asList(Role.values());
		this.roles.addAll(somethingList);
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = Arrays.asList(Role.values());;
	}
	
	
}
