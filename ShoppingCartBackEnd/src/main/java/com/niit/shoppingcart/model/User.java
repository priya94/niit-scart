package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="user")
@Component

public class User {
	@Id
	private String id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	private String mobile_number;
	 private String mail_id;
	 private String address;
	
	 @Column(name = "isadmin")
		private boolean isadmin;
		
	 @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
		private Set<Cart> cart;
		public Set<Cart> getCart() {
			return cart;
		}

		public void setCart(Set<Cart> cart) {
			this.cart = cart;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
