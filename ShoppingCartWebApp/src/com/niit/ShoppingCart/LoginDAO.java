package com.niit.ShoppingCart;

public class LoginDAO {
public boolean isValiduser(String userid,String password){
	if(userid.equals(password)) {
		return true;
	}
	else{
		return false;
	}
}
}
