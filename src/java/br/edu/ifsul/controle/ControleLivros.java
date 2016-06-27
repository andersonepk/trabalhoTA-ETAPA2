/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.GeneroDAO;
import br.edu.ifsul.dao.LivrosDAO;
import br.edu.ifsul.modelo.Livros;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "controleLivros")
@SessionScoped
public class ControleLivros implements Serializable {
    
    @EJB
    private LivrosDAO dao;
    private Livros objeto;
    @EJB
    private GeneroDAO daoGenero;
    
    public ControleLivros() {

    }

    public String listar() {
        return "/privado/livros/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Livros();

    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
         
            }
            UtilMensagem.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            UtilMensagem.mensagemErro(e.getMessage());
        }

    }

    public void editar(Integer id) {
        try {
         objeto = (Livros) dao.getObjectById(id);
    
        } catch (Exception e) {
            UtilMensagem.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }

    }

    public void remover(Integer id) {
        try {
           objeto = (Livros) dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");

        } catch (Exception e) {

            UtilMensagem.mensagemErro("Erro ao remover o objeto " + e.getMessage());
        }
    }

    public LivrosDAO getDao() {
        return dao;
    }

    public void setDAO(LivrosDAO dao) {
        this.dao = dao;
    }

    public Livros getObjeto() {
        return objeto;
    }

    public void setObjeto(Livros objeto) {
        this.objeto = objeto;
    }

    public GeneroDAO getDaoGenero() {
        return daoGenero;
    }

    public void setDaoGenero(GeneroDAO daoGenero) {
        this.daoGenero = daoGenero;
    }



}
