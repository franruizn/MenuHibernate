/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
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
@Table (name = "consulta"+ "")
class Consulta {
    private static final long serialVersionUID = 1L;
	//Atributos
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idconsulta")
	private int idConsulta;
	@Column (name = "fk_idpaciente")
	private int fk_IdPaciente;
	@Column (name = "fk_idpaciente")
	private int fk_idPaciente;
        @Column (name = "observaciones")
	private String observaciones;
        @Column (name = "fecha")
	private Date fecha;

    public Consulta() {
    }

    public Consulta(int idConsulta, int fk_IdPaciente, int fk_idPaciente, String observaciones, Date fecha) {
        this.idConsulta = idConsulta;
        this.fk_IdPaciente = fk_IdPaciente;
        this.fk_idPaciente = fk_idPaciente;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getFk_IdPaciente() {
        return fk_IdPaciente;
    }

    public void setFk_IdPaciente(int fk_IdPaciente) {
        this.fk_IdPaciente = fk_IdPaciente;
    }

    public int getFk_idPaciente() {
        return fk_idPaciente;
    }

    public void setFk_idPaciente(int fk_idPaciente) {
        this.fk_idPaciente = fk_idPaciente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    //Relaciones Hibernate
        //Relacion Con Tratamiento
        @ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "fk_idtratamiento")
        private Tratamiento tratamiento;

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
        
}
