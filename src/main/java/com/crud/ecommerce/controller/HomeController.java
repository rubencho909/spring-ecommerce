package com.crud.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.ecommerce.service.ProductoServiceI;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ProductoServiceI productoServiceI;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", productoServiceI.findAll());
		return "usuario/home";
	}
	
}
