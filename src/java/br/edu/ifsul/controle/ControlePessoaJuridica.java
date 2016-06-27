
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.PessoaJuridicaDAO;

import br.edu.ifsul.modelo.PessoaJuridica;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlePessoaJuridica")
@SessionScoped
public class ControlePessoaJuridica implements Serializable {
    
    @EJB
    private PessoaJuridicaDAO<PessoaJuridica> dao;
    private PessoaJuridica objeto;     
   
    
            

    public ControlePessoaJuridica() {
    }
    
    public String listar(){
        return "/privado/pessoa_juridica/listar?faces-redirect=true";
    }
    
        
    public void novo(){
        objeto = new PessoaJuridica();        
    }
    
    public void salvar(){
        try {
            if(objeto.getId() == null){
                getDao().persist(objeto);
            } else {
                getDao().merge(objeto);
            }
            UtilMensagem.mensagemInformacao("Objeto persistido com sucesso");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro ao persistir: "+e.getMessage());            
        }
    }
    
    public void editar(Integer id){
        try {
           objeto = (PessoaJuridica) getDao().getObjectById(id);
        } catch (Exception e){
            UtilMensagem.mensagemErro("Erro ao recuperar obejto: "+e.getMessage());            
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = (PessoaJuridica) getDao().getObjectById(id);
            getDao().remove(objeto);
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro a remover objeto: "+e.getMessage());
        }
    }

    public PessoaJuridicaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaJuridicaDAO dao) {
        this.dao = dao;
    }

    public PessoaJuridica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaJuridica objeto) {
        this.objeto = objeto;
    }

      
}
