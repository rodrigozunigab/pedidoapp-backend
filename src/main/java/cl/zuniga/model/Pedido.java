package cl.zuniga.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name="FK_cliente_pedido"))
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_chofer", nullable = false, foreignKey = @ForeignKey(name="FK_chofer_pedido"))
	private Chofer chofer;

	@ManyToOne
	@JoinColumn(name = "id_automovil", nullable = false, foreignKey = @ForeignKey(name="FK_automovil_pedido"))
	private Automovil automovil;
	
	private LocalDateTime fechaSolicitud;
	
	private LocalDateTime fechaEntrega;
	
	private LocalDateTime fechaPago;
	
	@Column(name = "valorPedido")
	private BigDecimal valorPedido;
	
	@Column(name = "valorPagado")
	private BigDecimal valorPagado;
	
	@OneToMany(mappedBy = "pedido", cascade = {CascadeType.ALL },orphanRemoval = true)
	private List<PedidoDetalle> pedidoDetalle;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public LocalDateTime getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public List<PedidoDetalle> getPedidoDetalle() {
		return pedidoDetalle;
	}

	public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
		this.pedidoDetalle = pedidoDetalle;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public BigDecimal getValorPagado() {
		return valorPagado;
	}

	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}
	
	
}
