package cl.zuniga.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.zuniga.model.Pedido;

public interface IPedidoRepo  extends JpaRepository<Pedido, Integer>{

}
