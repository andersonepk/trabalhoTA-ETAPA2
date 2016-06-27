
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateless
public class PessoaFisicaDAO<T> extends DAOGenerico<PessoaFisica> implements Serializable {
 
    public PessoaFisicaDAO() {
        super();
        super.setClassePersistente(PessoaFisica.class);
        //super.setOrdem("nome");
    }
    
    @Override
    public PessoaFisica getObjectById(Integer id) throws Exception {
        PessoaFisica obj = (PessoaFisica) super.getEm().find(super.getClassePersistente(), id);
        // inicializando a coleção de objetos para não ocorrer lazy exception
        obj.getReservam().size(); 
        
        return obj;
    }
    
}
