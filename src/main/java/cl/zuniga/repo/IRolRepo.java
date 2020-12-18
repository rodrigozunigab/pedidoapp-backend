package cl.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import cl.zuniga.model.Rol;

public interface IRolRepo extends JpaRepository<Rol, Integer> {

}
