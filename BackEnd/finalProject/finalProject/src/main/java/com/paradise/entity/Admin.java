package com.paradise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="tbl_admin")
public class Admin {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int adminId;

@Column(nullable=false)
private String name;

@Column(nullable=false,unique=true)
private String username;

@Column(nullable=false)
@Pattern(regexp="^[a-zA-Z0-9]{8,}",message="length must be atleast 8") 
private String password;

@Column(nullable=false)
private String aRole="Admin";


public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getaRole() {
	return aRole;
}
public void setaRole(String aRole) {
	this.aRole = aRole;
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", name=" + name + ", username=" + username + ", password=" + password
			+ ", aRole=" + aRole + "]";
}




}
