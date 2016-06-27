package br.edu.ifsul.controle;

import br.edu.ifsul.dao.GeneroDAO;
import br.edu.ifsul.modelo.Genero;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@ManagedBean(name = "controleGenero")
@SessionScoped
public class ControleGenero implements Serializable {

    @EJB
    private GeneroDAO dao;
    private Genero objeto;

    public ControleGenero() {
    }

    public String listar() {
        return "/privado/genero/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Genero();
        return "form";
    }

    public void salvar(){
        try {
            if(objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            UtilMensagem.mensagemInformacao("Objeto persistido com sucesso");
   
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro ao persistir: "+e.getMessage());
        
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = (Genero) dao.getObjectById(id);
         
        } catch (Exception e){
            UtilMensagem.mensagemErro("Erro ao recuperar obejto: "+e.getMessage());
     
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = (Genero) dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro a remover objeto: "+e.getMessage());
        }
    }

    public GeneroDAO getDao() {
        return dao;
    }

    public void setDao(GeneroDAO dao) {
        this.dao = dao;
    }

    public Genero getObjeto() {
        return objeto;
    }

    public void setObjeto(Genero objeto) {
        this.objeto = objeto;
    }
}
