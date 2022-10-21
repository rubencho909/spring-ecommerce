package com.crud.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.ecommerce.model.Producto;
import com.crud.ecommerce.service.ProductoServiceI;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductoServiceI productoServiceI;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", productoServiceI.findAll());
		return "usuario/home";
	}
	
	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("Id del Producto enviado como parametro {}", id); 
		Producto producto = new Producto();
		Optional<Producto> productOptional = productoServiceI.getById(id);
		producto = productOptional.get();
		model.addAttribute("producto", producto);
		return "usuario/productoHome";
	}
	
}
