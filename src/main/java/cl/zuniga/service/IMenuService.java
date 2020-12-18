package cl.zuniga.service;

import java.util.List;

import cl.zuniga.model.Menu;



public interface IMenuService extends ICRUD<Menu> {
	List<Menu> listarMenuPorUsuario(String nombre);
}
