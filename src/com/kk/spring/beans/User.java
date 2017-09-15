package com.kk.spring.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User  {

	private int kid;
	private String username;
	private String password;
	private String realname;
	private int age;
	
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	
	
    @Override
	public String toString() {
		return "User [kid=" + kid + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", age=" + age + "]";
	}
	public void User() {
    	
    }
}

