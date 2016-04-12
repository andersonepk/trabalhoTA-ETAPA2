
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Livros;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class LivrosDAO implements Serializable {
    @PersistenceContext(unitName = "trabalhoTA-WEBPU")
    private EntityManager em;
    private List<Livros> listarTodos;

    public LivrosDAO() {
    }
    
    public void persist(Livros obj) throws Exception{
        em.persist(obj);
    }
    
    public void merge(Livros obj) throws Exception{
        em.merge(obj);
    }
    
    public void remove(Livros obj) throws Exception{
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    
    public Livros getObjectById(Integer id) throws Exception{
        return (Livros) em.find(Livros.class, id);
    }
    
    
    public List<Livros> getListarTodos() {
        return em.createQuery("from Livros").getResultList();
    }    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }



    public void setListarTodos(List<Livros> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
