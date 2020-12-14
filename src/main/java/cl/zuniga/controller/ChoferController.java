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
import cl.zuniga.model.Chofer;
import cl.zuniga.service.IChoferService;

@RestController
@RequestMapping("/choferes")
public class ChoferController  {

	@Autowired
	private IChoferService service;
	
	@GetMapping
	public ResponseEntity<List<Chofer>> listar(){
		List<Chofer> lista = service.listar();
		return new ResponseEntity<List<Chofer>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Chofer> listarPorId(@PathVariable("id") Integer id){
		Chofer obj = service.leerPorId(id);
		if(obj.getId() == null) {
			throw new ModeloNotFoundException("ID Chofer NO ENCONTRADO(1) " + id);
		}
		return new ResponseEntity<Chofer>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Chofer o) {
		Chofer obj = service.registrar(o);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Chofer> modificar(@Valid @RequestBody Chofer o) {
		Chofer obj = service.modificar(o);
		return new ResponseEntity<Chofer>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Chofer obj = service.leerPorId(id);
		if(obj.getId() == null) {
			throw new ModeloNotFoundException("ID Chofer NO ENCONTRADO(2) " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}	
	
}
