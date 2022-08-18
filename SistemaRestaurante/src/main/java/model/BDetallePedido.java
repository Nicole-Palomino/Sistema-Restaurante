package model;

public class BDetallePedido {
	private String cod_detalle;
	private int cantidad;
	private Double precioventa;
	private String idproducto;
	private String idpedido;
	private String estado;
	
	public String getCod_detalle() {
		return cod_detalle;
	}
	public void setCod_detalle(String cod_detalle) {
		this.cod_detalle = cod_detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}
	public String getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	public String getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}	
