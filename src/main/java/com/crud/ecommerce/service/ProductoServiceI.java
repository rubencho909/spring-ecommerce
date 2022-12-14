package com.crud.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.crud.ecommerce.model.Producto;

public interface ProductoServiceI {
	
	public List<Producto> findAll();
	public Producto save(Producto producto);
	public Optional<Producto> getById(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	
}
