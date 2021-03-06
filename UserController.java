package com.niit.shoppingcartfront.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.dao.UserDAO;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.dao.CategoryDAO;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;
	
	@Autowired
	private Category category;
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView ValidUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password, HttpSession session) {

		ModelAndView mv = new ModelAndView("/home");
		boolean isValidUser = userDAO.isValidUser(name, password);
		System.out.println("isValidUser="+isValidUser+"name="+name+"password="+password);

		if (isValidUser == true) {

			user = userDAO.get(name);
			session.setAttribute("loggedInUser", user.getName());
			System.out.println(user.getName() + "logged in");

			if (user.isIsadmin()==true) {
				mv.addObject("isIsadmin", "true");
				System.out.println(user.getName() + ":admin logged in");
			} else {
				mv.addObject("isIsadmin", "false");
				// cart = cartDAO.get(userID);
				// mv.addObject("cart", cart);
				// List<Cart> cartList = cartDAO.list();
				// mv.addObject("cartList", cartList);
				// mv.addObject("cartSize", cartList.size());
			}

		} 
		return mv;
	}
	

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("/home");
		session.invalidate();
		session = request.getSession(true);
		 session.setAttribute("category", category);
		 session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");

		return mv;
	}


}