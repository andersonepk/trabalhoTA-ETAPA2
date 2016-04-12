package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PromocaoDAO;
import br.edu.ifsul.dao.LivrosDAO;
import br.edu.ifsul.modelo.Promocao;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "controlePromocao")
@SessionScoped
public class ControlePromocao implements Serializable {

    @EJB
    private PromocaoDAO dao;
    private Promocao objeto;
    @EJB
    private LivrosDAO daoLivros;

    public ControlePromocao() {
    }

    public String listar() {
        return "/privado/promocao/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Promocao();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            UtilMensagem.mensagemInformacao("Objeto persistido com sucesso");

        } catch (Exception e) {
            UtilMensagem.mensagemErro("Erro ao persistir: " + e.getMessage());

        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);

        } catch (Exception e) {
            UtilMensagem.mensagemErro("Erro ao recuperar obejto: " + e.getMessage());

        }
    }

    public void remover(Integer id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            UtilMensagem.mensagemErro("Erro a remover objeto: " + e.getMessage());
        }
    }

    public PromocaoDAO getDao() {
        return dao;
    }

    public void setDao(PromocaoDAO dao) {
        this.dao = dao;
    }

    public Promocao getObjeto() {
        return objeto;
    }

    public void setObjeto(Promocao objeto) {
        this.objeto = objeto;
    }

    public LivrosDAO getDaoLivros() {
        return daoLivros;
    }

    public void setDaoLivros(LivrosDAO daoLivros) {
        this.daoLivros = daoLivros;
    }
}
