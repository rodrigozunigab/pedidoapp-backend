package cl.zuniga.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.zuniga.model.Chofer;
import cl.zuniga.repo.IChoferRepo;
import cl.zuniga.service.IChoferService;

@Service
public class ChoferServiceImpl implements IChoferService{

	@Autowired	
	private IChoferRepo repo;
	
	@Override
	public Chofer registrar(Chofer obj) {
		return repo.save(obj);
	}

	@Override
	public Chofer modificar(Chofer obj) {
		return repo.save(obj);
	}

	@Override
	public List<Chofer> listar() {
		return repo.findAll();
	}

	@Override
	public Chofer leerPorId(Integer id) {
		Optional<Chofer> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Chofer();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
