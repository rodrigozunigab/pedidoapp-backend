package cl.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.zuniga.model.Chofer;

public interface IChoferRepo extends JpaRepository<Chofer, Integer>  {

}
