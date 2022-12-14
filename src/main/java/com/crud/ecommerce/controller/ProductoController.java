package com.crud.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crud.ecommerce.model.Producto;
import com.crud.ecommerce.model.Usuario;
import com.crud.ecommerce.service.ProductoServiceI;
import com.crud.ecommerce.service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	ProductoServiceI productoServiceI;
	
	@Autowired
	private UploadFileService uploadFileService;

	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoServiceI.findAll());
		return "productos/show";
	}

	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}

	@PostMapping("/save")
	public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto producto {}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", null, null);
		producto.setUsuario(u);
		// Imagen
		if (producto.getId() == null) {		// Cuando se crea un producto por primera vez
			String nombreImagen = uploadFileService.saveImage(file);
			producto.setImagen(nombreImagen);
		} else {
			
		}
		productoServiceI.save(producto);
		return "redirect:/productos";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto = new Producto();
		Optional<Producto> optionalProducto = productoServiceI.getById(id);
		producto = optionalProducto.get();
		LOGGER.info("Producto buscado: {}", producto);
		model.addAttribute("producto", producto);
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		
		Producto p = new Producto();
		p = productoServiceI.getById(producto.getId()).get();
		
		if (file.isEmpty()) {	// Editamos el producto pero no cambiamos la Imagen
			producto.setImagen(p.getImagen());
		} else {	// Cuando se edita tambien la imagen
			// Eliminar la imagen cuando no sea la imagen por defecto
			if (!p.getImagen().equals("default.jpg")) {
				uploadFileService.deleteImage(p.getImagen());
			}
			String nombreImagen = uploadFileService.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		
		producto.setUsuario(p.getUsuario());
		productoServiceI.update(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Producto p = new Producto();
		p = productoServiceI.getById(id).get();
		
		// Eliminar la imagen cuando no sea la imagen por defecto
		if (!p.getImagen().equals("default.jpg")) {
			uploadFileService.deleteImage(p.getImagen());
		}
		productoServiceI.delete(id);
		return "redirect:/productos";
	}

}
