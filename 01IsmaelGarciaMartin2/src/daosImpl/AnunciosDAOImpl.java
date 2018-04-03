package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.AnunciosDAO;
import daos.ClientesDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;
import modelo.Anuncio;
import modelo.Cliente;

public class AnunciosDAOImpl extends GenericDAO implements AnunciosDAO {

	@Override
	public void registrarAnuncio(Anuncio anuncio) {

		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.INSERCION_ANUNCIO);
			ps.setString(1, anuncio.getTitulo());
			ps.setString(2, anuncio.getDescripcion());
			ps.setString(3, anuncio.getDireccion());
			ps.setString(4, anuncio.getPoblacion());
			ps.setDouble(5, anuncio.getPrecio());
			ps.setInt(6, anuncio.getNhabitaciones());
			ps.setInt(7, anuncio.getClie());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al registrar el anuncio en la base de datos");
			e.printStackTrace();
		}

		desconectar();
	}// end registrarAnuncio

	@Override
	public List<Anuncio> obtenerAnuncios() {
		conectar();

		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.SELECCION_ANUNCIOS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Anuncio anuncio = new Anuncio();
				anuncio.setTitulo(rs.getString("titulo"));
				anuncio.setDescripcion(rs.getString("descripcion"));
				anuncio.setDireccion(rs.getString("direccion"));
				anuncio.setPoblacion(rs.getString("poblacion"));
				anuncio.setPrecio(rs.getDouble("precio"));
				anuncio.setNhabitaciones(rs.getInt("Nhabitaciones"));
				anuncio.setId(rs.getInt("id"));

				// hacemos otra consulta para localizar el cliente a traves del id
				int client = rs.getInt("cliente");
				ClientesDAO daoClientes = new UsuarioDAOImpl();
				List<Cliente> c = daoClientes.obtenerUsuarioAeditar(client);
				anuncio.setCliente(c.get(0));
				// fin localizar cliente

				anuncios.add(anuncio);
			} // end while
		} catch (SQLException e) {
			System.out.println("Error en la obtencion de Anuncios");
			e.printStackTrace();
		} // end catch

		desconectar();
		return anuncios;

	}// end obtenerAnuncios

	@Override
	public void borrarAnuncio(int id) {

		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.BORRAR_ANUNCIO);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al BORRAR el anuncio en la base de datos: 	" + id);
			e.printStackTrace();
		}

		desconectar();
	}

	@Override
	public Anuncio obtenerAnuncioPorId(int id) {

		conectar();
		Anuncio anuncio = new Anuncio();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.OBTENER_ANUNCIO_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				/*
				 * TODO revisar metodo anuncio.setAnuncio(rs.getString("titulo"));
				 * anuncio.setPrecio(rs.getDouble("precio"));
				 * anuncio.setDescripcion(rs.getString("descripcion"));
				 * anuncio.setTelefono(rs.getString("telefono"));
				 * anuncio.setEmail(rs.getString("email")); anuncio.setId(id);
				 */
			}
			ps.close();

		} catch (SQLException e) {
			System.out.println("Error al obtener el anuncio por id");
			e.printStackTrace();
		}

		System.out.println("ANUNCIOdaOiMPL: " + anuncio.toString());
		desconectar();
		return anuncio;

	}

	@Override
	public void guardarCambiosAnuncio(Anuncio anuncio) {

		System.out.println(anuncio.toString());
		conectar();
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_ANUNCIO);
			ps.setString(1, anuncio.getTitulo());
			ps.setString(2, anuncio.getDescripcion());
			ps.setString(3, anuncio.getDireccion());
			ps.setString(4, anuncio.getPoblacion());
			ps.setDouble(5, anuncio.getPrecio());
			ps.setInt(6, anuncio.getNhabitaciones());
			ps.setInt(7, anuncio.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al modificar los anuncios en la base de datos");
			e.printStackTrace();
		}
		System.out.println("CAMBIOS REALIZADOS EN LA TABLA ANUNCIOS");
		desconectar();
	}

	@Override
	public List<Anuncio> obtenerAnuncioAeditar(int id) {
		conectar();

		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.SELECCION_ANUNCIO_EXCLUSIVO);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				Anuncio anuncio = new Anuncio();
				anuncio.setTitulo(rs.getString("titulo"));
				anuncio.setDescripcion(rs.getString("descripcion"));
				anuncio.setDireccion(rs.getString("direccion"));
				anuncio.setPoblacion(rs.getString("poblacion"));
				anuncio.setPrecio(rs.getDouble("precio"));
				anuncio.setNhabitaciones(rs.getInt("Nhabitaciones"));
				anuncio.setId(rs.getInt("id"));

				// hacemos otra consulta para localizar el cliente a traves del id
				int client = rs.getInt("cliente");
				ClientesDAO daoClientes = new UsuarioDAOImpl();
				List<Cliente> c = daoClientes.obtenerUsuarioAeditar(client);
				anuncio.setCliente(c.get(0));
				// fin localizar cliente

				anuncios.add(anuncio);
			} // end while
		} catch (SQLException e) {
			System.out.println("Error en la obtencion de Anuncios");
			e.printStackTrace();
		} // end catch

		desconectar();
		return anuncios;
	}

	@Override
	public void borrarAnuncioUser(int id, int client) {
		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.BORRAR_ANUNCIO);
			ps.setInt(1, id);
			ps.setInt(2, client);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al BORRAR el anuncio en la base de datos: 	" + id);
			e.printStackTrace();
		}

		desconectar();
		
	}

}
