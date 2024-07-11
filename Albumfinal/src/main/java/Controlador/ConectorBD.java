/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Album;
import Modelo.Cantante;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Conti
 */
public class ConectorBD {
    
      private EntityManagerFactory emf;
    private EntityManager em;

    public ConectorBD() {
        
      
        
    }
    
     private void Sesion ()
    {
          emf=Persistence.createEntityManagerFactory("musica");
         em=emf.createEntityManager();
         
         
    }
    
    private void Cerrarsesion()
    {
    
    em.close();
}
    
     public boolean Insertar(Album a1) {
         
         boolean resul=false;
       
         Sesion();
         
         try {
             em.getTransaction().begin();
             em.persist(a1);
             em.getTransaction().commit();
             resul=true;
             
             
                         
         }catch(Exception e) {
             em.getTransaction().rollback();
             JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA", "ERROR", 0);
              
            
         }
         
         Cerrarsesion();
         return resul;
     }
     
       public boolean InsertarC(Cantante c1) {
         
         boolean resul=false;
       
         Sesion();
         
         try {
             em.getTransaction().begin();
             em.persist(c1);
             em.getTransaction().commit();
             resul=true;
             
             
                         
         }catch(Exception e) {
             em.getTransaction().rollback();
             JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA", "ERROR", 0);
              
            
         }
         
         Cerrarsesion();
         return resul;
     }
     
       public boolean Eliminar(Integer numero) {
         boolean resul=false;
         
         Sesion();
         Album c1=new Album();
         c1= (Album) em.find(Album.class,numero);
         try
         {
                em.getTransaction().begin();
                em.remove(c1);
                em.getTransaction().commit();
             
             resul=true;
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha dado de alta", "ERROR", 0);
              em.getTransaction().rollback();
            
         } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
         
          
        return resul;
      }
       
        public boolean Actualizar(Album a1) {
         boolean resul=false;
         
         Sesion();
    
         
         try
         {
                em.getTransaction().begin();
                em.merge(a1);
                em.getTransaction().commit();
             
             resul=true;
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha actualizado", "ERROR", 0);
              em.getTransaction().rollback();
            
         } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
         
          
        return resul;
      }
       
     
     
     
     
     
     public Album Buscar (Album a1)
     {
         
         
           Sesion();
    
        return em.find(Album.class, a1.getNumalbum());
     }
     
     
     public Double Consulta2(String consulta) {
          
        Double resul=0.0;
          
          
          
       
        //Inicio la sesion con HibernateUtil. No va en try-catch porque HibernateUtil ya lanza excepcion si hay fallo.
      Sesion();
        
        
        //Capturamos toda excepcion que pueda ocurrir al lanzar una consulta
        try {
            
               
            
            resul = (Double)em.createQuery(consulta).getSingleResult();
       
         
        } catch (Exception e) {
            String errQuery = "Ha ocurrido un error inesperado lanzando la consulta simple";
            System.err.println(errQuery + " " + e);
            JOptionPane.showMessageDialog(null, errQuery, "ERROR", 0);
        } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
       
        return resul;
        
    }
     
      public long Consulta(String consulta) {
          
        Long resul=12345678910L;
          
          
          
       
        //Inicio la sesion con HibernateUtil. No va en try-catch porque HibernateUtil ya lanza excepcion si hay fallo.
      Sesion();
        
        
        //Capturamos toda excepcion que pueda ocurrir al lanzar una consulta
        try {
            
               
            
            resul = (Long)em.createQuery("SELECT COUNT(a) FROM Album a").getSingleResult();
            
      
           
         
            System.out.println("Media de precios:" +  resul);
         
        } catch (Exception e) {
            String errQuery = "Ha ocurrido un error inesperado lanzando la consulta simple";
            System.err.println(errQuery + " " + e);
            JOptionPane.showMessageDialog(null, errQuery, "ERROR", 0);
        } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
       
        return resul;
        
    }
     
     
     public List lanzarConsulta(String consulta) {
        List resultList = null;
        //Inicio la sesion con HibernateUtil. No va en try-catch porque HibernateUtil ya lanza excepcion si hay fallo.
        Sesion();
        
        //Capturamos toda excepcion que pueda ocurrir al lanzar una consulta
        try {
            
                Query query = em.createQuery(consulta);

                resultList = query.getResultList();
                 
                
         
        } catch (Exception e) {
            String errQuery = "Ha ocurrido un error inesperado lanzando la consulta";
            System.err.println(errQuery);
            JOptionPane.showMessageDialog(null, errQuery, "ERROR", 0);
        } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
        return resultList;
    }
    
}
