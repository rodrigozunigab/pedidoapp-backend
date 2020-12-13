package cl.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.zuniga.model.Cliente;



public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
