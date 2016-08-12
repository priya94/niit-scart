package com.niit.shoppingcartfront.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;




@Controller
public class MyController {
	
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;
//	
//	
//	@RequestMapping("/")
//	public ModelAndView myfun1()
//	{
//	  ModelAndView mv=new ModelAndView("/home");
//	  return mv;
//		
//	}
//	
	
	@RequestMapping("/")
	public ModelAndView myfun1(HttpSession session) {
		ModelAndView mv = new ModelAndView("/home");
		
		 session.setAttribute("category", category);
		 session.setAttribute("categoryList", categoryDAO.list());
		 return mv;

	}

	
	
	@RequestMapping("/loginhere")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isUserClickedLoginHere", "true");
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("/register");
		mv.addObject("user", user);
		mv.addObject("isUserClickedRegisterHere", "true");
		return mv;
	}	
	

	@RequestMapping(value = "here/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User user) {
		userDAO.saveOrUpdate(user);
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("successMessage", "You successfully Logged in");

		return mv;
	}
	
}
