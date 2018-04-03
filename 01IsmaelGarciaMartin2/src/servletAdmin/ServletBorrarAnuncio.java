package servletAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AnunciosDAO;
import daos.ClientesDAO;
import daosImpl.AnunciosDAOImpl;
import daosImpl.UsuarioDAOImpl;

@WebServlet("/ServletBorrarAnuncio")
public class ServletBorrarAnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int client = Integer.parseInt((String) request.getSession().getAttribute("identificado"));
		System.out.println("Borrar ANUNCIO de ID: " + id);
		
		//instancio el objeto
		AnunciosDAO daoAnun = new AnunciosDAOImpl();
		
		daoAnun.borrarAnuncioUser(id, client);
		request.getRequestDispatcher("borradoOK.jsp").forward(request, response);

	}

}
