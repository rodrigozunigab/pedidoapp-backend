package cl.zuniga.dto;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import cl.zuniga.model.Cliente;
import cl.zuniga.model.DetallePedido;

public class PedidoDTO  extends ResourceSupport{

	private Integer idPedido;
	private Cliente cliente;
	private List<DetallePedido> pedidoDetalle;
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
	public List<DetallePedido> getPedidoDetalle() {
		return pedidoDetalle;
	}
	public void setPedidoDetalle(List<DetallePedido> pedidoDetalle) {
		this.pedidoDetalle = pedidoDetalle;
	}
	
	
}
