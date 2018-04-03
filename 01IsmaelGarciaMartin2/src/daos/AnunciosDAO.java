package daos;

import java.util.List;

import modelo.Anuncio;

public interface AnunciosDAO {
	
	void registrarAnuncio(Anuncio anuncio);
	List<Anuncio> obtenerAnuncios();
	void borrarAnuncio(int id);
	void borrarAnuncioUser(int id, int client);
	Anuncio obtenerAnuncioPorId(int id);
	void guardarCambiosAnuncio(Anuncio anuncio);
	List<Anuncio> obtenerAnuncioAeditar(int id);

}
