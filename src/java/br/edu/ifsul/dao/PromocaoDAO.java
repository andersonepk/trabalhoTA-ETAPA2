
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Promocao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PromocaoDAO implements Serializable {
    @PersistenceContext(unitName = "trabalhoTA-WEBPU")
    private EntityManager em;
    private List<Promocao> listarTodos;

    public PromocaoDAO() {
    }
    
    public void persist(Promocao obj) throws Exception{
        em.persist(obj);
    }
    
    public void merge(Promocao obj) throws Exception{
        em.merge(obj);
    }
    
    public void remove(Promocao obj) throws Exception{
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    
    public Promocao getObjectById(Integer id) throws Exception{
        return (Promocao) em.find(Promocao.class, id);
    }
    
    
    public List<Promocao> getListarTodos() {
        return em.createQuery("from Promocao").getResultList();
    }    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }



    public void setListarTodos(List<Promocao> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
