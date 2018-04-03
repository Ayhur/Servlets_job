package modelo;

public class Anuncio {
	private String titulo, descripcion, direccion, poblacion;
	private double precio;
	private int id, clie, Nhabitaciones;
	private Cliente cliente;

	public Anuncio() {
	}

	public Anuncio(String titulo, String descripcion, String direccion, String poblacion, double precio,
			int nhabitaciones) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.precio = precio;
		this.Nhabitaciones = nhabitaciones;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClie() {
		return clie;
	}

	public void setClie(int clie) {
		this.clie = clie;
	}

	public int getNhabitaciones() {
		return Nhabitaciones;
	}

	public void setNhabitaciones(int nhabitaciones) {
		Nhabitaciones = nhabitaciones;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Anuncio [titulo=" + titulo + ", descripcion=" + descripcion + ", direccion=" + direccion
				+ ", poblacion=" + poblacion + ", precio=" + precio + ", id=" + id + ", clie=" + clie
				+ ", Nhabitaciones=" + Nhabitaciones + ", cliente=" + cliente + "]";
	}

}
