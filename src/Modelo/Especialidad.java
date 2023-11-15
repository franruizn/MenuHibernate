/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    //Atributos de la tabla especialidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idespecialidad")
    private int idEspecialidad;
    @Column(name = "nombre")
    private String nombre;

    //Constructores 
    public Especialidad() {
    }

    public Especialidad(int idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    public Especialidad(int especialidad) {
        this.idEspecialidad = especialidad;
        nombre = "Nueva Especialidad";
    }

    //Métodos
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "idEspecialidad=" + idEspecialidad + ", nombre=" + nombre + '}';
    }
    
    

    //Relaciones Hibernate
    //Relacion con doctor
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL)
    private List<Doctor> doctores;

    //Metodos para gestionar doctores
    public List<Doctor> getDoctor() {
        return doctores;
    }

    public void addDoctores(Doctor c) {
        if (doctores == null) {
            doctores = new ArrayList<>();
        }
        doctores.add(c);
        c.setEspecialidad(this);

    }
}
