package co.rene.tienda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rene.tienda.dao.ClienteDao;
import co.rene.tienda.dao.TiendaDao;
import co.rene.tienda.model.Cliente;
import co.rene.tienda.model.Tienda;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao  = new ClienteDao();   
	private TiendaDao tiendaDao  = new TiendaDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tienda tienda  = tiendaDao.findByField("email", request.getParameter("email"));
		if (tienda != null) {
			request.getSession().setAttribute("tienda", tienda);
			response.sendRedirect("/SegundoPrevio/tienda?action=misservicios");
			return;
		}
		response.sendRedirect("/SegundoPrevio/");
	}

}
