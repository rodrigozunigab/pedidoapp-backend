package cl.zuniga.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import cl.zuniga.dto.PedidoDTO;
import cl.zuniga.exception.ModeloNotFoundException;
import cl.zuniga.model.Pedido;
import cl.zuniga.service.IPedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private IPedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listar(){
		List<Pedido> lista = service.listar();
		return new ResponseEntity<List<Pedido>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> listarPorId(@PathVariable("id") Integer id){
		Pedido obj = service.leerPorId(id);
		if(obj.getIdPedido() == null) {
			throw new ModeloNotFoundException("ID Pedido NO ENCONTRADO(1) " + id);
		}
		return new ResponseEntity<Pedido>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Pedido o) {
		Pedido obj = service.registrar(o);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getIdPedido()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Pedido> modificar(@Valid @RequestBody Pedido o) {
		Pedido obj = service.modificar(o);
		return new ResponseEntity<Pedido>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Pedido obj = service.leerPorId(id);
		if(obj.getIdPedido() == null) {
			throw new ModeloNotFoundException("ID Pedido NO ENCONTRADO(2) " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}	
	
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoDTO> listarHateoas() {
		List<Pedido> pedido = new ArrayList<>();
		List<PedidoDTO> pedidoDTO = new ArrayList<>();
		pedido = service.listar();
		
		for (Pedido c : pedido) {
			PedidoDTO d = new PedidoDTO();
			d.setIdPedido(c.getIdPedido());
			d.setCliente(d.getCliente());
			d.setPedidoDetalle(c.getDetallePedido());
						
			ControllerLinkBuilder linkTo1 = linkTo(methodOn(ClienteController.class).listarPorId((c.getCliente().getIdCliente())));
			d.add(linkTo1.withSelfRel());
			pedidoDTO.add(d);
			
		}
		return pedidoDTO;
	}
	
	
	
}
