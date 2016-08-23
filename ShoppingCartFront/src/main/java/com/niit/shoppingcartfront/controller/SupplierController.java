package com.niit.shoppingcartfront.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.dao.SupplierDAO;

@Controller
public class SupplierController {
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public String supplierList(Model model) 
	{
		model.addAttribute("isIsadminClickedSuppliers", "true");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		return "home";
	}

	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
	public String addSuppliers(@ModelAttribute("supplier") Supplier supplier) {
		supplierDAO.saveOrUpdate(supplier);

		return "redirect:/suppliers";
	}
	
	@RequestMapping("deleteSuppliers/{id}")
	public String deleteSuppliers(@PathVariable("id") String id,ModelMap model) {
		try {
			supplierDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/suppliers";
	}
	
	
	@RequestMapping(value = "editSuppliers/{id}")
	public String editSuppliers(@PathVariable("id") String id,ModelMap model) {
		supplier=supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());

		return "redirect:/suppliers";
	}

}
