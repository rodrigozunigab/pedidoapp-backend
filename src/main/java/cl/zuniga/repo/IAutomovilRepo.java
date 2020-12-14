package cl.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.zuniga.model.Automovil;

public interface IAutomovilRepo extends JpaRepository<Automovil, Integer> {

}
