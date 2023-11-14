/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author usuario
 */
@Entity
@Table (name = "doctor")

public class Doctor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "iddoctor")
	private int idDoctor;
	@Column (name = "fk_idusuario")
	private int fk_idUsuario;
	@Column (name = "nombre")
	private String nombre;
	@Column (name = "fk_idespecialidad")
	private String especialidad;
	
	//Constructores
	public Doctor() {
		
	}
	
	public Doctor(int iddoctor, int fk_idusuario, int fk_idespecialidad, String nombre) {
		this.idDoctor = iddoctor;
		this.fk_idUsuario = fk_idusuario;
		especialidad = Integer.toString(fk_idespecialidad);
		this.nombre = nombre;
	}
        //asdasdasd
	
	//Métodos
	public int getIddoctor() {
		return idDoctor;
	}

	public void setIddoctor(int iddoctor) {
		this.idDoctor = iddoctor;
	}

	public int getFk_idusuario() {
		return fk_idUsuario;
	}

	public void setFk_idusuario(int fk_idusuario) {
		this.fk_idUsuario = fk_idusuario;
	}

	public String getFk_idespecialidad() {
		return especialidad;
	}

	public void setFk_idespecialidad(int fk_idespecialidad) {
		this.especialidad = Integer.toString(fk_idespecialidad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
		
	
}
