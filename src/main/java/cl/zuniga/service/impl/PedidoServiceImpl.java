package cl.zuniga.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.zuniga.model.Pedido;
import cl.zuniga.repo.IPedidoRepo;
import cl.zuniga.service.IPedidoService;


@Service
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired	
	private IPedidoRepo repo;
	
	@Override
	public Pedido registrar(Pedido obj) {
		return repo.save(obj);
	}

	@Override
	public Pedido modificar(Pedido obj) {
		return repo.save(obj);
	}

	@Override
	public List<Pedido> listar() {
		return repo.findAll();
	}

	@Override
	public Pedido leerPorId(Integer id) {
		Optional<Pedido> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Pedido();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}