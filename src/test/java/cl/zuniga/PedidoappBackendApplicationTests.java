package cl.zuniga;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import cl.zuniga.model.Rol;
import cl.zuniga.model.Usuario;
import cl.zuniga.repo.IRolRepo;
import cl.zuniga.repo.IUsuarioRepo;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoappBackendApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private IRolRepo repoRol;	
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("usuario_taller@gmail.com");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);
		
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}
	
	@Test
	public void crearRolAdmin() {
		Rol rol = new Rol();
		rol.setIdRol(1);
		rol.setNombre("ADMIN");
		rol.setDescripcion("Administrador");		
		Rol retorno = repoRol.save(rol);		
		assertTrue(retorno.getNombre().equalsIgnoreCase(rol.getNombre()));
	}	
	
	@Test
	public void crearRolUsuario() {
		Rol rol = new Rol();
		rol.setIdRol(2);
		rol.setNombre("USER");
		rol.setDescripcion("Usuario");		
		Rol retorno = repoRol.save(rol);		
		assertTrue(retorno.getNombre().equalsIgnoreCase(rol.getNombre()));
	}	

	@Test
	public void crearRolDBA() {
		Rol rol = new Rol();
		rol.setIdRol(3);
		rol.setNombre("DBA");
		rol.setDescripcion("Admin de BD");		
		Rol retorno = repoRol.save(rol);		
		assertTrue(retorno.getNombre().equalsIgnoreCase(rol.getNombre()));
	}	
}
