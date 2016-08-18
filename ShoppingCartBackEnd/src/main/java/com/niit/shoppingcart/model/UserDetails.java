package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="UserDetails")
@Component
public class UserDetails {
 @Id
 private String id;
 private String name;
 private String password;
 private String mobile_number;
 private String mail_id;
 private String address;
 

 public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobile_number() {
	return mobile_number;
}
public void setMobile_number(String mobile_number) {
	this.mobile_number = mobile_number;
}
public String getMail_id() {
	return mail_id;
}
public void setMail_id(String mail_id) {
	this.mail_id = mail_id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 
}
