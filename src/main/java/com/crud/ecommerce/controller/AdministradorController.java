package com.crud.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.ecommerce.model.Producto;
import com.crud.ecommerce.service.ProductoServiceI;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	private ProductoServiceI productoServiceI;
	
	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos = productoServiceI.findAll();
		model.addAttribute("productos", productos);
		return "administrador/home";
	}

}
