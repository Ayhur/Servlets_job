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

@WebServlet("/admin/ServletListadoAnunciosAdmin")
public class ServletListadoAnunciosAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			AnunciosDAO daoAnuncio = new AnunciosDAOImpl();
			request.setAttribute("anuncioExclusivo",
					daoAnuncio.obtenerAnuncioAeditar(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("listadoAnuncios.jsp").forward(request, response);
		} else {
			AnunciosDAO daoAnuncio = new AnunciosDAOImpl();
			request.setAttribute("anuncios", daoAnuncio.obtenerAnuncios());
			request.getRequestDispatcher("listadoAnuncios.jsp").forward(request, response);
		}
	}
}
