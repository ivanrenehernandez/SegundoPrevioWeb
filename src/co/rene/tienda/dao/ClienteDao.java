package co.rene.tienda.dao;

import co.rene.tienda.model.Cliente;
import co.rene.tienda.util.Conexion;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}

}
