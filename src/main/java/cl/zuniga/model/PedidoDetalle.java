package cl.zuniga.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_pedido")
public class PedidoDetalle {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedidoDetalle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false, foreignKey = @ForeignKey(name = "FK_pedido_detalle"))
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name="FK_producto_pedido"))
	private Producto Producto;
	
	@Column(name = "cantidadSolicitada")
	private BigDecimal cantidadSolicitada;
	
	@Column(name = "cantidadEntregada")
	private BigDecimal cantidadEntregada;
	
	@Column(name = "observaciones", length = 500, nullable = true)
	private String observaciones;

	public Integer getIdPedidoDetalle() {
		return idPedidoDetalle;
	}

	public void setIdPedidoDetalle(Integer idPedidoDetalle) {
		this.idPedidoDetalle = idPedidoDetalle;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public BigDecimal getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(BigDecimal cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public BigDecimal getCantidadEntregada() {
		return cantidadEntregada;
	}

	public void setCantidadEntregada(BigDecimal cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Producto getProducto() {
		return Producto;
	}

	public void setProducto(Producto producto) {
		Producto = producto;
	}
	
}
