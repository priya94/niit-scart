package com.niit.shoppingcartfront.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;

@Controller
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;
	
	@Autowired
	private Category category;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Product product;
	@Autowired
	private ProductDAO productDAO;
	
	
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView ValidUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password, HttpSession session) {

		log.debug("Starting of the method login");
		log.info("name is {}  password is {}", name , password);
		
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
		log.debug("Ending of the method login");
		return mv;
	}
	

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("/home");
		session.invalidate();
		session = request.getSession(true);
		 session.setAttribute("category", category);
		 session.setAttribute("categoryList", categoryDAO.list());
		 
		 session.setAttribute("supplier", supplier);
		 session.setAttribute("supplierList", supplierDAO.list());
		 
		 session.setAttribute("product", product);
		 session.setAttribute("productList", productDAO.list());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");

		return mv;
	}


}