/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Doctor;
import Modelo.Especialidad;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ControladorHibernate {

    //Instanciamos el Session Factory
    private SessionFactory instancia;
    private Session sesion;

    //Creamos el Constructor de la clase
    public ControladorHibernate() {
        instancia = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Especialidad.class)
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();

    }

    //Creamos el metodo Instertar
    public void insertar(Object objeto) {
        sesion = instancia.openSession();
        sesion.beginTransaction();
        sesion.save(objeto);
        sesion.getTransaction().commit();
        sesion.close();
    }

    //Creamos el metodo Delete
    public void delete(Object objeto) {
        sesion = instancia.openSession();
        sesion.beginTransaction();
        sesion.delete(objeto);
        sesion.getTransaction().commit();
        sesion.close();
    }

    //Creamos el metodo Update
    public void update(Object objeto) {
        sesion = instancia.openSession();
        sesion.beginTransaction();
        sesion.update(objeto);
        sesion.getTransaction().commit();
        sesion.close();
    }

    //Creamos una consulta select 
    public ArrayList<Object> getDatos(Class<?> clase) {
        sesion = instancia.openSession();
        sesion.beginTransaction();

        String hql = "FROM " + clase.getSimpleName().toLowerCase();

        Query<Object> consulta = (Query<Object>) sesion.createQuery(hql, clase);
        List<Object> result = consulta.getResultList();
        sesion.close();

        return (ArrayList<Object>) result;
    }

    //Creamos una consulta select Where
    public ArrayList<Object> getDatosWhere(Class<?> clase, String condicion, String valor) {
        sesion = instancia.openSession();
        sesion.beginTransaction();

        String hql = "FROM " + clase.getSimpleName().toLowerCase() + " WHERE " + condicion + " =: " + valor;

        Query<Object> consulta = (Query<Object>) sesion.createQuery(hql, clase);
        consulta.setParameter(condicion, valor);
        List<Object> result = consulta.getResultList();
        sesion.close();

        return (ArrayList<Object>) result;
    }
}
