package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LivrosDAO;
import br.edu.ifsul.modelo.Livros;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@ManagedBean(name = "controleRelatorios")
@SessionScoped
public class ControleRelatorios implements Serializable {
    @EJB
    private LivrosDAO<Livros> daoLivros;

    public ControleRelatorios() {
    }

    public void imprimeRelatorioLivros(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("RelatorioLivrosJavaBeans", parametros,
                daoLivros.getListaTodos());
    }
    
    public LivrosDAO<Livros> getDaoLivros() {
        return daoLivros;
    }

    public void setDaoLivros(LivrosDAO<Livros> daoLivros) {
        this.daoLivros = daoLivros;
    }

}