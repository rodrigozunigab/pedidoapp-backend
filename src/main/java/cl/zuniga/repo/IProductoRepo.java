package cl.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.zuniga.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
