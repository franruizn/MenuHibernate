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

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctor")
    private int idDoctor;
    @Column(name = "nombre")
    private String nombre;

    //Constructores
    public Doctor() {

    }

    public Doctor(int iddoctor, String nombre) {
        this.idDoctor = iddoctor;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Relaciones Hibernate
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_idespecialidad")
    private Especialidad especialidad;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_idusuario")
    private Usuario usuario;

    public Especialidad especialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad_doctor) {
        this.especialidad = especialidad_doctor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
