package cl.zuniga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "automovil")
public class Automovil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idAutomovil;
	
	@Size(min = 6, message = "patente debe tener minimo 6 caracteres")
	@Column(name = "patente",nullable = false, length = 20)
	private String patente;
	
	@Column(name = "color", length = 100)
	private String color;
	
	@Column(name = "marca", length = 100)
	private String marca;
	
	@Column(name = "agno")
	private Integer agno;
	
	@Column(name = "activo", length = 1)
	private String activo;

	public Integer getIdAutomovil() {
		return idAutomovil;
	}

	public void setIdAutomovil(Integer idAutomovil) {
		this.idAutomovil = idAutomovil;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAgno() {
		return agno;
	}

	public void setAgno(Integer agno) {
		this.agno = agno;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
}
