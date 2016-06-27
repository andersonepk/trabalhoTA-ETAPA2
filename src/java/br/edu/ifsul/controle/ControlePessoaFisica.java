
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.LivrosDAO;
import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.modelo.Livros;

import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlePessoaFisica")
@SessionScoped
public class ControlePessoaFisica implements Serializable {
    
    @EJB
    private PessoaFisicaDAO<PessoaFisica> dao;
    private PessoaFisica objeto;   
    private Livros livros;
    @EJB
    private LivrosDAO<Livros> daoLivros;
   
    
            

    public ControlePessoaFisica() {
        
    }
    
    public String listar(){
        return "/privado/pessoa_fisica/listar?faces-redirect=true";
    }
    
      public void adicionarReserva(){
        if (livros != null){
            if(!objeto.getReservam().contains(livros)){
                objeto.getReservam().add(livros);
                UtilMensagem.mensagemInformacao("Reserva adicionado com sucesso");
            } else {
                UtilMensagem.mensagemErro("Livro já existe na lista");
            } 
        }
    }
    
    public void removerReserva(int index){
        livros = objeto.getReservam().get(index);
        objeto.getReservam().remove(livros);
        UtilMensagem.mensagemInformacao("Reserva removido com sucesso!");
    }
    
        
    public void novo(){
        objeto = new PessoaFisica();        
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
           objeto = (PessoaFisica) getDao().getObjectById(id);
        } catch (Exception e){
            UtilMensagem.mensagemErro("Erro ao recuperar obejto: "+e.getMessage());            
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = (PessoaFisica) getDao().getObjectById(id);
            getDao().remove(objeto);
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro a remover objeto: "+e.getMessage());
        }
    }

    public PessoaFisicaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDAO dao) {
        this.dao = dao;
    }

    public PessoaFisica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaFisica objeto) {
        this.objeto = objeto;
    }

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
        this.livros = livros;
    }

    public LivrosDAO<Livros> getDaoLivros() {
        return daoLivros;
    }

    public void setDaoLivros(LivrosDAO<Livros> daoLivros) {
        this.daoLivros = daoLivros;
    }

      
}
