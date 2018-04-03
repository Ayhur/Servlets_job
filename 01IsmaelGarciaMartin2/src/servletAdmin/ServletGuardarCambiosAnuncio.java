package servletAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AnunciosDAO;
import daosImpl.AnunciosDAOImpl;
import modelo.Anuncio;

@WebServlet("/admin/ServletGuardarCambiosAnuncio")
public class ServletGuardarCambiosAnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titulo = request.getParameter("campoTitulo");
		String descripcion = request.getParameter("campoDescripcion");
		String direccion = request.getParameter("campoDireccion");
		String poblacion = request.getParameter("campoPoblacion");
		String precio = request.getParameter("campoPrecio");
		String Nhabitaciones = request.getParameter("campoNHabitaciones");
		String id = request.getParameter("campoId");

		/** TODO tengo que validar aqui los campos (validacion JAVA) */

		/* fin validacion */

		Anuncio anuncio = new Anuncio(titulo, descripcion, direccion, poblacion, Double.parseDouble(precio),
				Integer.parseInt(Nhabitaciones));
		anuncio.setId(Integer.parseInt(id));
		
		AnunciosDAO DAOanuncio = new AnunciosDAOImpl();
		DAOanuncio.guardarCambiosAnuncio(anuncio);
		
		request.setAttribute("anuncio", "ok");
		request.getRequestDispatcher("cambiosOK.jsp").forward(request, response);

	}

}
