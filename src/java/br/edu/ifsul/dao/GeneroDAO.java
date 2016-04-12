
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Genero;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class GeneroDAO implements Serializable {
    @PersistenceContext(unitName = "trabalhoTA-WEBPU")
    private EntityManager em;
    private List<Genero> listarTodos;

    public GeneroDAO() {
    }
    
    public void persist(Genero obj) throws Exception{
        em.persist(obj);
    }
    
    public void merge(Genero obj) throws Exception{
        em.merge(obj);
    }
    
    public void remove(Genero obj) throws Exception{
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    
    public Genero getObjectById(Integer id) throws Exception{
        return (Genero) em.find(Genero.class, id);
    }
    
    
    public List<Genero> getListarTodos() {
        return em.createQuery("from Genero").getResultList();
    }    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }



    public void setListarTodos(List<Genero> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
