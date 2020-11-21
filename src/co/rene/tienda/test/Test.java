package co.rene.tienda.test;

import co.rene.tienda.dao.ClienteDao;
import co.rene.tienda.dao.ServicioDao;
import co.rene.tienda.dao.TiendaDao;
import co.rene.tienda.model.Cliente;
import co.rene.tienda.model.Servicio;
import co.rene.tienda.model.Tienda;
import co.rene.tienda.util.Conexion;

public class Test {
	static ClienteDao clienteDao = new ClienteDao();
	static ServicioDao servicioDao = new ServicioDao();
	static TiendaDao tiendaDao = new TiendaDao();

	public Test() {
	}

	public static void main(String[] args) {
		try {
			Cliente cliente = new Cliente();
			cliente.setNombre("Iván René");
			cliente.setEmail("ivanrene@gmail.com");
			cliente.setClave("789456123");
			clienteDao.insert(cliente);
			
			Tienda tienda = new Tienda();
			tienda.setClave("789456132");
			tienda.setDescripcion("Esta es una descripción");
			tienda.setEmail("lacocinaderene@gmail.com");
			tienda.setFacebook("www.facebook.com");
			tienda.setLema("La mejor cocina express");
			tienda.setImagen("www.fotos.com");
			tienda.setNombre("La cocina de rené");
			tienda.setPropietario("Ivan Rene");
			tienda.setWeb("www.lacocinaderene.com");
			tiendaDao.insert(tienda);
			
			Servicio servicio = new Servicio();
			servicio.setNombre("Pedido express");
			servicio.setDescripcion("Rápido a la puerta de tu casa");
			servicio.setTiendaBean(tienda);
			servicioDao.insert(servicio);
			
		} catch (Exception e) {
		}
		

	}
}
