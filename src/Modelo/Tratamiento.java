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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tratamiento"
        + "")
public class Tratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
	//Atributos
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idtratamiento")
	private int idTratamiento;
	@Column (name = "nombre")
	private String nombre;
	@Column (name = "precio")
	private int precio;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String nombre, int precio) {
        this.idTratamiento = idTratamiento;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
      
    //Relaciones Hibernate
        
        @OneToMany(mappedBy="tratamiento_consulta",cascade = {CascadeType.ALL})
	 
        private List<Consulta> consulta;

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void addConsulta(Consulta c) {
        if(consulta==null) consulta=new ArrayList<>();
        consulta.add(c);
        c.setFk_idTratamiento(idTratamiento);
        
    }
        
}
