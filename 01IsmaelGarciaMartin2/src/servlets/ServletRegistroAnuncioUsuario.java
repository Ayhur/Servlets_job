package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AnunciosDAO;
import daosImpl.AnunciosDAOImpl;
import modelo.Anuncio;

@WebServlet("/ServletRegistroAnuncioUsuario")
public class ServletRegistroAnuncioUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String titulo = request.getParameter("campoTitulo");
		String descripcion = request.getParameter("campoDescripcion");
		String direccion = request.getParameter("campoDireccion");
		String poblacion = request.getParameter("campoPoblacion");
		String precio = request.getParameter("campoPrecio");
		String Nhabitaciones = request.getParameter("campoNHabitaciones");
		String idcliente = request.getParameter("campoId");
		
		Anuncio anuncio = new Anuncio(titulo, descripcion, direccion, poblacion, Double.parseDouble(precio), Integer.parseInt(Nhabitaciones));
		anuncio.setClie(Integer.parseInt(idcliente));
		
		
		/*TODO validaciones*/
		
		/*fin validaciones*/
		
		AnunciosDAO DAOAnuncio = new AnunciosDAOImpl();
		DAOAnuncio.registrarAnuncio(anuncio);
		
		request.getRequestDispatcher("RegistroAnuncioOK.jsp").forward(request, response);
	}

}
