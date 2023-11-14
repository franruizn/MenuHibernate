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
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author usuario
 */
public class ControladorHibernate {

    private SessionFactory instancia;
    private Session sesion;

    public ControladorHibernate() {
        instancia = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Especialidad.class)
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();
        
        
    }

    public void insertar(Object objeto) {
        sesion = instancia.openSession();
        sesion.beginTransaction();
        sesion.save(objeto);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public void delete (Object objeto){
        sesion = instancia.openSession();
        sesion.beginTransaction();
        sesion.delete(objeto);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public void update(Object objeto) {
        sesion = instancia.openSession();
        sesion.beginTransaction();
        sesion.update(objeto);
        sesion.getTransaction().commit(); 
        sesion.close();
    }
    
    public ArrayList<Object> getDatos(Class<?> clase){
        sesion = instancia.openSession();
        sesion.beginTransaction();
        
        String hql = "FROM " + clase.getSimpleName().toLowerCase();
        
        Query<Object> consulta =(Query<Object>) sesion.createQuery(hql,clase);
        List<Object> result = consulta.getResultList();
        sesion.close();
        
        return (ArrayList<Object>) result;
    }
    
    public ArrayList<Object> getDatosWhere(Class<?> clase, String condicion, String valor){
        sesion = instancia.openSession();
        sesion.beginTransaction();
        
        String hql = "FROM " + clase.getSimpleName().toLowerCase() + " WHERE " + condicion + " =: " + valor;
        
        
        Query<Object> consulta = (Query<Object>) sesion.createQuery(hql, clase);
        consulta.setParameter(condicion, valor);
        List<Object> result = consulta.getResultList();
        sesion.close();
        
        return (ArrayList<Object>) result;
    }

    public Session getSesion() {
        return sesion = instancia.openSession();
    }
    
    
}
