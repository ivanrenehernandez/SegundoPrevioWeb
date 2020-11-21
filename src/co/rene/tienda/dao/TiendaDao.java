package co.rene.tienda.dao;

import co.rene.tienda.model.Tienda;
import co.rene.tienda.util.Conexion;

public class TiendaDao extends Conexion<Tienda> implements GenericDao<Tienda> {

	public TiendaDao() {
		super(Tienda.class);
	}

}
