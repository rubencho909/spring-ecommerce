package com.crud.ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String userName;
	private String email;
	private String direccion;
	private String telefono;
	private String tipo;
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private List<Producto> listaProductos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Orden> listaOrdenes;
	
	public Usuario() {
	}

	public Usuario(Integer id, String nombre, String userName, String email, String direccion, String telefono,
			String tipo, String password, List<Producto> listaProductos, List<Orden> listaOrdenes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.userName = userName;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo = tipo;
		this.password = password;
		this.listaProductos = listaProductos;
		this.listaOrdenes = listaOrdenes;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Orden> getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(List<Orden> listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", userName=" + userName + ", email=" + email
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", tipo=" + tipo + ", password=" + password
				+ ", listaProductos=" + listaProductos + ", listaOrdenes=" + listaOrdenes + "]";
	}
	
}
