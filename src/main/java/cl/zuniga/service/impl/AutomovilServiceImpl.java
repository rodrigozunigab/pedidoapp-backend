package cl.zuniga.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.zuniga.model.Automovil;
import cl.zuniga.repo.IAutomovilRepo;
import cl.zuniga.service.IAutomovilService;

@Service
public class AutomovilServiceImpl implements IAutomovilService{
	
	@Autowired	
	private IAutomovilRepo repo;
	
	@Override
	public Automovil registrar(Automovil obj) {
		return repo.save(obj);
	}

	@Override
	public Automovil modificar(Automovil obj) {
		return repo.save(obj);
	}

	@Override
	public List<Automovil> listar() {
		return repo.findAll();
	}

	@Override
	public Automovil leerPorId(Integer id) {
		Optional<Automovil> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Automovil();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
