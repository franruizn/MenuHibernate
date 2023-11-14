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

@Entity
@Table (name = "tratamiento")
public class Tratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
	//Atributos
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idespecialidad")
	private int idEspecialidad;
	@Column (name = "nombre")
	private int nombre;

    public Tratamiento() {
    }

    public Tratamiento(int idEspecialidad, int nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
	
}
