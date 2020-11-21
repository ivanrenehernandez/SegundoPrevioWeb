package co.rene.tienda.dao;

import co.rene.tienda.model.Servicio;
import co.rene.tienda.util.Conexion;

public class ServicioDao extends Conexion<Servicio> implements GenericDao<Servicio> {

	public ServicioDao() {
		super(Servicio.class);
	}

}
