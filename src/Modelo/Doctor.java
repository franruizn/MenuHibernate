/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "doctor")

public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    //Atributos de la tabla doctor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctor")
    private int idDoctor;
    @Column(name = "nombre")
    private String nombre;

    //Constructores 
    public Doctor() {
    }

    public Doctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Doctor(int iddoctor, String nombre) {
        this.idDoctor = iddoctor;
        this.nombre = nombre;
    }

    //Métodos
    public int getIddoctor() {
        return idDoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.idDoctor = iddoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Doctor{" + "idDoctor=" + idDoctor + ", nombre=" + nombre + ", especialidad=" + especialidad + ", usuario=" + usuario + '}';
    }
    
    
    //Relaciones Hibernate
    //Relaciones con Especialidad
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_idespecialidad",referencedColumnName="idespecialidad",insertable=false,updatable=false)
    private Especialidad especialidad;

    //Relaciones con Usuario
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_idusuario",referencedColumnName="idusuario",insertable=false,updatable=false)
    private Usuario usuario;

    //Metodos para gestionar especialidad
    public Especialidad especialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad_doctor) {
        this.especialidad = especialidad_doctor;
    }

    //Metodos para gestionar usuarios
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
