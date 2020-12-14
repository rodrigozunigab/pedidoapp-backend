package cl.zuniga.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.zuniga.exception.ModeloNotFoundException;
import cl.zuniga.model.Automovil;
import cl.zuniga.service.IAutomovilService;


@RestController
@RequestMapping("/automovil")
public class AutomovilController {
	@Autowired
	private IAutomovilService service;
	
	@GetMapping
	public ResponseEntity<List<Automovil>> listar(){
		List<Automovil> lista = service.listar();
		return new ResponseEntity<List<Automovil>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Automovil> listarPorId(@PathVariable("id") Integer id){
		Automovil obj = service.leerPorId(id);
		if(obj.getIdAutomovil() == null) {
			throw new ModeloNotFoundException("ID Automovil NO ENCONTRADO(1) " + id);
		}
		return new ResponseEntity<Automovil>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Automovil o) {
		Automovil obj = service.registrar(o);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getIdAutomovil()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Automovil> modificar(@Valid @RequestBody Automovil o) {
		Automovil obj = service.modificar(o);
		return new ResponseEntity<Automovil>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Automovil obj = service.leerPorId(id);
		if(obj.getIdAutomovil() == null) {
			throw new ModeloNotFoundException("ID Automovil NO ENCONTRADO(2) " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}	
}
