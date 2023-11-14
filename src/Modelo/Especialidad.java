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
import javax.persistence.FetchType;
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
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idespecialidad")
    private int idEspecialidad;
    @Column(name = "nombre")
    private String nombre;


    public Especialidad() {
    }

    public Especialidad(int idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    public Especialidad(int especialidad) {
        this.idEspecialidad = especialidad;
    }

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

    //Relaciones Hibernate

    @OneToMany(mappedBy = "especialidad_doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Doctor> doctores;

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void addDoctores(Doctor a) {
        if (doctores == null) {
            doctores = new ArrayList<>();
        }
        doctores.add(a);
        //a.setEspecialidad(this);
    }


}
