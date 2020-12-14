package cl.zuniga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "chofer")
public class Chofer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idChofer;

	@Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;

	@Column(name = "direccion", length = 50)
	private String direccion;

	@Size(min = 9, max = 9, message = "Telefono debe tener minimo 9 caracteres")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	@Column(name = "activo", length = 1)
	private String activo;	

	public Integer getId() {
		return idChofer;
	}
	
	public Integer getIdChofer() {
		return idChofer;
	}

	public void setIdChofer(Integer idChofer) {
		this.idChofer = idChofer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
}
