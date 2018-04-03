package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AnunciosDAO;
import daosImpl.AnunciosDAOImpl;

@WebServlet("/ServletListadoAnunciosUsuario")
public class ServletListadoAnunciosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AnunciosDAO daoAnuncio = new AnunciosDAOImpl();
		request.setAttribute("anuncios", daoAnuncio.obtenerAnuncios());
		request.getRequestDispatcher("listadoAnuncios.jsp").forward(request, response);
	}

}
