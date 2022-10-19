package com.crud.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.ecommerce.service.ProductoServiceI;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	ProductoServiceI productoServiceI;
	
	@GetMapping("")
	public String show() {
		return "productos/show";
	}

}
