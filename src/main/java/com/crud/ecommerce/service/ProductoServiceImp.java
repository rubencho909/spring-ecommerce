package com.crud.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ecommerce.model.Producto;
import com.crud.ecommerce.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoServiceI{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> getById(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);
	}

}
