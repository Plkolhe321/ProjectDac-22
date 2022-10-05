package com.paradise.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tbl_visitor")
public class Visitor {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitorId;

@Column(nullable=false,unique=true,length = 12)
@Pattern(regexp="^[a-zA-Z0-9]{12}",message="length must be 12") 
	private String aadharno;

@Column(nullable=false)
	private String name;

@Column(nullable=false,length = 10)
@Pattern(regexp="^[0-9]{10}",message="length must be 10") 
	private String mobno;

@Column(nullable=false,unique=true)
@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
flags = Pattern.Flag.CASE_INSENSITIVE,message="invalid email format")
	private String email;

@Column(nullable=false,unique=true)
	private String username;

@Column(nullable=false)
@Pattern(regexp="^[a-zA-Z0-9]{8,}",message="length must be atleast 8") 
	private String password;


@Column(nullable=false)
private String aRole="Visitor";

//@JsonManagedReference
@JsonBackReference
@OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
@Fetch(value = FetchMode.SUBSELECT)
private List<Review> review;

//@JsonManagedReference
@JsonBackReference
@OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
@Fetch(value = FetchMode.SUBSELECT)
private List<Booking> booking;

public int getVisitorId() {
	return visitorId;
}
public void setVisitorId(int visitorId) {
	this.visitorId = visitorId;
}
public String getAadharno() {
	return aadharno;
}
public void setAadharno(String aadharno) {
	this.aadharno = aadharno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobno() {
	return mobno;
}
public void setMobno(String mobno) {
	this.mobno = mobno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
public List<Review> getReview() {
	return review;
}
public void setReview(List<Review> review) {
	this.review = review;
}
public List<Booking> getBooking() {
	return booking;
}
public void setBooking(List<Booking> booking) {
	this.booking = booking;
}
@Override
public String toString() {
	return "Visitor [visitorId=" + visitorId + ", aadharno=" + aadharno + ", name=" + name + ", mobno=" + mobno
			+ ", email=" + email + ", username=" + username + ", password=" + password + ", aRole=" + aRole
			+ "]";
}

}