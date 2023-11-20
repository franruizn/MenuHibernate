/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
//Atributos de la tabla usuario

    @Id
    @Column(name = "idusuario")
    private String idusuario;
    @Column(name = "pass")
    private String pass;
    @Column(name = "rol")
    private int rol;

//constructores
    public Usuario() {
    }

    public Usuario(String idusuario, String pass, int rol) {
        this.idusuario = idusuario;
        this.pass = pass;
        this.rol = rol;
    }

    public Usuario(String dni) {
        this.idusuario = dni;
        pass = "CAMBIAR";
        rol = 2;
    }

    //metodos
    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", pass=" + pass + ", rol=" + rol + '}';
    }

    //Relaciones Hibernate
    //Relaciones con doctor
    @OneToOne(mappedBy = "usuario", cascade = {CascadeType.ALL})
    private Doctor doctor;

    //metodos para gestionar doctores
    public Doctor getDoctor() {
        return doctor;
    }

    public void addDoctores(Doctor c) {

        doctor = c;
        c.setUsuario(this);

    }

}
