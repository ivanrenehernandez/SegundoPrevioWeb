package co.rene.tienda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rene.tienda.dao.TiendaDao;
import co.rene.tienda.model.Cliente;
import co.rene.tienda.model.Tienda;

/**
 * Servlet implementation class TiendaController
 */
@WebServlet("/tienda")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TiendaDao tiendaDao = new TiendaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String path = request.getServletPath();
			String action = request.getParameter("action");
			switch (action) {
			case "registrar":
				registrarTienda(request, response);
				break;
			case "servicios":
				listarServicios(request, response);
			default:
				List <Tienda> tiendas = tiendaDao.list();;
				request.getSession().setAttribute("tiendas", tiendas);	
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listarServicios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Tienda tienda = tiendaDao.find(id);
		if (tienda != null) {
			request.getSession().setAttribute("nombredetienda", tienda.getNombre());
			request.getSession().setAttribute("mensajeservicios", tienda.getServicios().size() > 0 ? "" : "No hay servicios registrados");
			request.getSession().setAttribute("servicios", tienda.getServicios());
			request.getRequestDispatcher("servicios.jsp").forward(request, response);			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String path = request.getServletPath();
			String action = request.getParameter("action");
			switch (action) {
			case "registrar":
				registrarTienda(request, response);
				break;
			default:
				List <Tienda> tiendas = tiendaDao.list();;
				request.getSession().setAttribute("tiendas", tiendas);	
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void registrarTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tienda tienda= new Tienda();
		tienda.setClave(request.getParameter("clave"));
		tienda.setDescripcion(request.getParameter("descripcion"));
		tienda.setEmail(request.getParameter("email"));
		tienda.setFacebook(request.getParameter("facebook"));
		tienda.setImagen(request.getParameter("imagen"));
		tienda.setLema(request.getParameter("lema"));
		tienda.setNombre(request.getParameter("nombre"));
		tienda.setPropietario(request.getParameter("propietario"));
		tienda.setWeb(request.getParameter("web"));
		Tienda tiendaDB = tiendaDao.findByField("email", tienda.getEmail());
		if (tiendaDB == null) {
			tiendaDao.insert(tienda);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	

}
